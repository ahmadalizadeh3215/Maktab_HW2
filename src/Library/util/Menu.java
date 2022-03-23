package Library.util;

import Library.entity.Author;
import Library.entity.Book;
import Library.entity.User;
import Library.service.AuthorService;
import Library.service.BookService;
import Library.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final FakeDB fakeDB = new FakeDB();
    private final AuthorService authorService = new AuthorService(fakeDB);
    private final BookService bookService = new BookService(fakeDB);
    private final UserService userService = new UserService(fakeDB);
    private User manageUser;

    public Menu() {
    }

    public void initDependencies(){
        fakeDB.initFakeDB();
    }

    // for login use the user name and password are in fakedb class.
    private void login(){
        while (true) {
            System.out.print("User name: " + input.nextLine());
            String userName = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();

            if (userService.isUserByUserPass(userName, password)) {
                System.out.println("Login successfully!");

                manageUser = userService.getUserByUsername(userName);
                userMenuRun();
                break;
            } else {
                System.out.println("Username or password not available!\n " +
                        "Press enter to try again");

            }
        }
    }
    public static void mainMenu(){
        System.out.println("1- Find similar sur name in author table\n " +
                "2- Find all book written by an author\n  " +
                "3- Find information about a book\n   " +
                "4- Login\n" +
                "5- Exit");
    }

    public static void afterLoginMenu(){
        System.out.print("1- Borrow book\n " +
                "2- Return the book\n  " +
                "3- My fine amount!\n   " +
                "4- Log out!\n"+
                "Select one item: ");
    }

    public void userMenuRun() {
        while (true) {
            Menu.afterLoginMenu();
            int count;
            int enter = input.nextInt();
            switch (enter) {
                case 1: {
                    while (true) {
                        count = 1;
                        System.out.println("*List of available book*");

                        for (Book search : bookService.getAllBooks()) {
                            System.out.println(count + "- Book name: " + search.getName() + "\n" +
                                    "Subject: " + search.getSubject() + "\n" +
                                    "Author: " + search.getAuthor().getFirstName() + " " + search.getAuthor().getSurName() + "\n" +
                                    "Quantity: " + search.getQuantity());
                            count++;

                        }
                        System.out.print("Select one item: ");
                        enter = input.nextInt();
                        if(enter > bookService.getAllBooks().size()){
                            System.out.println();
                            System.out.println();
                            System.out.println();

                            System.out.println("Something wrong, try again!");

                            System.out.println();
                            System.out.println();
                            System.out.println();
                            continue;
                        }

                        List<Book> list = bookService.getAllBooks();
                        Book name = list.get(enter - 1);
                        if (!(bookService.isBorrow(name.getName()))) {
                            System.out.println("This book is out of stock!");
                            System.out.print("Press enter to back..." + input.nextLine());
                            input.nextLine();

                        } else {
                            if (userService.isEmptyPlace(manageUser)) {
                                System.out.println(name.getName() + " Book was successfully added to your list of borrowed books!");

                                userService.getListOfBorrow(manageUser,name);


                            } else {
                                System.out.println("You cant borrow because already you borrowed 2 books!");

                            }
                        }
                        System.out.print("You want stay in this page(Y/N): " + input.nextLine());
                        String stay = input.nextLine();

                        if ((stay.startsWith("n") || stay.startsWith("N"))) {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    boolean isEmpty = false;
                    count = 1;

                    System.out.println("***List of books borrowed by you***");

                    for (Book book : userService.getBorrowedBook(manageUser)) {
                        if(book != null) {
                            System.out.println(count + "- " + book.getName());
                            count++;
                        }
                        if(count == 1){
                            System.out.println("***Empty***");

                            System.out.print("Press enter to back..." + input.nextLine());
                            input.nextLine();
                            isEmpty = true;
                            break;
                        }
                    }
                    if(isEmpty){

                        break;
                    }

                    System.out.print("Enter the number of book for return to library: ");
                    enter = input.nextInt();
                    if(enter > 2 || enter < 1){
                        System.out.println("Something wrong, try again!");

                        break;
                    }
                    System.out.print("How many days did you borrow the book?(1, 2, 3, ... ???): ");
                    int anInt = input.nextInt();
                    if(anInt > 7){
                        System.out.println("You were fined "+ userService.calcFineAmount(anInt)+ " Tomans for "+ (anInt - 7) +" days delay");
                        userService.setFineAmount(manageUser, userService.calcFineAmount(anInt));

                    }
                    Book name = userService.getBorrowedBook(manageUser)[enter - 1];
                    userService.updateBorrowList(manageUser,name,enter);
                    System.out.println("Operation was successful\n " +
                            "Good luck!");

                    break;
                }
                case 3: {
                    System.out.print("Your fine amount: ");
                    System.out.println(userService.getFineAmountByUser(manageUser));

                    break;
                }
                case 4: {

                    return;
                }
            }
        }
    }

    public void mainMenuRun(){
        while (true) {
            Menu.mainMenu();
            System.out.print("Please select one item: ");
            int enter = input.nextInt();
            switch (enter) {
                case 1: {
                    System.out.print("Enter the authors surname: " + input.nextLine());
                    String surName = input.nextLine();
                    System.out.println("***Result***");
                    for (Author search : authorService.getAuthors(surName)) {
                        System.out.println("Author name: " + search.getFirstName() + " " + search.getSurName());
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter author first name: " + input.nextLine());
                    String firstName = input.nextLine();
                    System.out.print("Enter author sur name: ");
                    String surName = input.nextLine();
                    System.out.println();
                    System.out.println("Result");

                    for (Book search : bookService.getBookByAuthorName(firstName, surName)) {
                        System.out.println(search.getName() + " " +
                                search.getSubject());
                    }

                    break;
                }
                case 3: {
                    System.out.print("Enter book name: " + input.nextLine());
                    String bookName = input.nextLine();
                    System.out.println();
                    System.out.println("Result:");

                    System.out.println("Book name: " + bookService.getBookInfo(bookName).getName() + "\n" +
                            "Subject: " + bookService.getBookInfo(bookName).getSubject() + "\n" +
                            "Publisher: " + bookService.getBookInfo(bookName).getPublisher() + "\n" +
                            "Author name: " + bookService.getBookInfo(bookName).getAuthor().getFirstName() + " " +
                            bookService.getBookInfo(bookName).getAuthor().getSurName());

                    break;
                }
                case 4:{
                    login();
                    break;
                }
                case 5:{

                    return;
                }
            }
        }
    }
}
