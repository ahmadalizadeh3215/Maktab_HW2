package MyList;

public class MyList {

    private Integer[] list;
    private int emptyHomeIndex;

    public MyList() {
        list = new Integer[1000];
        emptyHomeIndex = 0;
    }

    public void add(int value) {
        list[emptyHomeIndex] = value;
        emptyHomeIndex++;
    }

    public Integer get(int index) {
        return list[index];
    }

    public Boolean isEmpty() {
        return emptyHomeIndex == 0;
    }

    public int size() {
        return emptyHomeIndex;
    }

    public void add(int index, Integer value) {
        //// Check: Index invalid
        for (int i = emptyHomeIndex; i > index ; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        emptyHomeIndex++;
    }

    public void addAll(Integer[] values) {
        for (Integer v: values) {
            add(v);
        }
    }

    public void addAll(int index, Integer[] value){
        int count = emptyHomeIndex + value.length - 1;
        for (int i = emptyHomeIndex; i > index; i--) {
            list[count] = list[i - 1];
            count--;
        }
        for (int i = 0; i < value.length; i++) {
            list[index] = value[i];
            index++;
        }
    }

    public void remove(int index){
        for (int i = index; i < emptyHomeIndex; i++) {
            list[i] = list[i + 1];
        }
    }

    public void clear(){
        while (true){
            if(list[0] != null)
                remove(0);
            else {
                emptyHomeIndex = 0;
                break;
            }
        }
    }

    public boolean contains(String value){
        for (Integer i : list) {
            if(i != null) {
                if (i.toString().equals(value))
                    return true;
            }
        }
        return false;
    }

    public void showList() {
        for (int i = 0; i < emptyHomeIndex; i++) {
            System.out.print(list[i]);
            System.out.print(", ");
        }
    }
}
