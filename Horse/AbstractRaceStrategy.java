package Horse;

public abstract class AbstractRaceStrategy implements RaceStrategy {
private  final String label;

    public AbstractRaceStrategy(String label) {
        this.label = label;
    }

    @Override
    public int execute(int round) {
        prepare();
        int pace=run(round);
        return finish(pace);
    }

    @Override
    public String label() {
        return label;
    }
    protected void prepare(){

    }
    protected abstract int run(int round);
    protected int finish(int pace){
        return pace;
    }
}
