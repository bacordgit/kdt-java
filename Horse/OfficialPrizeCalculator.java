package Horse;

public class OfficialPrizeCalculator implements PrizeCalculator {
    // PrizeCalculator.prizeOf를 구현한다.
    // 컨트롤러 필드의 컴파일 타입은 PrizeCalculator이고, 실행 객체는 이 클래스다.
    @Override
    public int prizeOf(int rank) {
        if (rank == 1) {
            return 100;
        } else if (rank == 2) {
            return 40;
        } else if (rank == 3) {
            return 20;
        } else {
            return 0;
        }
    }
}
