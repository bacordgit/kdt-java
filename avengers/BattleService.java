package avengers;

public class BattleService {
    public BattleStrategy choose(int num){
        if(num==1){
            return new MeleeStrategy();
        }else if(num==2){
            return new RangedStrategy();
        }
        else if(num==3){
            return new SupportStrategy();
        }
        else throw new InvalidStrategyException("맞지 않는 방식");
    }
}
