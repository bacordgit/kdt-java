package two;

public class Postdemo {
    public static void main(String[] args) {
        Post post=new Post();
        post.body="본문1";
        post.title="제목1";
        Post post1=new Post();
        post1.body="본문2";
        post1.title="제목2";
        Post post3=new Post();
        System.out.println(post3.title);
    }
}
