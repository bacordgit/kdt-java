package family;

public class PrettyStylePolicy implements SongpyeonPolicy{
    @Override
    public int pieceCount() {
        return 3;
    }

    @Override
    public int shapeScore() {
        return 90;
    }

    @Override
    public String label() {
        return "예쁘게";
    }
}
