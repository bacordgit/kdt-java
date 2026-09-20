package four;

import java.util.ArrayList;
import java.util.HashMap;
public class Academy {
    ArrayList<Student> list=new ArrayList<>();
    HashMap<Integer,Student> map=new HashMap<>();
    void addStudent(int no,String name,String subject,int score){
        Student s=new Student();
        s.setInfo(no,name,subject,score);
        list.add(s);
        map.put(no,s);
        System.out.println("등록 완료: "+name);

    }
    void printAll(){
        for(Student s:list){
            s.printInfo();
        }
    }
    void printOne(int no){
        Student s=map.get(no);
        if(s!=null){
            s.printInfo();
        }else{
            System.out.println("없는 번호: "+no);
        }
    }
    void updateScore(int no,int newScore){
        Student s=map.get(no);
        if(newScore<0 || newScore>100){
            System.out.println("점수가 벗어났습니다.");
            return;
        }
        if(s==null){
            System.out.println("없는 번호입니다.");
            return;
        }
        s.score=newScore;
    }
    void deleteStudent(int no){
        Student s=map.remove(no);
        if(s==null){
            System.out.println("없는 번호");
            return;
        }
        list.remove(s);
        System.out.println("삭제 완료");

    }
    ArrayList<Student> findAllBySubject(String subject){
        ArrayList<Student> SA=new ArrayList<>();
        for(Student s:list){
            if(subject.equals(s.subject)){
                SA.add(s);
            }
        }
        return SA;
    }
    void printBySubject(String subject){
        ArrayList<Student> result=findAllBySubject(subject);
    if(result.isEmpty()){
        System.out.println("해당 과목 수강생이 없습니다: "+subject);
    }else{
        System.out.println("== "+subject+" 수강생 ==");
        for(Student s: result){
           s.printInfo();
        }
    }
    }

    public static void main(String[] args) {
        Academy academy=new Academy();
        academy.addStudent(1,"홍길동","Java",90);
        academy.addStudent(2,"김철수","Java",85);
        academy.addStudent(3,"이영희","Python",95);
        academy.addStudent(4,"박민수","Java",70);
        academy.printAll();
        academy.updateScore(2,100);
        academy.printAll();
        academy.deleteStudent(1);
        academy.printAll();
        academy.printOne(3);
        academy.printBySubject("Java");
        academy.printBySubject("Python");
        academy.printBySubject("C++");


    }
}
