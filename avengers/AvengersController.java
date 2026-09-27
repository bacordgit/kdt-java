package avengers;
import java.util.Scanner;
public class AvengersController {
    private final HeroService hservice;
    private final MissionService mservice;
    private final MissionLogService lservice;
    private final BattleService bservice;
    private final Scanner sc;

    public AvengersController(HeroService hservice, MissionService mservice, MissionLogService lservice, BattleService bservice, Scanner sc) {
        this.hservice = hservice;
        this.mservice = mservice;
        this.lservice = lservice;
        this.bservice = bservice;
        this.sc = sc;
    }

    public static void main(String[] args) {
        HeroRepository heroRepo=new HeroRepository();
        MissionRepository missionRepo=new MissionRepository();
        MissionLogRepository missionlogRepo=new MissionLogRepository();
        HeroService hservice=new HeroService(heroRepo);
        MissionService mservice=new MissionService(missionRepo);
        MissionLogService lservice=new MissionLogService(missionlogRepo);
        BattleService bservice=new BattleService();
        Scanner sc=new Scanner(System.in);
        AvengersController controller=new AvengersController(hservice,mservice,lservice,bservice,sc);
        controller.run();
    }
    public void run(){
        selectMenu();
    }
    public void printMenu(){
        System.out.println("🛡️ 어벤져스 본부");
        System.out.println("1. 히어로 등록");
        System.out.println("2. 미션 등록");
        System.out.println("3. 히어로 배정");
        System.out.println("4. 전투");
        System.out.println("5. 전투 로그");
        System.out.println("6. 히어로 목록");
        System.out.println("7. 미션 목록");
        System.out.println("0. 종료");
        System.out.print("번호> ");
    }
    public void selectMenu(){
        while(true) {
            printMenu();
            int select = sc.nextInt();
            if (select == 1) {
                hregister();
            } else if (select == 2) {
                mregister();
            } else if (select == 3) {
                hassign();
            } else if (select == 4) {
                combat();
            } else if (select == 5) {
                combatlog();
            } else if (select == 6) {
                herolist();
            } else if (select == 7) {
                missionlog();
            } else if (select == 0) {
                System.out.println("본부로 복귀합니다.");
                break;
            } else {
                System.out.println("메뉴는 0부터 7까지입니다.");
            }
        }
    }
    public void hregister(){
        System.out.print("이름> ");
        sc.nextLine();
        String heroName=sc.nextLine();
        try {
            Hero hero=hservice.register(heroName);
            System.out.println("🦸 히어로를 등록했습니다. 번호 "+hero.getId()+", "+hero.getName());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void mregister(){
        System.out.print("미션 이름> ");
        sc.nextLine();
        String missionName=sc.nextLine();
        try{
            Mission mission=mservice.register(missionName);
            System.out.println("🎯 미션을 등록했습니다. 번호 "+mission.getId()+", "+mission.getTitle());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void hassign(){
        System.out.print("히어로 번호> ");
        int hid=sc.nextInt();
        System.out.print("미션 번호> ");
        int missionid=sc.nextInt();
        try{
            Hero hero=hservice.findById(hid);
            mservice.assign(missionid,hero.getName());
            Mission mission=mservice.findById(missionid);
            System.out.println("🤝 배정했습니다. "+ mission.getTitle()+" / "+mission.getHeroName());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void combat(){
        System.out.print("미션 번호> ");
        int mid=sc.nextInt();
        System.out.print("전투 방식 1.근접 2.원거리 3.지원> ");
        int style=sc.nextInt();
        try{
            BattleStrategy strategy=bservice.choose(style);
            Mission mission=mservice.findById(mid);
            MissionLog log=lservice.record(mission.getTitle(),mission.getHeroName(),strategy.label(),strategy.damage(),strategy.teamScore());
            System.out.println("💥 전투를 마쳤습니다. "+log.getMissionTitle()+" / "+log.getHeroName()+" / "+log.getStrategyLabel()+" / 피해 "+log.getDamage()+" / 팀 "+log.getTeamScore());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void combatlog(){
        System.out.println("📜 전투 로그");
        if(lservice.findAll().isEmpty()){
            System.out.println("아직 전투 로그가 없습니다.");
        }
        else
            for(MissionLog log:lservice.findAll()){
            System.out.println(log.getId()+". "+log.getMissionTitle()+" / "+log.getHeroName()+" / "+log.getStrategyLabel()+" / 피해 "+log.getDamage()+" / 팀 "+log.getTeamScore());
        }
    }
    public void herolist(){
        System.out.println("🦸 히어로 목록");
        if(hservice.findAll().isEmpty()){
            System.out.println("아직 히어로가 없습니다.");
        }
        else{
            for(Hero hero: hservice.findAll()){
                System.out.println(hero.getId()+". "+hero.getName());
            }
        }

    }
    public void missionlog(){
        System.out.println("🎯 미션 목록");
        if(mservice.findAll().isEmpty()){
            System.out.println("아직 미션이 없습니다.");
        }else{
            for(Mission mission: mservice.findAll()){
                System.out.print(mission.getId()+". "+mission.getTitle()+" / ");
                if(mission.getHeroName().equals("")){
                    System.out.println("없음");
                }else{
                    System.out.println(mission.getHeroName());
                }
            }
        }
    }

}
