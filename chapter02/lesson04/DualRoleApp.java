package chapter02.lesson04;

public class DualRoleApp {
    public static void main(String[] args) {
        StampSlip stampslip = new StampSlip();
        Printable printable=stampslip;
        Dated dated= stampslip;
        printable.print();
        System.out.println(dated.dayLabel());
    }


}
