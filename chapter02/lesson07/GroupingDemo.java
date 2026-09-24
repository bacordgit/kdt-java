package chapter02.lesson07;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class GroupingDemo {
    public static void main(String[] args) {
        List<Post> posts=AdvancedBaseApp.createPosts();
        Map<String,List<Post>> byTitle=posts.stream()
                .collect(Collectors.groupingBy(post->post.getTitle()));
        Map<String,Long> counts=posts.stream()
                .collect(Collectors.groupingBy(post->post.getTitle(),Collectors.counting()));
        String joined =posts.stream()
                .map(post->post.getTitle())
                .collect(Collectors.joining(", "));
        System.out.println("점심 묶음 크기: " + byTitle.get("점심").size());
        System.out.println("점심 개수: " + counts.get("점심"));
        System.out.println("제목: " + joined);
    }
}
