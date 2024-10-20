package chapter2.operators;

/****************************************************************************
 * <b>Title:</b> BitwiseOperators.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> CHANGE ME! <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jul 20, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

public class BitwiseOperators {
	public static void main(String[] args) {
		byte b5 = 1;
        byte b7 = 2;
        byte b5or7 = (byte)(b5 | b7);
        System.out.println("(b5 | b7) = " + b5or7);
        System.out.println("(b5 & b7) = " + (byte)(b5 & b7));
        System.out.println("(b5 ^ b7) = " + (byte)(b5 ^ b7));
        // above numeric promotion is affecting the result

        // below prints the actual byte result; 
        // 5 is 0101
        // 7 is 0111
        System.out.println(5 | 7);
        System.out.println(5 & 7);
        System.out.println(5 ^ 7);
        
        System.out.println(true | true);
        System.out.println(true & true);
        System.out.println(true ^ true);
	}
}


