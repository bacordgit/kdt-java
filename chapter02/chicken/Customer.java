package chapter02.chicken;

public class Customer {
    private int id;
    private String name;
    private String grade;
    public Customer(int id,String name,String grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}
