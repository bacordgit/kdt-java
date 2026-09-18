import java.util.ArrayList;
public class StudentService {
    StudentRepository repository=new StudentRepository();
    void join(int no,String name,String subject,int score){
        if(repository.findByNo(no)!=null){
            System.out.println("이미 존재하는 번호: "+no);
            return;
     }
        Student s=new Student();
        s.setInfo(no,name,subject,score);
        repository.save(s);
        System.out.println("등록 완료: "+name);
    }
    void printAll(){
        for(Student s: repository.findAll()){
            s.printInfo();
        }
    }
    void printOne(int no){
        Student s=repository.findByNo(no);
        if(s==null) {
            System.out.println("없습니다.");
            return;
        }
            s.printInfo();

    }
    void changeScore(int no,int newScore){
        Student s=repository.findByNo(no);
        if(s==null){
            System.out.println("없는 번호 입니다.");
            return;
        }
        if(newScore<0 || newScore>100){
            System.out.println("범위를 벗어났습니다.");
            return;
        }
        repository.updateScore(s,newScore);
        System.out.println("수정 완료: "+no);
    }
    void remove(int no){
        Student s=repository.findByNo(no);
        if(s==null) {
            System.out.println("없는 번호: " + no);
            return;
        }
        repository.delete(no);
        System.out.println("삭제 완료: "+no);
    }
    void printBySubject(String subject) {
        ArrayList<Student> s = repository.findAllBySubject(subject);
        if (s.isEmpty()) {
            System.out.println("해당 과목 수강생이 없습니다: " + subject);
            return;
        }
        System.out.println("==" + subject + " 수강생 ==");
        for (Student st : s) {
            st.printInfo();
        }
    }
}
