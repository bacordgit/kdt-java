package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class filePostList {
    public static void main(String[] args) throws IOException {
        Post post1=new Post("closed","no class");
        Post post2=new Post("exam","bring id");
        String json="["+toJson(post1)+","+toJson(post2)+"]";
        Files.createDirectories(Path.of("data"));
        Path path=Path.of("data","posts.json");
        Files.writeString(path,json, StandardCharsets.UTF_8);
        System.out.println(Files.readString(path,StandardCharsets.UTF_8));
    }
    static String toJson(Post post){
        return "{\"title\":\"" + post.getTitle()+"\",\"body\":\""+post.getBody()+"\"}";
    }
}
