package chapter02.chicken;
import java.util.Scanner;
public class ChickenController {
    private final Scanner sc=new Scanner(System.in);
    private final ChickenService chickenService;
    private final CustomerService customerService;
    private final OrderService orderService;

    public ChickenController(ChickenService c, CustomerService cu, OrderService o) {
        this.chickenService = c;
        this.customerService = cu;
        this.orderService = o;
    }
    public void run(){
    boolean running=true;
    while(running){
        printMenu();
        int menu=sc.nextInt();
    }
    }
    public void printMenu(){

    }
    public void handleChickenList(){

    }
    public void handleRegisterCustomer(){

    }
    public void handleOrder(){

    }
    public void handleOrderList(){

    }

}
