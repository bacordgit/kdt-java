package guest;
import java.util.ArrayList;
public class GuestRepository {
    ArrayList<Guest>guests=new ArrayList<>();
    private static int nextNumber=1;
    public int nextID(){
      return nextNumber++;
    }
    public void save(Guest guest){
        guests.add(guest);
    }
    public Guest findById(int id){
        for(Guest guest:guests){
            if(guest.getId()==id)
                return guest;
        }
        throw new IllegalArgumentException("명단에 없습니다. 번호="+id);
    }
    public ArrayList<Guest>findAll(){
        return new ArrayList<>(guests);
    }
}
