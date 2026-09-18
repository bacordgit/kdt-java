package three;

import java.util.HashMap;
public class StudentLookup {
    public static void main(String[] args) {
        HashMap<String,String>students=new HashMap<>();
        /*students.put("2024001","김민");
        students.put("2024002","이준");
        System.out.println(students.get("2024001"));
        System.out.println(students.get("2024002"));
        System.out.println(students.get("2024999"));*/
        students.put("2024001","김민");
        students.put("2024001","김민수");
        System.out.println(students.get("2024001"));
        System.out.println(students.size());
        students.put("2024002","이준");
        System.out.println(students.size());
        if(students.containsKey("2024001"))
            System.out.println(students.get("2024001"));
        else System.out.println("missing");
        if(students.containsKey("2024999"))
            System.out.println(students.get("2024999"));
        else System.out.println("missing");
        for(String a:students.keySet()){
            System.out.println(a+ " "+students.get(a));
        }
        students.put("2024003","박소라");
        students.put("2024001","김민");
        System.out.println(students.get("2024001"));
        System.out.println(students.get("2024003"));
        System.out.println(students.size());

        String[] ids = {"2024004", "2024005", "2024004"};
        String[] names = {"최윤", "정하", "최윤서"};
        for(int i=0;i<ids.length;i++){
            students.put(ids[i],names[i]);
        }
        System.out.println(students.size());
        System.out.println(students.get("2024004"));
        System.out.println(students.get("2024005"));

    }

}
