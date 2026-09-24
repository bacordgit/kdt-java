package chapter02.lesson07;

import java.util.List;

public class ClosedTitles {
    public static void main(String[] args) {
        List<Post> posts=BaseStreamApp.createPosts();

        posts.stream()
                .filter(Post::isClosed)
                .map(Post::getTitle)
                .toList();
    }

}
