package MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyList();

        /*list.addAll(new Integer[]{1, 2, 3, 4, 5});
        list.add(3, 100);*/
        list.addAll(new Integer[]{1, 2, 3, 4, 5});
        /*list.addAll(4,new Integer[]{10,11,12,13});*/
        System.out.println(list.contains("7"));
        list.showList();
    }
}
