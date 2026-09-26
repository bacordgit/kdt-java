package grocery;

import java.util.ArrayList;

public class GroceryService {
    private final GroceryRepository repo;

    public GroceryService(GroceryRepository repo) {
        this.repo = repo;
    }
   public GroceryItem register(String name,int quantity){
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException("이름이 비어있습니다.");
        if(quantity<1)
            throw new IllegalArgumentException("수량은 1이상입니다.");
        GroceryItem item=new GroceryItem(repo.nextId(),name,quantity);
        repo.save(item);
        return item;
    }
    public GroceryItem findById(int id){
        return repo.findById(id);
    }
    public ArrayList<GroceryItem> findAll(){
        return repo.findAll();
    }
    public GroceryItem changeQuantity(int id,int quantity){
        if(quantity<1)
            throw new IllegalArgumentException("수량은 1 이상입니다.");
        GroceryItem item = new GroceryItem(id,repo.findById(id).getName(),quantity);
        repo.replace(item);
        return item;
    }
    public void delete(int id){
        repo.delete(id);
    }

}
