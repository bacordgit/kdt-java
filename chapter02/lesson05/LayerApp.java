package chapter02.lesson05;

public class LayerApp {
    public static void main(String[] args) {
        MemoeyPostRepository repo=new MemoeyPostRepository();
        PostService service=new PostService(repo);
        PostController controller=new PostController(service);
        controller.create("closed","body");
        try{
            controller.create("","ignored");
        }catch(IllegalArgumentException e){
            System.out.println("reject= "+e.getMessage());
        }
        controller.create("exam","body");
        controller.close("p1");
        controller.list();
    }
}
