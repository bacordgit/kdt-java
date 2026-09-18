package one;

import java.util.Scanner;
public class WhyScanner {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("ready!");
        String line = input.nextLine();
        System.out.println("ready!");
        System.out.println(line);
        String line2 = input.nextLine();
        System.out.println("menu"+line2);
    }
}
