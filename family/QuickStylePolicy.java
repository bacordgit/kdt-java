package family;

public class QuickStylePolicy implements SongpyeonPolicy{
    @Override
    public int shapeScore() {
        return 10;
    }

    @Override
    public int pieceCount() {
        return 40;
    }

    @Override
    public String label() {
        return "빠르게";
    }
}
