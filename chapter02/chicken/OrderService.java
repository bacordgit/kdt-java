package chapter02.chicken;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class OrderService {
    private final OrderRepository orderRepo;
    private final ChickenRepository chickenRepo;
    private final CustomerRepository customerRepo;
    private final Map<String, DiscountPolicy> policyMap = new HashMap<>();

    public OrderService(OrderRepository orderRepo, ChickenRepository chickenRepo, CustomerRepository customerRepo) {
        this.orderRepo = orderRepo;
        this.chickenRepo = chickenRepo;
        this.customerRepo = customerRepo;
        policyMap.put("NORMAL", new NormalDiscountPolicy());
        policyMap.put("VIP", new VipDiscountPolicy());
        policyMap.put("NEWBIE", new NewbieDiscountPolicy());

    }
    Order order(int orderId, int customerId, int chickenId){;
        Customer customer= customerRepo.findById(customerId);
        Chicken chicken=chickenRepo.findById(chickenId);
        DiscountPolicy discountPolicy=policyMap.get(customer.getGrade());
        if(discountPolicy==null){
            throw new InvalidGradeException(customer.getGrade());
        }
        int originalprice=chicken.getPrice();
        int finalprice=discountPolicy.discount(originalprice);
        Order order=new Order(orderId,customerId,chickenId,originalprice,finalprice);
        orderRepo.save(order);
        return order;
    }
    List<Order> getAllOrders(){
        return orderRepo.findAll();
    }


}
