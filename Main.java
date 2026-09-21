public class Main {
    public static void main(String[] args) {
/*
        try {
            Animal dog = new Dog("뽀삐", 3);
            Animal cat = new cat("나비", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            System.out.println("종료");
        }*/
        Animal[]zoo={new Dog("개",3),new cat("언",2),new Animal("안녕",3)};
        for(Animal a:zoo){
            System.out.println(a.move());
        }
    }
}


