package grocery;
import java.util.Scanner;
import java.util.ArrayList;
public class GroceryController {
    private final GroceryService service;
    private final Scanner sc;

    public GroceryController(GroceryService service) {
        this.service = service;
        sc=new Scanner(System.in);
    }

    public static void main(String[] args) {
        GroceryRepository repo=new GroceryRepository();
        GroceryService service=new GroceryService(repo);
        GroceryController controller=new GroceryController(service);
        controller.run();
    }
    public void run(){
       selectMenu();

    }
    public void printMenu(){
        System.out.println("🌕 추석 장보기");
        System.out.println("1.장올리기");
        System.out.println("2.장 하나 보기");
        System.out.println("3.장 목록");
        System.out.println("4.수량 바꾸기");
        System.out.println("5. 장 지우기");
        System.out.println("0. 종료");
        System.out.println("번호> ");
    }
    public void selectMenu(){
        while(true) {
            printMenu();
            int select = sc.nextInt();
            if (select == 1) {
                itemRegister();
            } else if (select == 2) {
                oneview();
            } else if (select == 3) {
                viewList();
            } else if (select == 4) {
                quantityReplace();
            } else if(select==5){
                delete();
            }else if (select == 0) {
                exit();
                break;
            }
        }
    }

    public void itemRegister() {
        try {
            System.out.print("이름> ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println();
            System.out.print("수량> ");
            int quantity = sc.nextInt();
            System.out.println();
            GroceryItem item = service.register(name, quantity);
            System.out.println("🛒 장을 올렸습니다. 번호 " + item.getId() + ", " + item.getName() + ", " + item.getQuality() + "개");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void oneview(){
        System.out.print("번호> ");
        try {
            GroceryItem item = service.findById(sc.nextInt());
            System.out.println(item.getId()+". "+item.getName()+", "+item.getQuality()+"개");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void viewList(){
        ArrayList<GroceryItem> list=service.findAll();
        System.out.println("🛒 장 목록");
         if(list.isEmpty()){
             System.out.println("아직 올린 장이 없습니다.");
         }
         else{
             for(GroceryItem item: list){
                 System.out.println(item.getId()+". "+item.getName()+" / "+item.getQuality()+"개");
             }
         }
    }
    public void quantityReplace(){
        System.out.print("번호> ");
        int old=sc.nextInt();
        System.out.println();
        System.out.println("수량> ");
        int quantity=sc.nextInt();
        try {
            GroceryItem item=service.changeQuantity(old, quantity);
            System.out.println("🛒 수량을 바꿨습니다. 번호 "+item.getId()+", "+item.getName()+", "+item.getQuality()+"개");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void delete(){
        System.out.print("번호> ");
        try {
            int id=sc.nextInt();
            service.delete(id);
            System.out.println();
            System.out.println("🛒 장을 지웠습니다. 번호 "+id);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void exit(){
        System.out.println("다음에 또 장봐요");
    }

}
