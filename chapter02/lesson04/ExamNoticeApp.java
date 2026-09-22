package chapter02.lesson04;

public class ExamNoticeApp {
    public static void main(String[] args) {
        ExamNotice examNotice1=new ExamNotice();
        Printable print1= examNotice1;
        Dated dated1=examNotice1;
        print1.print();
        System.out.println("day="+dated1.dayLabel());
    }
}
