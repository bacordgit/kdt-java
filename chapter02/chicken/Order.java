package chapter02.chicken;

public class Order {
    private int id;
    private int customerId;
    private int chickenId;
    private int originalPrice;
    private int finalPrice;

    public Order(int id, int customerId,int chickenId, int originalPrice, int finalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.chickenId=chickenId;
        this.originalPrice = originalPrice;
        this.finalPrice = finalPrice;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getChickenId() {
        return chickenId;
    }
    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
}
