package grocery;
import java.util.ArrayList;
import java.util.HashMap;
public class GroceryRepository {
    private final HashMap<Integer,GroceryItem> store=new HashMap<>();
    private final ArrayList<Integer> ids=new ArrayList<>();
    private int nextNumber=1;
    public int nextId(){
        return nextNumber++;
    }
    public void save(GroceryItem item){
        store.put(item.getId(),item);
        ids.add(item.getId());
    }
    public GroceryItem findById(int id){
        if(store.containsKey(id)){
            return store.get(id);
        }else throw new IllegalArgumentException("장을 찾을 수 없습니다. 번호="+id);
    }
    ArrayList<GroceryItem>findAll(){
        ArrayList<GroceryItem> list=new ArrayList<>();
        for(int id:ids){
            list.add(store.get(id));
        }
        return list;
    }
    public void replace(GroceryItem item){
        GroceryItem old= findById(item.getId());
       store.put(old.getId(),item);
    }
    public void delete(int id){
        GroceryItem a=findById(id);
        store.remove(id);
        ids.remove(Integer.valueOf(id));
    }

}
