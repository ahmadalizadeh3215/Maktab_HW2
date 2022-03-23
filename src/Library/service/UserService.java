package Library.service;

import Library.entity.Book;
import Library.entity.User;
import Library.util.FakeDB;

public class UserService {

    private final FakeDB fakeDB;

    public UserService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    public Boolean isUserByUserPass(String userName, String password){
        for (User search : fakeDB.getUsers()) {
            if(search.getUserName().equals(userName) && search.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String userName){
        for (User search : fakeDB.getUsers()) {
            if(search.getUserName().equals(userName))
                return search;
        }
        return null;
    }

    public Boolean isEmptyPlace(User user){
        for (User search : fakeDB.getUsers()) {
            if(search == user){
                for (int i = 0; i < search.getBooks().length; i++) {
                    if(search.getBooks()[i] == null){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Double getFineAmountByUser(User user){
        return fakeDB.getFineAmount(user);
    }

    public Book[] getBorrowedBook(User user){
        return fakeDB.getBorrowedBook(user);
    }

    public Book[] getListOfBorrow(User user, Book book){
        return fakeDB.updateUserBorrowedListForBorrow(user, book);
    }

    public Book[] updateBorrowList(User user, Book book, Integer integer){
        return fakeDB.updateUserBorrowedListForReturn(user, book, integer);
    }

    public Double calcFineAmount(Integer days){
        return (days - 7) * 1000.0;
    }

    public void setFineAmount(User user, Double fee){
        fakeDB.setFineAmount(user,fee);
    }
}
