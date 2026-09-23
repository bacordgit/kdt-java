package chapter02.lesson06;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class SortTitles {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("exam", "bring id"));
        posts.add(new Post("closed", "no class"));
        posts.add(new Post("quiz", "code"));
        posts.sort((Post first,Post second)-> first.getTitle().compareTo(second.getTitle()));

        posts.sort(new Comparator<Post>(){
            @Override
            public int compare(Post first,Post second){
                return first.getTitle().compareTo(second.getTitle());
            }
        });
    }
}
