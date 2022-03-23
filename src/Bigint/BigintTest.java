package Bigint;

public class BigintTest {
    public static void main(String[] args) {

        Bigint bigint = new Bigint();
        System.out.println(bigint.divide("1a",2));
        System.out.println(bigint.multi("14h","2"));
        System.out.println(bigint.sub("14","2"));
        System.out.println(bigint.sum("14","2"));
        System.out.println(bigint.compare("7865342","098768888888"));

    }
}
