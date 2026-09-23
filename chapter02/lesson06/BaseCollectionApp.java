package chapter02.lesson06;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class BaseCollectionApp {
    public static void main(String[] args) {
        /*Post post = new Post("p1", "closed", "no class");
        post.print();
        List<Integer> app=new ArrayList<>();
        app.add(2);
        int a=app.get(0);
        app.set(0,3);
        app.remove(0);

        Set<Integer> app1=new HashSet<>();
        app1.add(1);
        app1.toArray();*/
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("p1", "closed", "no class"));
        posts.add(new Post("p2", "exam", "bring id"));

        System.out.println("size=" + posts.size());
        System.out.println("first=" + posts.get(0).getTitle());

    }
}