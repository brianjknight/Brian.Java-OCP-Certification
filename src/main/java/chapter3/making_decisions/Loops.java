package chapter3.making_decisions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Loops {
	
//	InitLabel : {System.out.println("initializer block");} // labels not allowed on initializers
	
    public static void main(String[] args) {
        boolean truthy = true;
        HONESTY: if (truthy)
            System.out.println("honest");
        else {
            System.out.println("liar");
            break HONESTY; // allowed but useless
        }
        
        int hungryHippopotamus = 8;
        while(hungryHippopotamus>0) {
            UNUSED_LABEL: do {
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus>5); // notice no statement or block after this while

            hungryHippopotamus--;
            System.out.println(hungryHippopotamus);
        }
        
        PRINT_LABEL: System.out.println();
        
        // labels and break
//        LABEL_A : int num = 1; // bad label, only allowed on control and block statements
        LABEL_B : {
        		// block statement
        	}
        LABEL_C : for (;;) break;
        
        LABEL_D : switch(" ") {default: System.out.println(" ");}
        
        
        System.out.println("myComplexArray loop:");
        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
            inner_loop: for(int i=0; i<mySimpleArray.length; i++) {
            	if (mySimpleArray[i] == 2) break inner_loop;
                IF_LABEL: if (mySimpleArray[i] == 12) {
                    break OUTER_LOOP;
                }
                System.out.print(mySimpleArray[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        int i;
        for (i=0; i<5; ++i) {
            System.out.println(i);
        }


        System.out.println();
        int j = 100;
        // iterative for loop only requires 2 semicolons for valid syntax
        for(;;) {
            System.out.println(j++);
            if (j==105) break;
        }
        
//        for (int j=0; ;) { // redeclaring local variable does not compile
//        	
//        }
        
        for (int a=1, b=1; a+b < 100 && a%b > 0; a++, b++) {
        	// initializer treated as multiple variable declaration
        	// boolean with logical/conditional operators
        	// update multiple variables with comma ','
        }

        int g = 5;
        for (g+=5; g<10; g++) 
        	System.out.println("g for loop: " + g);
        
//        while(false) { // will not compile; literal is known at compile time
//        	System.out.println("unreachable?");
//        };
        
        boolean f = false;
        while(f) { // variable values are unknown at compile time
        	System.out.println("unreachable?");
        }
        if(false) { // does compile since if statements are used for condtional execution logic 
        			// where as with 'while' you normally intend for code to execute until condition becomes false
        	System.out.println("unreachable?");
        }
        
        System.out.println();
        
        while (true) 
        	break;
        
        do
        	System.out.println("do while loop");
        while (false);
        
        
        // NOT an infinite loop due to underflow of byte
        byte bbb = 10;
        do {
        	bbb--;
        	System.out.println(bbb);
        } while(bbb<10);
        
        
        System.out.println();
        System.out.println("multidemnsional arrays:" );
        int[] _1D1 = new int[]{1, 2, 3};
//        _2D1[1] = new int[] {4,5,6}; // out of bounds
        int[][] _2D1 = new int[][]{ _1D1 };
        int[][] _2D2 = new int[][]{ _1D1, _1D1 };
        int[][][] _3D = new int[][][]{ _2D1, _2D2 };
        
        System.out.println("_2D1:");
        for(int[] ia : _2D1) System.out.println(Arrays.toString(ia));
        System.out.println("_2D2");
        for(int[] ia : _2D2) System.out.println(Arrays.toString(ia));
        System.out.println("_3D");
        for(int[][] _2d : _3D) {
        	for(int[] _1d : _2d) System.out.print(Arrays.toString(_1d));
        	System.out.println();
        }
        
        System.out.println();
        System.out.println("loop test using expressions for inialization: ");
        for(System.out.println("starting the loop now"); i<5; i++); //method call
        int z;
        for(printHello(), z = 9; ai.get()<5; addOne()); //method call
        System.out.println("z = " + z);
        System.out.println();
        List<Integer> myList = Arrays.asList(1,2,3);
        for (Iterator it = myList.iterator(); it.hasNext(); ) {
        	System.out.println(it.next());
        }
    }
    
    static AtomicInteger ai = new AtomicInteger(1);
    static void printHello() {
    	System.out.println("hello");
    }
    static void addOne() {
    	ai.incrementAndGet();
    }
}
