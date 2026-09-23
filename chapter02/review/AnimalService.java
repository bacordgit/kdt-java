package chapter02.review;

public class AnimalService {
    private final AnimalRepository repo;
    private final SoundPolicy policy;

    public AnimalService(AnimalRepository repo, SoundPolicy policy) {
        this.repo = repo;
        this.policy = policy;
    }
    public Animal Register(String name){
        String sound=policy.makeSound(name);
        Animal animal=new Animal(name,sound);
        return repo.save(animal);

    }
    public Animal getAnimal(Long id){
        return repo.findById(id);
    }
}

