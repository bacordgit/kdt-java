public class Animal {
    private String name;
    private int age;
    private static int count=0;
    public Animal(String name,int age){
        if(age<=0){
            throw new IllegalArgumentException("age-error");
        }
        this.name=name;
        this.age=age;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String sound(){
        return "...";
    }
    public static int getCount(){
        return count;
    }
    public String move(){
        return "이동한다";
    }
}
