package chapter02.lesson07;

import java.util.List;

public class StreamClosed {
    public static void main(String[] args) {
        List<Post> posts=BaseStreamApp.createPosts();
        posts.stream()
                .filter(post-> post.isClosed())
                .forEach(post-> System.out.println(post.getTitle()));
        Long a=posts.stream()
                .filter(post->post.isClosed())
                .filter(post->post.getTitle().contains("시험"))
                .count();
        System.out.println(a);//stream은 원본을 건들지 않는다.

    }
}
