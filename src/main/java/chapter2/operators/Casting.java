package chapter2.operators;

public class Casting {

    public static void main(String[] args) {

        float f = 100L;
        float fff = 3_000_000_000_000_000L;

        // Commented out lines do not compile because Java first recognized the default literal of int.
        // 2_147_483_648 is out of range for int.

        short num1 = 32_767;
        short num2 = (short) 40_000;
//        short numX = (short) 98_303 + 1; // casts and overflows short value first then add which is now larger than max short value 
//        short numTwo = 40_000;
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2);
//        System.out.println("num2=" + numX);
//        short num3 = (short) 2_147_483_648;
        short num3 = (short) 2_147_483_648L;

//        long num4 = (long) 2_147_483_648; // bad cast then assumes literal default of int for which the value is too large
//        long num4 = (long) 2_147_483_647; // good
        long num5 = (long) 2_147_483_648L;
        long num6 = 2_147_483_648L;

        
        byte fifteen = 5 + 10;
        byte ten = 10;
//        byte b = 5 + ten; // while not compile using a variable due to ambiguity
//        byte c = 5 + (byte)ten; // also does not compile > casting happens first, THEN binary operator with variable always promotes
        byte d = (byte)(5 + ten);
        byte e = 5 + (byte)200; // not ambiguous casting a value instead of variable. 200 is an int but overflows with casting
        
        //-139 underflows to +117
//        byte bad = 11 + (byte)-139; // 117 + 11 = 128 is out of range for byte   
        byte good = 10 + (byte)-139; // 117 + 10 = 127 within byte range value
  
//        byte badAgain = 100 + 30;
        byte goodAgain = 100 + 27;
        
    }
}
