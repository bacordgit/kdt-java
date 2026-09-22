package chapter02.chicken;
import java.util.List;
public class ChickenService {
    private final ChickenRepository repository;

    public ChickenService(ChickenRepository repository) {
        this.repository = repository;
    }

    public void registerChicken(int id, String name, int price){
        repository.save(new Chicken(id,name,price));
    }
    public List<Chicken> getAllChickens(){
        return repository.findAll();
    }
    public Chicken getChicken(int id){
        return repository.findById(id);
    }
}
