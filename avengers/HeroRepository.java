package avengers;
import java.util.HashMap;
import java.util.ArrayList;
public class HeroRepository {
    private final HashMap<Integer,Hero> store=new HashMap<>();
    private final ArrayList<Integer> ids=new ArrayList<>();
    private int nextNumber=1;

    public int nextId(){
    return nextNumber++;
    }
    public void save(Hero hero){
        store.put(hero.getId(),hero);
        ids.add(hero.getId());
    }
    public Hero findById(int id){
        Hero hero=store.get(id);
        if(hero==null){
            throw new HeroNotFoundException("id가 비어있습니다.");
        }else return hero;
    }
    public ArrayList<Hero> findAll(){
        ArrayList<Hero> list=new ArrayList<>();
        for(int a:ids){
            list.add(store.get(a));
        }
        return list;
    }

}
