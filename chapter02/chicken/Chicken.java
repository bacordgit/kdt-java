package chapter02.chicken;

public class Chicken {
    private int id;
    private String name;
    private int price;
    public Chicken(int id,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
