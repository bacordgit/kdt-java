package two;

public class ArrayTest {
    public static void main(String[] args) {
        String[] titles2=new String[3];
        titles2[0]="closed";
        String[] titles={"closed","exam","holiday"};
        System.out.println(titles);
        System.out.println(titles[0].length());
        System.out.println(titles.length);
        System.out.println(titles2);
        String[] titles3=new String[3];
        System.out.println(titles3[0]);

        int[] ints=new int[5];
        System.out.println(ints[0]);

        int[] titles5 = {1, 2, 3};
        int[] titles6 = titles5;

        System.out.println(titles);
        System.out.println(titles2);

        titles6[0] = 99;

        System.out.println(titles5[0]);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(i + "=" + ints[i]);
        }
        for(int idx : ints){
            System.out.println(ints[idx]);
        }

        int[][] data={{1,2},{3,4}};
        int[][]dataCopy=new int[data.length][];
        for(int i=0;i<data.length;i++){
            dataCopy[i]=data[i].clone();
            System.out.println(dataCopy[i]);
        }

    }
}
