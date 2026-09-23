package chapter02.review;

public class DogSoundPolicy implements SoundPolicy{
    private final String sound="멍멍";

    @Override
    public String makeSound(String name) {
        if(name==null || name.isEmpty()){
            return "왈왈";
        }
        return sound;
    }
}
