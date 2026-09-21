public class LunchThrow {
    public void takeMenu(String menu) {
        if(menu==null ||menu.equals("")){
            throw new IllegalArgumentException("empty-menu");
        }
        System.out.println("menu="+menu);
    }

    public static void main(String[] args) {
        LunchThrow lunchthrow=new LunchThrow();
        try {
            lunchthrow.takeMenu("");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
