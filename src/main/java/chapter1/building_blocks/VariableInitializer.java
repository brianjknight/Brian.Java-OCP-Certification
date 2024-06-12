package chapter1.building_blocks;

import java.util.List;

public class VariableInitializer {
	
//	var zzz = "z"; // not a local variable cannot use var
	String $ = "dollar sign";
	String String = "string"; // String is NOT a reserved keyword
	Boolean Boolean = false;
//	Boolean boolean = false; // primitives ARE reserved keywords
	
	void declareVars() {
//		var a = 1, b = 2;  multiple declaration not allowed with var
//		var a = null; // Java must know var reference type at compile time
		var a = "AAA";
		a = null;
		
		var String = 1;
		
		var four = 
					
				'4';
		
		var twoD = new int[][]{ {1, 2}, null }; // here "var" represents int[][]
//		var[][] twoD = new int[][]{ {1, 2}, null }; // implies arrays are of type var vs int or other type. Similar to var List<var> ?
//		var other2D[][] = {{a},{a}}; // mixing local variable type inference with declaration
		int[][] goodTwo = { {1, 2}, null };
//		List<var> varList; // not allowed
	}
	
//	void noGood(var a) { 
//		// code
//	}

    public void setTwo() {
        two = 2;
    }

    public int two() {
        return two;
    }

    private int two;

    public int three() {
        int one;
        int three;
        three = 3;
        return three;
    }

    public int valid() {
        int y = 10;
        int x; // x is declared here
        x = 3; // x is initialized here
        int z; // z is declared here but never initialized or used
        int reply = x + y;
        return reply;
    }

    public void initialize() {
        int a;
    }

    Primitives p = new Primitives();

    public static void main(String    ...    args    ) {

        System.out.println(Primitives.code);

        VariableInitializer v = new VariableInitializer();

        System.out.println(v.two());
        v.setTwo();
        System.out.println(v.two());
        System.gc(); // you can call garbage collection but no guarantee it does anything since Java handles this automatically
        System.out.println(v.three());
        System.out.println(v.valid());
    }

}
