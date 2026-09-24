package chapter02.lesson07;
import java.util.List;
import java.util.function.Predicate;

public class LambdaClosed {
    public static void main(String[] args) {
        List<Post> posts=BaseStreamApp.createPosts();
        Predicate<Post> isClosed= post-> post.isClosed();
        Predicate<String> isClosed1=t1-> t1.isBlank();
        for(Post post:posts){
            if(isClosed.test(post)){
                System.out.println(post.getTitle());
            }
        }
    }
}
