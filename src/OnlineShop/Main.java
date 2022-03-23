package OnlineShop;

import OnlineShop.util.Menu;

public class Main {

    public static void main(String[] args) {
        Menu mainRun = new Menu();
        mainRun.initDependencies();
        mainRun.loginMenuRun();
        mainRun.mainMenuRun();
    }
}
