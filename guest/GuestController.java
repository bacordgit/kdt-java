package guest;
import java.util.Scanner;
public class GuestController {
    private final GuestService service;
    private final Scanner sc;

    public GuestController(GuestService service) {
        this.service = service;
        sc=new Scanner(System.in);
    }
    public void nameRegister(String name){
        try{
            Guest g=service.register(name);
            System.out.println("🌕 명단에 올렸습니다. 번호 "+g.getId()+", "+g.getName());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    public void menu(){
        System.out.println("🌕 추석 초대");
        System.out.println("1. 이름 올리기");
        System.out.println("2. 명단 보기");
        System.out.println("3. 번호로 찾기");
        System.out.println("0. 종료");
        System.out.print("번호> ");
    }
    public void run() {
        while (true) {
            menu();
            int select = sc.nextInt();
            if (select == 1) {
                System.out.print("이름> ");
                sc.nextLine();
                nameRegister(sc.nextLine());
            } else if (select == 2) {
                System.out.println("🌕 초대 명단");
                for (Guest g : service.findAll()) {
                    System.out.println(g.getId() + ". " + g.getName());
                }
            } else if (select == 3) {
                System.out.print("번호> ");
                try {
                    Guest g = service.findById(sc.nextInt());
                    System.out.println(g.getId() + ". " + g.getName());
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                
            } else if (select == 0) {
                System.out.println("다음에 또 만나요.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        GuestRepository repo=new GuestRepository();
        GuestService service=new GuestService(repo);
        GuestController controller=new GuestController(service);
        controller.run();

    }
}
