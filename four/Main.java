package four;

public class Main {
    public static void main(String[] args) {
        StudentService service=new StudentService();
        service.join(1,"홍길동","Java",90);
        service.join(2,"김철수","Java",85);
        service.join(3,"이영희","Python",95);
        service.join(4,"박민수","Java",70);
        service.join(1,"중복맨","Java",50);
        service.printAll();
        service.changeScore(2,100);
        service.printAll();
        service.remove(1);
        service.printAll();
        service.printOne(3);
        service.printBySubject("Java");
        service.printBySubject("Python");
        service.printBySubject("C++");

    }


}
