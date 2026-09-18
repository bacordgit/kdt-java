package three;

import java.util.ArrayList;
public class ArrayListPostTest {
    public static void main(String[] args) {
        ArrayList<Post> posts=new ArrayList<>();
        Post post1=new Post();
        Post post2=new Post();
        Post post3=new Post();
        post1.setTitle("t1");
        post1.setBody("b1");
        post2.setTitle("t2");
        post2.setBody("b2");
        post3.setTitle("t3");
        post3.setBody("b3");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        for(int i=0;i<3;i++){
            System.out.println(posts.get(i).getTitle()+"\t"+posts.get(i).getBody());
        }

    }
}
