package chapter02.lesson03;

public class Post {
    private String title;                        // 문제를 확인하기 위한 임시 public 필드
    private String body;
    public Post(String title,String body){
        this.title=title;
        this.body=body;
    }

    public void print() {
        System.out.println("title=" + title);
        System.out.println("body=" + body);
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setBody(String body){
        this.body=body;
    }
}
