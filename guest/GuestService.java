package guest;

import java.util.ArrayList;

public class GuestService {
    private final GuestRepository repo;
    public GuestService(GuestRepository repo) {
       this.repo=repo;
    }
    public Guest register(String name){
        if(name==null || name.equals("")){
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }else{
            Guest g=new Guest(repo.nextID(),name);
            repo.save(g);
            return g;
        }
    }
    public Guest findById(int id){
        return repo.findById(id);
    }
    public ArrayList<Guest> findAll(){
        return repo.findAll();
    }
}
