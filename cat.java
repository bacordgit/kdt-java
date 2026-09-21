public class cat extends Animal{
    public cat(String name, int age) {
        super(name, age);
    }
    @Override
    public String sound() {
        return "야옹";
    }
    @Override
    public String move() {
        return "살금살금 걷는다";
    }
}
