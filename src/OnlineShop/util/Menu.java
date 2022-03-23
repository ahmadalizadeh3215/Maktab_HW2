package OnlineShop.util;

import OnlineShop.model.*;
import OnlineShop.service.CategoryService;
import OnlineShop.service.ProductService;
import OnlineShop.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final FakeDB fakeDB = new FakeDB();
    private final CategoryService categoryService = new CategoryService(fakeDB);
    private final UserService userService = new UserService(fakeDB);
    private final ProductService productService = new ProductService(fakeDB);
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private User manageUser;
    private Category category;

    public Menu() {
    }
    public void initDependencies() {
        fakeDB.initFakeDB();
    }

    public void signUp() {
        User user = new User();
        System.out.println("***Fill in the required fields below to register***");
        Address address = new Address();
        System.out.print("First name: " + input.nextLine());
        String firstName = input.nextLine();
        System.out.print("Sur name: ");
        String surName = input.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = input.nextLine();
        String emailAddress;
        while (true) {
            System.out.print("Email address: ");
            emailAddress = input.nextLine();
            User userInf = userService.getEmail(emailAddress);
            if (userInf != null) {
                System.out.println("This email has been used before,\n" +
                        " Try again.");
                continue;
            }
            break;
        }
        String username;
        while (true) {
            System.out.print("Set a username: ");
            username = input.nextLine();
            User userInf = userService.getUserByUserName(username);
            if (userInf == null) {
                break;
            }
            System.out.println("This Username already taken, try again.");
        }
        String password;
        while (true) {
            System.out.println("The password must have at least 8 characters,\n " +
                    " including uppercase and lowercase letters, numbers,\n  " +
                    " and symbols ($,%, @, etc.).");
            System.out.print("Set s password: ");
            password = input.nextLine();
            break;
        }
        System.out.println("Address");
        System.out.print("State:");
        String state = input.nextLine();
        System.out.print("City:");
        String city = input.nextLine();
        System.out.print("Street:");
        String street = input.nextLine();
        System.out.print("Alley:");
        String alley = input.nextLine();
        System.out.print("Postal Code:");
        String postalCode = input.nextLine();

        address.setState(state);
        address.setCity(city);
        address.setStreet(street);
        address.setAlley(alley);
        address.setPostalCode(postalCode);

        user.setFirstName(firstName);
        user.setSurname(surName);
        user.setPhoneNumber(phoneNumber);
        user.setEmailAddress(emailAddress);
        user.setUserName(username);
        user.setPassword(password);
        user.setAddress(address);

        fakeDB.addUser(user);
        System.out.println("Sign up successfully");
        System.out.println();

    }

    public void login() {
        while (true) {
            System.out.print("Username: " + input.nextLine());
            String userName = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            User user = userService.getUserByUserName(userName);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    manageUser = user;
                    break;
                }
            }
            System.out.println("Username or password wrong! try again.");
        }
        System.out.println();
    }

    public void loginMenuRun() {
        Menu.startMenu();
        int enter = input.nextInt();
        switch (enter) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                System.out.println();
                login();
                break;
            default:
                System.out.println("Not Valid!");
                System.out.println();
        }
    }

    public void mainMenuRun() {
        List<Category> listCategory;
        int enter;
        do {
            Menu.mainMenu();
            enter = input.nextInt();
            switch (enter) {
                case 1: {
                    int count = 1;
                    listCategory = categoryService.getParentCategory();
                    for (Category search : listCategory) {
                        System.out.println(count + "- " + search.getName());
                        count++;
                    }
                    break;
                }
                case 2: {
                    Menu.mainMenuInfo();
                    int ent = input.nextInt();

                    switch (ent) {
                        case 1: {
                            System.out.println("First name: " + manageUser.getFirstName() + "\n" +
                                    "Last name: " + manageUser.getSurname() + "\n" +
                                    "Phone number: " + manageUser.getPhoneNumber() + "\n" +
                                    "Email address: " + manageUser.getEmailAddress() + "\n" +
                                    "Account Balance: " + manageUser.getAccountBalance() + "\n" +
                                    "Address: " + manageUser.getAddress().getState() + " " + manageUser.getAddress().getCity() + "\n");
                            System.out.print("Press enter to back");
                            input.nextLine();
                            input.nextLine();

                            break;
                        }
                        case 2: {
                            System.out.print("Enter how much you want to pay: ");
                            Double fee = input.nextDouble();
                            userService.chargeBalanceUsers(manageUser, fee);
                            System.out.println("Payment was successful.\n New account balance: $" + manageUser.getAccountBalance());
                            System.out.print("Press enter to back");
                            input.nextLine();
                            input.nextLine();
                            break;
                        }
                        case 3: {

                            System.out.print("Are you sure you want to delete your account?(Y/N) " + input.nextLine());
                            String deleteAccount = input.nextLine();
                            if ((deleteAccount.startsWith("n") || deleteAccount.startsWith("N"))) {
                                break;
                            }
                            userService.deleteAccount(manageUser);
                            loginMenuRun();
                            shoppingCart.clearShoppingCart();
                            shoppingCart.clearTotalPrice();
                            break;
                        }
                        default:{
                            System.out.println("Try again!");
                            break;
                        }
                    }

                    break;
                }
                case 3: {
                    while (true) {
                        int count = 1;
                        System.out.println("-_ SHOPPING CART _-");
                        Product[] listOfProduct = shoppingCart.getListOfProduct();
                        for (int i = 0; i < listOfProduct.length; i++) {
                            if (listOfProduct[i] != null && listOfProduct[i] != listOfProduct[i+1]) {
                                System.out.println(count + "- Product name: " + listOfProduct[i].getProductName() + "\n" +
                                        "Unit price: $" + listOfProduct[i].getUnitPrice());
                                count++;
                            }
                        }

                        System.out.println("Total product: " + shoppingCart.getQuantity());
                        System.out.println("Total payable: $" + shoppingCart.getTotalPrice());
                        Menu.shoppingCartMenu();

                        System.out.print("Please select one item: ");
                        int choice = input.nextInt();

                        switch (choice) {
                            case 1: {
                                if(manageUser.getAccountBalance() < shoppingCart.getTotalPrice()){
                                    System.out.println("Your account balance is not enough, first charge your account to make the payment operation.\n " +
                                            "step 1. in main menu go to the Account Management\n " +
                                            "step 2. select Account recharge\n  " +
                                            "step 3. you know what to do :) ");
                                    System.out.print("Press enter to back");
                                    input.nextLine();
                                    input.nextLine();

                                    mainMenuRun();
                                    break;
                                }
                                System.out.println("*Thanks for your purchase*\n" +
                                        " The operation was successful, your package will reach you in 3 to 7 working days!");

                                Product[] product = shoppingCart.getListOfProduct();
                                for (Product search : product) {
                                    if (search != null) {
                                        productService.addQuantityProductUpdate(search);
                                        userService.updateBalanceUsers(manageUser, search.getUnitPrice());
                                    }
                                }
                                shoppingCart.setQuantity(0);
                                shoppingCart.clearTotalPrice();
                                shoppingCart.clearShoppingCart();
                                break;
                            }
                            case 2:
                                input.nextLine();
                                choice = input.nextInt();
                                shoppingCart.removeProductQuantity(choice - 1);
                                Integer i = shoppingCart.getQuantity();
                                shoppingCart.setQuantity((i - 1));
                                System.out.println("Delete successfully!");

                                break;
                            case 3:
                                mainMenuRun();
                                break;
                            default:
                                System.out.println("Try again!");

                        }
                        System.out.print("You want stay in shopping cart:(Y/N): ");
                        input.nextLine();
                        String select = input.nextLine();
                        if ((select.startsWith("n") || select.startsWith("N"))) {

                            mainMenuRun();
                            break;
                        }
                    }
                }
                case 4: {
                    System.out.println("/////////////");
                    System.out.println("Press enter to back to main menu" + input.nextLine());
                    input.nextLine();
                    break;
                }
                case 5: {
                    loginMenuRun();
                    shoppingCart.clearShoppingCart();
                    shoppingCart.clearTotalPrice();
                    break;
                }
                case 6: {
                    return;
                }
                default: {

                    System.out.println("Not valid! try again.");
                }
            }
        } while (enter != 1);

        categoryMenuRun();
    }

    public void categoryMenuRun() {
        List<Category> list = categoryService.getParentCategory();
        int enter, count;
        while (true) {
            System.out.println();
            System.out.print("Select one item: ");
            enter = input.nextInt();

            if (enter - 1 < 0 || enter - 1 >= list.size())  {
                System.out.println("Please select again...");
                System.out.print("Press enter to back");
                input.nextLine();
                input.nextLine();

                continue;
            }
            category = list.get(enter - 1);
            list = categoryService.getSubCategory(category);
            if (list.size() < 1) {
                break;
            }
            if (enter - 1 > list.size()) {
                System.out.println("Please select again...");
                System.out.print("Press enter to back");
                input.nextLine();
                input.nextLine();

                continue;
            }
            count = 1;
            for (Category search : list) {
                System.out.println(count + "- " + search.getName());
                count++;
            }

        }
        productMenuRun();
    }

    public void productMenuRun() {
        while (true) {
            List<Product> list = productService.getProduct(category);
            int enter, count;
            count = 1;
            if(list.size() < 1){
                System.out.println("The stock of this item has been exhausted.");
                System.out.print("Press enter to back");
                input.nextLine();
                input.nextLine();

                categoryMenuRun();
                break;
            }else {
                for (Product show : list) {
                    System.out.println(count + "- Product name: " + show.getProductName() + "\n" +
                            "Description: " + show.getDescription() + "\n" + "Unit price: $" + show.getUnitPrice() + "\n" +
                            "Quantity left in stock: " + show.getQuantity() + "\n");
                    count++;
                }
            }


            Menu.shoppingCartMainMenu();
            enter = input.nextInt();
            if(enter == 1) {
                int c = 0;
                for (Product p : shoppingCart.getListOfProduct()) {
                    if(p == null){
                        c++;
                    }
                }
                if(c > 5){
                    System.out.println("Cart capacity is full\n " +
                            "Empty the cart");
                    mainMenuRun();
                }
                System.out.println("Cart capacity " + c );
                System.out.print("Enter number of product: ");
                enter = input.nextInt();
                Product product = list.get(enter - 1);
                int qty;
                while (true){
                    System.out.print("Enter quantity: ");
                    qty = input.nextInt();
                    if(qty > product.getQuantity()){
                        System.out.println("The requested quantity is more than the goods in stock!\n " +
                                "Try again");
                        continue;
                    }
                    break;
                }
                shoppingCart.setQuantity(qty);
                shoppingCart.setTotalPrice(product.getUnitPrice() * qty);
                while (qty > 0){
                    shoppingCart.addProductQuantity(product);
                    qty--;
                }
                System.out.println("Successfully added to shopping cart!");
                System.out.print("Press enter to back");
                input.nextLine();
                input.nextLine();

            }else if(enter == 2){

                mainMenuRun();
                break;
            }else{
                System.out.println("Try again!");
            }
        }
    }


    public static void  startMenu(){

        System.out.println("1- Login");
        System.out.println(" 2- Sign Up");
        System.out.print("Already have an account? enter 1 \n Or 2, to create an account: ");
    }

    public static void mainMenu(){
        System.out.println("1- View categories");
        System.out.println(" 2- Account management");
        System.out.println("  3- View shopping cart");
        System.out.println("  4- َََAbout Us!");
        System.out.println(" 5- Log out");
        System.out.println("6- Exit.");

        System.out.print("Select One Item: ");
    }

    public static void shoppingCartMainMenu(){
        System.out.println("1- Add to shopping cart \n" +
                " 2- Back to main menu!");

        System.out.print("Please select one item:");
    }

    public static void shoppingCartMenu(){
        System.out.println("1- Financial Settlements\n" +
                " 2- Delete from shopping cart\n" +
                "3- Back to main menu");
    }

    public static void mainMenuInfo(){
        System.out.println("1- User information ");
        System.out.println(" 2- Account recharge ");
        System.out.println("3- Delete account ");

        System.out.print("Please select one item: ");
    }
}
