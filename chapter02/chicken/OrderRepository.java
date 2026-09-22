package chapter02.chicken;
import java.util.ArrayList;
import java.util.List;
public class OrderRepository {
    List<Order> orders = new ArrayList<>();
    public void save(Order order){
        orders.add(order);
    }
    List<Order> findAll(){
        return new ArrayList<>(orders);
    }
}
