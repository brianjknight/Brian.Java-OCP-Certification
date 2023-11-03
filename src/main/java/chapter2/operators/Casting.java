package chapter2.operators;

public class Casting {

    public static void main(String[] args) {

        float f = 100L;
        float fff = 3_000_000_000_000_000L;

        // Commented out lines do not compile because Java first recognized the default literal of int.
        // 2_147_483_648 is out of range for int.

        short num1 = 32_767;
        short num2 = (short) 40_000;
//        short numTwo = 40_000;
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
//        short num3 = (short) 2_147_483_648;

//        long num4 = (long) 2_147_483_648;
        long num5 = (long) 2_147_483_648L;
        long num6 = 2_147_483_648L;

    }
}
