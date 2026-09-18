package three;

import java.util.ArrayList;
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String>titles=new ArrayList<>();
        titles.add("closed");
        titles.add("exam");
        titles.add("holiday");
        System.out.println(titles.size());
        System.out.println(titles.get(0));
        titles.set(0,"open");
        titles.remove(2);
    }
}
