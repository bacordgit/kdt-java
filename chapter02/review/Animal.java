package chapter02.review;

public class Animal {
    private Long id;
    private final String name;
    private final String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
    public void assignId(Long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }
}
