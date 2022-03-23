package OnlineShop.service;

import OnlineShop.model.User;
import OnlineShop.util.FakeDB;

public class UserService {
    private final FakeDB fakeDB;

    public UserService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    public User getEmail(String emailAddress){
        for (User u : fakeDB.getUserList()) {
            if(u.getEmailAddress().equals(emailAddress)){
                return u;
            }
        }
        return null;
    }

    public void chargeBalanceUsers(User user, Double balance){
        fakeDB.saveChargeBalance(user,balance);
    }

    public void updateBalanceUsers(User user, Double fee){
        fakeDB.saveUpdateBalance(user,fee);
    }

    public void deleteAccount(User user){
        fakeDB.saveDeleteAccount(user);
    }

    public User getUserByUserName(String userName){
        for (User u : fakeDB.getUserList()) {
            if(u.getUserName().equals(userName)){
                return u;
            }
        }
        return null;
    }
}
