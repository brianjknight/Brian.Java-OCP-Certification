package chapter3.making_decisions;

public class Loops {
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
        System.out.println();
        
        
        // labels and break
        System.out.println("myComplexArray loop:");
        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
            inner_loop: for(int i=0; i<mySimpleArray.length; i++) {
            	if (mySimpleArray[i] == 2) break inner_loop;
                if (mySimpleArray[i] == 12) {
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

    }
}
