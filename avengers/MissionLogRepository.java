package avengers;

import java.util.ArrayList;
import java.util.HashMap;

public class MissionLogRepository {
    private final HashMap<Integer,MissionLog> store=new HashMap<>();
    private final ArrayList<Integer> ids=new ArrayList<>();
    private int nextNumber=1;

    public int nextId(){
        return nextNumber++;
    }
    public void save(MissionLog log){
        store.put(log.getId(),log);
        ids.add(log.getId());
    }
    public MissionLog findById(int id){
        MissionLog log=store.get(id);
        if(log==null){
            throw new HeroNotFoundException("id가 비어있습니다.");
        }else return log;
    }
    public ArrayList<MissionLog> findAll(){
        ArrayList<MissionLog> list=new ArrayList<>();
        for(int a:ids){
            list.add(store.get(a));
        }
        return list;
    }

}
