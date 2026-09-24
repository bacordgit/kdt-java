package chapter02.lesson07;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> hit = Optional.of("김밥");
        Optional<String> empty = Optional.empty();
        System.out.println("hit=" + hit.orElseGet(() -> "품절"));
        System.out.println("miss=" + empty.orElseGet(() -> "품절"));
        hit.ifPresent(value -> System.out.println("선택=" + value));
    }
}