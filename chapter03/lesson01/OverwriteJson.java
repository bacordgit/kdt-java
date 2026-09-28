package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class OverwriteJson {
    public static void main(String[] args) throws IOException {
        Files.createDirectories(Path.of("data"));
        Path path=Path.of("data","price.json");
        Post post=new Post("menu","rice");
        Files.writeString(path,toJson(post), StandardCharsets.UTF_8);
        System.out.println(Files.readString(path,StandardCharsets.UTF_8));
        Post post1=new Post("soup","hot");
        Files.writeString(path,toJson(post1), StandardCharsets.UTF_8);
        System.out.println(Files.readString(path,StandardCharsets.UTF_8));
        System.out.println("kept="+Files.exists(Path.of("data","post.json")));

    }
    static String toJson(Post post){
        return "{\"title\":\""+post.getTitle()+"\",\"body\":\""+post.getBody()+"\"}";
    }

}

