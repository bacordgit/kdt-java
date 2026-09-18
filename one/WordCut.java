package one;

import java.util.Scanner;
public class WordCut {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("menu?");
        String menu=sc.nextLine();
        String[] menu_divide=menu.split(" ");
        System.out.println("word="+menu_divide[0]);
        System.out.println("rest= "+menu_divide[1]);

    }
}
