package chapter02.chicken;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class ChickenRepository {
    private final Map<Integer,Chicken> store=new HashMap<>();
    void save(Chicken chicken){
        store.put(chicken.getId(),chicken);
    }
    Chicken findById(int id){
        if(!store.containsKey(id)){
            throw new ChickenNotFoundException(id);
        }
        return store.get(id);
    }
    List<Chicken> findAll(){
        return new ArrayList<>(store.values());
    }
}
