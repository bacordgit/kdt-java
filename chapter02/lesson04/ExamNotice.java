package chapter02.lesson04;

public class ExamNotice implements Printable,Dated{
    @Override
    public void print() {
        System.out.println("exam=ready");

    }
    @Override
    public String dayLabel() {
        return "monday";
    }
}
