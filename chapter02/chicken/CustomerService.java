package chapter02.chicken;
import java.util.List;
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository cs) {
        repository = cs;
    }
    void registerCustomer(int id, String name, String grade){
        if(!(grade.equals("NORMAL") || grade.equals("VIP") ||grade.equals("NEWBIE")) ){
            throw new InvalidGradeException(grade);
        }
        repository.save(new Customer(id,name,grade));
    }
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }
    Customer getCustomer(int id){
        return repository.findById(id);
    }
}
