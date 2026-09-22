package chapter02.lesson04;

public class LinePrinter {
    private final Printable target;
    public LinePrinter(Printable printable){
        this.target=printable;
    }
    public void run(){
        target.print();
    }
}
