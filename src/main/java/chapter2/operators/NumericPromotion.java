package chapter2.operators;

public class NumericPromotion {

    public static void main(String[] args) {
        char A = 'A';
        int x = 1000;
        System.out.println(A + x);

//        long a = 1000;
//        long b = 3_000_000_000_000_000;

        int y = 5;
        System.out.println("y=" + y);
        int z = (y=3);
        System.out.println("y=" + y);
        System.out.println("z=" + z);
        int q = y=1;
        System.out.println("y=" + y);
        System.out.println("q=" + q);


        float f = 10L;

    }
}
