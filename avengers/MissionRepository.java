package avengers;

import java.util.ArrayList;
import java.util.HashMap;

public class MissionRepository {
    private final HashMap<Integer,Mission> store=new HashMap<>();
    private final ArrayList<Integer> ids=new ArrayList<>();
    private int nextNumber=1;

    public int nextId(){
        return nextNumber++;
    }
    public void save(Mission mission){
        store.put(mission.getId(),mission);
        ids.add(mission.getId());
    }
    public Mission findById(int id){
        Mission mission=store.get(id);
        if(mission==null){
            throw new HeroNotFoundException("id가 비어있습니다.");
        }else return mission;
    }
    public ArrayList<Mission> findAll(){
        ArrayList<Mission> list=new ArrayList<>();
        for(int a:ids){
            list.add(store.get(a));
        }
        return list;
    }
    public void replace(int id,Mission mission){
        findById(id);
        store.put(id,mission);
    }
}
