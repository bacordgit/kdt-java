package chapter02.lesson05;

public class BaseLayerApp {
    public static void main(String[] args) {
        PostRepository repository = new MemoeyPostRepository();
        PostService service = new PostService(repository);
        service.register("closed", "body");
        service.printAll();
    }
}