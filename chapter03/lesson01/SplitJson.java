package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SplitJson {
    public static void main(String[] args) throws IOException {
        Post post1=new Post("closed","no class");
        Post post2=new Post("exam","bring id");
        String json="["+toJson(post1)+","+toJson(post2)+"]";
        Path path=Path.of("data","pair.json");
        Files.writeString(path,json, StandardCharsets.UTF_8);
        System.out.println("json="+Files.readString(path,StandardCharsets.UTF_8));
        Path path1=Path.of("data","one.json");
        Files.writeString(path1,toJson(post1), StandardCharsets.UTF_8);
        System.out.println("one="+Files.readString(path1,StandardCharsets.UTF_8));

    }
    static String toJson(Post post){
        return "{\"title\":\"" + post.getTitle()+"\",\"body\":\""+post.getBody()+"\"}";
    }
}
