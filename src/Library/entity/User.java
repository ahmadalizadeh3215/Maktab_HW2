package Library.entity;

public class User {

    private String name;
    private String userName;
    private String password;
    private Integer totalBorrow;
    private Double fineAmount;
    private Book[] books = new Book[2];
    int lastIndexOfBook = 0;
    public User() {
    }

    public User(String name, String userName, String password, Integer totalBorrow, Double fineAmount) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.totalBorrow = totalBorrow;
        this.fineAmount = fineAmount;
    }

    public int getLastIndexOfBook() {
        return lastIndexOfBook;
    }

    public void setLastIndexOfBook(int lastIndexOfBook) {
        this.lastIndexOfBook = lastIndexOfBook;
    }

    public String getName() {
        return name;
    }


    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Book[] getBooks() {
        return books;
    }

}
