package three;

import java.util.HashMap;
public class MapTest {
    public static void main(String[] args) {
        HashMap<String,String>orders=new HashMap<>();
        orders.put("mina","americano");
        orders.put("jun","kimbap");
        System.out.println(orders.get("mina"));
        orders.put("mina","kimbap");
        orders.replace("jun","americano");

        if(orders.containsKey("mina")){
            System.out.println(orders.get("mina"));
        }else{
            System.out.println("missing");
        }
        for(String name:orders.keySet()){
            System.out.println(name);
            System.out.println(orders.get(name));
        }
        for(String value: orders.values()){
            System.out.println(value);
        }
    }
}
