package chapter02.lesson04;

public class Tray {
    private final CafeItem[] items;
    public Tray(CafeItem[] items){
        this.items=items;
    }
    public void printAll(){
        for(CafeItem a:items){
            a.printWon();
        }
    }
    public int total(){
        int total=0;
        for(CafeItem a:items){
            total+=a.price();
        }
        return total;
    }

}
