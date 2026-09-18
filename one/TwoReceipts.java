package one;

public class TwoReceipts {
    public static void main(String[] args) {
        int kimbap=4500;
        int water=1000;
        int count=2;
        int mix=kimbap+water*count;
        int pack=(kimbap+water)*count;
        int sum=kimbap+water;
        System.out.println("mix="+mix);//mix는 water와 count사이의 연산을 먼저 계산합니다.
        System.out.println("pack="+pack);//pack은 kimbap과 water사이의 연산을 먼저 계산합니다.
        System.out.println("wrong="+kimbap+water);
        System.out.println("sum="+sum);
    }
}
