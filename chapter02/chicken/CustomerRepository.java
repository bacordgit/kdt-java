package chapter02.chicken;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class CustomerRepository {
    Map<Integer,Customer> store=new HashMap<>();
    void save(Customer customer){
        store.put(customer.getId(),customer);
    }
    Customer findById(int id){
        if(!store.containsKey(id)){
            throw new CustomerNotFoundException(id);
        }
        return store.get(id);
    }
    List<Customer> findAll(){
        return new ArrayList<>(store.values());
    }
}
