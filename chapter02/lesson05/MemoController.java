package chapter02.lesson05;

public class MemoController {
    private final PostService service;

    public MemoController(PostService ps) {
        this.service = ps;
    }

    public void createAndShow(String title,String body){
        service.register(title,body);
        service.printAll();
    }
}
