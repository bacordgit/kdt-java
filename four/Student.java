package four;

public class Student {
    int no;
    String name;
    String subject;
    int score;
    void setInfo(int pNo,String pName,String pSubject,int pScore){
        no=pNo;
        name=pName;
        subject=pSubject;
        score=pScore;
    }
    void printInfo(){
        System.out.println(no+" / "+name+" / "+subject+" / "+score);
    }
}
