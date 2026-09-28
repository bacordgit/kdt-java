package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CafeSafe {
    public static void main(String[] args) throws IOException {
        ArrayList<Post> list=new ArrayList<>();
       list.add(new Post("pork","6000won"));
       list.add(new Post("water","1000won"));
       String result=toArrayJson(list);
       Path path= Path.of("data");
        Files.createDirectories(path);
        path=Path.of("data","cafe.json");
        Files.writeString(path,result,StandardCharsets.UTF_8);
        System.out.println("json="+Files.readString(path,StandardCharsets.UTF_8));
        System.out.println("exists="+Files.exists(path));


    }
    static String toArrayJson(ArrayList<Post> posts){
        String json="[";
        for(int i=0;i<posts.size();i++){
            if(i>0){
                json=json + ",";
            }
            json=json+toJson(posts.get(i));
        }
        json+="]";
        return json;
    }
    static String toJson(Post post){
        return "{\"title\":\"" + post.getTitle()+"\",\"body\":\""+post.getBody()+"\"}";
    }
}
