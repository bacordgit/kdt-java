package chapter03.lesson01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHello {
    public static void main(String[] args) throws IOException {
        Path dir=Path.of("data");

        Files.createDirectories(dir);

        Path path=Path.of("data","hello.txt");
        Files.writeString(path,"kimbap\n", StandardCharsets.UTF_8);

        String text=Files.readString(path,StandardCharsets.UTF_8);

        System.out.println("text= "+text.stripTrailing());
        System.out.println("exists= "+Files.exists(path));
        System.out.println("path= "+path.toAbsolutePath());
    }
}
