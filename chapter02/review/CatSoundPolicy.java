package chapter02.review;

public class CatSoundPolicy implements SoundPolicy{
    private final String sound="야옹";

    @Override
    public String makeSound(String name) {
        if(name==null || name.isEmpty()){
            return "냐옹";
        }
        return sound;
    }
}
