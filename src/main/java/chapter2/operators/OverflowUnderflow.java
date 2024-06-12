package chapter2.operators;

public class OverflowUnderflow {

    public static void main(String[] args) {
        byte biggestByte = 127;
        System.out.println("biggestByte  " + biggestByte);
        // Does not compile 128 is out of range.
//        byte tooBig = 128;
        // Does not compile. Because of type promotion and the binary operator, biggestByte is promoted to an int
//        byte tooBigAgain = biggestByte + 1;

        biggestByte++;
        System.out.println("biggestByte++ overflow  " + biggestByte);

        byte overflow = (byte) 256;
        System.out.println("casting overflow  " + overflow);

        byte smallestByte = -128;
        System.out.println("smallestByte  " + smallestByte);
        smallestByte--;
        System.out.println("smallestByte-- underflow  " + smallestByte);
        
        smallestByte -= 10000; // underflow WITH automatic casting by compound assignment operator
        System.out.println(smallestByte);
    }

}
