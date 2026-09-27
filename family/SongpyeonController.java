package family;

import java.util.Scanner;

public class SongpyeonController {
    private final FamilyMemberService fservice;
    private final SongpyeonService sservice;
    private final Scanner sc;

    public SongpyeonController(FamilyMemberService fservice, SongpyeonService sservice, Scanner sc) {
        this.fservice = fservice;
        this.sservice = sservice;
        this.sc = sc;
    }

    public static void main(String[] args) {
        FamilyMemberRepository frepo=new FamilyMemberRepository();
        SongpyeonRepository srepo=new SongpyeonRepository();
        FamilyMemberService fservice=new FamilyMemberService(frepo);
        SongpyeonService sservice=new SongpyeonService(srepo);
        Scanner sc=new Scanner(System.in);
        SongpyeonController controller=new SongpyeonController(fservice,sservice,sc);

        controller.run();
    }
    public void run(){
      while(true){
        printmenu();
        int select=sc.nextInt();
        if(select==1){
            FRegister();
        }
        else if(select==2){
            makeSong();
        }
        else if(select==3){
            slist();
        }
        else if(select==4){
            flist();
        }
        else if(select==0){
            System.out.println("다음에 또 빚어요.");
            break;
        }
      }
    }
    public void printmenu(){
        /*🌕 추석에 모인 가족
        1. 가족 등록
        2. 송편 빚기
        3. 송편 목록
        4. 가족 목록
        0. 종료
        */
        System.out.println("🌕 추석에 모인 가족");
        System.out.println("1. 가족 등록");
        System.out.println("2. 송편 빚기");
        System.out.println("3. 송편 목록");
        System.out.println("4. 가족 목록");
        System.out.println("0. 종료");
        System.out.print("번호> ");
    }
    public void FRegister(){
        System.out.print("이름> ");
        sc.nextLine();
        String name=sc.nextLine();
        try {
            FamilyMember member=fservice.register(name);
            System.out.println("👵 가족을 등록했습니다. 번호 "+member.getId()+", "+member.getName());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void makeSong(){
        System.out.print("송편 이름> ");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.print("가족 번호> ");
        int num=sc.nextInt();
        System.out.print("빚기 스타일 1.예쁘게 2.빠르게> ");
        int style=sc.nextInt();
        try {
            Songpyeon song=sservice.register(name, fservice.findById(num).getName(), style);
            System.out.println("🥟 "+song.getName()+"을 빚었습니다. "+song.getMakerName()+" / "+song.getStyleLabel()+" / "+song.getCount()+"개 / 모양 "+song.getShapeScore()+"점");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void slist(){
        System.out.println("🥟 송편 목록");
        try {
            for (Songpyeon s : sservice.findAll()) {
                System.out.println(s.getId() + ". " + s.getName() + " / " + s.getStyleLabel() + " / " + s.getCount() + "개 / 모양 " + s.getShapeScore() + "점");
            }
        }catch(SongpyeonNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
    public void flist(){
        System.out.println("🌕 가족 목록");
        try {
            for (FamilyMember f : fservice.findAll()) {
                System.out.println(f.getId()+". "+f.getName());
            }
        }catch(SongpyeonNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
