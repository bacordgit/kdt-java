package Horse;

import java.util.Scanner;

// 왜: 어떤 저장소와 상금 구현을 쓸지는 메뉴 코드와 따로 둔다.
// 컨트롤러는 받은 객체의 메서드만 호출하므로, 여기만 고치면 조립이 바뀐다.
public class Main {
    public static void main(String[] args) {
        HorseRepository horseRepository = new HorseRepository();
        JockeyRepository jockeyRepository = new JockeyRepository();
        RaceRepository raceRepository = new RaceRepository();

        HorseService horseService = new HorseService(horseRepository);
        JockeyService jockeyService = new JockeyService(jockeyRepository);
        RaceService raceService = new RaceService(raceRepository);
        StrategyService strategyService = new StrategyService();
        PrizeCalculator prizeCalculator = new OfficialPrizeCalculator();
        Scanner scanner = new Scanner(System.in);

        RaceController controller = new RaceController(
                horseService,
                jockeyService,
                raceService,
                strategyService,
                prizeCalculator,
                scanner);
        controller.run();
    }
}