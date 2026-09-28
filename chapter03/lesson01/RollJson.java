package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class RollJson {
    public static void main(String[] args) throws IOException {
        ArrayList<Post> posts =new ArrayList<>();
        Files.createDirectories(Path.of("data"));
        Path path=Path.of("data","empty.json");
        String json=toArrayJson(posts);
        Files.writeString(path,json, StandardCharsets.UTF_8);
        System.out.println("empty="+Files.readString(path,StandardCharsets.UTF_8));

        Path path1=Path.of("data","roll.json");
        posts.add(new Post("closed","no class"));
        posts.add(new Post("exam","bring id"));
        posts.add(new Post("kimbap","sold out"));
        json=toArrayJson(posts);
        Files.writeString(path1,json, StandardCharsets.UTF_8);
        String loaded=Files.readString(path1,StandardCharsets.UTF_8);
        System.out.println("json="+loaded);
        System.out.println("exists="+Files.exists(path1));
    }
    static String toJson(Post post){
        return "{\"title\":\""+post.getTitle()+"\",\"body\":\""+post.getBody()+"\"}";
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
}
