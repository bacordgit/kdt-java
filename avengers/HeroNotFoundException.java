package avengers;

public class HeroNotFoundException extends IllegalArgumentException{
    public HeroNotFoundException(String s) {
        super(s);
    }
}
