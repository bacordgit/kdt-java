package chapter02.review;
import java.util.Map;
import java.util.HashMap;
public class AnimalRepository {
    private final Map<Long,Animal> store=new HashMap<>();
    private Long sequence=0L;
    public Animal save(Animal animal){
        animal.assignId(++sequence);
        store.put(sequence,animal);
        return animal;
    }
    public Animal findById(Long id){
        return store.get(id);
    }
}
