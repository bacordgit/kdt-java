public class Dog extends Animal{
    public Dog(String name,int age){
        super(name,age);
    }
    @Override
    public String sound() {
        return "멍멍";
    }
    @Override
    public String move() {
        return "네 발로 달린다";
    }
}
