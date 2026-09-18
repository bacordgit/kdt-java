package three;

import java.util.ArrayList;
public class MemberDemo {
    public static void main(String[] args) {
       ArrayList<Member>list=new ArrayList<>();
       Member m=new Member();
       m.id="m1";
       m.name="Kim";
       m.age=20;
       list.add(m);
       for(Member a:list){
           System.out.println(a.id+" "+ a.name+" "+ a.age);
           a.isNameKim();

       }


    }
}
