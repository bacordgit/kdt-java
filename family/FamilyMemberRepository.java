package family;
import java.util.HashMap;
import java.util.ArrayList;
public class FamilyMemberRepository {
    private final HashMap<Integer,FamilyMember> store=new HashMap<>();
    private final ArrayList<Integer> ids=new ArrayList<>();
    private int nextNumber=1;
    public int nextId(){
        return nextNumber++;
    }
    public void save(FamilyMember member){
        store.put(member.getId(),member);
        ids.add(member.getId());
    }
    public FamilyMember findById(int id){
        if(ids.contains(id)){
            return store.get(id);
        }else{
            throw new SongpyeonNotFoundException("가족을 찾을 수 없습니다. 번호="+id);
        }
    }
    public ArrayList<FamilyMember> findAll(){
        ArrayList<FamilyMember> list=new ArrayList<>();
        for(int id:ids){
            list.add(store.get(id));
        }
        return list;
    }

}
