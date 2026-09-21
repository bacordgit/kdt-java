package chapter02.lesson03;

public class PostOopDemo {
    public static void main(String[] args) {
        Post post=new Post("closed","body");
        post.print();
        System.out.println(Post.getCount());
    }

}
