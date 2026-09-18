package two;

public class Looptest {
    public static void main(String[] args) {
        int a;
        for(int n=2;n<=100;n*=2){
            a=2;
            System.out.println(n);
        }

        for (int n = 2; n < 10; n++) {

            for (int i = 1; i < 10; i++) {
                System.out.println(n + "*" + "i=" + n * i);
            }

        }
    }
}
