package Library.util;

import Library.entity.Author;
import Library.entity.Book;
import Library.entity.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FakeDB {
    private List<Author> authors;
    private List<Book> books;
    private List<User> users;

    public FakeDB() {
    }
    public void initFakeDB(){
        this.authors = new ArrayList<>();
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        initFakeAuthorAndBook();
        initFakeUser();
    }

    public void initFakeUser(){
        User userOne = new User("jack","jack_12","1212ja",null,null);
        User userTwo = new User("julia","juli20","2020J",1,null);
        User userTree = new User("jack","jack_12","1212ja",2,1000.0);
        User userFour = new User("jack","jack_12","1212ja",1,null);

        this.users.add(userOne);
        this.users.add(userTwo);
        this.users.add(userTree);
        this.users.add(userFour);
    }

    public void initFakeAuthorAndBook() {
        Date date = new Date(1960, Calendar.JANUARY, 12);
        Author authorOne = new Author("jimi","jones",date,"j.jones@gmail.com");
        Author authorTwo = new Author("mary","don",date,"mary.d@gmail.com");
        Author authorTree = new Author("paul","wesley",date,"p.wesley@gmail.com");
        Author authorFour = new Author("david","don",date,"david.kile@gmail.com");
        this.authors.add(authorOne);
        this.authors.add(authorTwo);
        this.authors.add(authorTree);
        this.authors.add(authorFour);

        Book bookOne = new Book("what if?","scientific","londonPPA",2000,authorOne,10);
        Book bookTwo = new Book("soccer","scientific","france football",2002,authorTwo,5);
        Book bookTree = new Book("flower?","new york times","scientific",2010,authorTree,20);
        Book bookFour = new Book("war?","nyc publish","political",1990,authorFour,2);
        Book bookFive = new Book("java","oracle","programming",2020,authorOne,null);
        this.books.add(bookOne);
        this.books.add(bookTwo);
        this.books.add(bookTree);
        this.books.add(bookFour);
        this.books.add(bookFive);
    }

    private static void updateBookQuantityForBorrow(Book book){
        Integer qty = book.getQuantity();
        qty -= 1;
        book.setQuantity(qty);
    }

    private static void updateBookQuantityForReturn(Book book){
        Integer qty = book.getQuantity();
        qty += 1;
        book.setQuantity(qty);
    }

    public Book[] updateUserBorrowedListForBorrow(User user, Book book){
        Book[] books = user.getBooks();
        int lastIndexOfBook = user.getLastIndexOfBook();
        if(lastIndexOfBook < 2){
            books[lastIndexOfBook] = book;
        }
        lastIndexOfBook++;
        user.setLastIndexOfBook(lastIndexOfBook);
        updateBookQuantityForBorrow(book);
        return books;
    }

    public Book[] updateUserBorrowedListForReturn(User user, Book book, Integer index){
        Book[] books = user.getBooks();
        int lastIndexOfBook = user.getLastIndexOfBook();
        if(index == 1) {
            books[index - 1] = books[index];
            books[index] = null;
        }else{
            books[index - 1] = null;
        }

        lastIndexOfBook--;
        user.setLastIndexOfBook(lastIndexOfBook);
        updateBookQuantityForReturn(book);
        return books;
    }

    public Double getFineAmount(User user){
        return user.getFineAmount();
    }

    public Book[] getBorrowedBook(User user){
        return user.getBooks();
    }

    public void setFineAmount(User user, Double cost){
        Double amount = user.getFineAmount();
        if(amount != null){
            amount += cost;
            user.setFineAmount(amount);
        }else{
            user.setFineAmount(cost);
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

}
