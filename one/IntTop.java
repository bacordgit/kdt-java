package one;

public class IntTop {
    public static void main(String[] args) {
        int top=Integer.MAX_VALUE;
        int wrap=top+1;
        System.out.println("top="+top);
        System.out.println("wrap="+wrap);
    }
}
//top은 integer의 최댓값이고 wrap은 Integer에서 표현할 수 없으므로 처음부터 시작하는 음수가 나온것 같다.