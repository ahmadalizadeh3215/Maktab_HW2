package Library;

import Library.util.Menu;

public class Main {
    public static void main(String[] args) {

        Menu mainRun = new Menu();
        System.out.println(" ***WELCOME***");
        mainRun.initDependencies();
        mainRun.mainMenuRun();
    }
}
