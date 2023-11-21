package chapter3.making_decisions;

import java.util.ArrayList;
import java.util.List;

public class Loops {
    public static void main(String[] args) {
        boolean truthy = true;
        HONESTY: if (truthy)
            System.out.println("honest");
        else {
            System.out.println("liar");
        }


        int hungryHippopotamus = 8;
        while(hungryHippopotamus>0) {
            UNUSED_LABEL: do {
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus>5); // notice no statement or block after this while

            hungryHippopotamus--;
            System.out.println(hungryHippopotamus);
        }

        System.out.println("*".repeat(50));

        // labels and break
        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
            inner_loop: for(int i=0; i<mySimpleArray.length; i++) {
                if (mySimpleArray[i] == 8) {
                    break OUTER_LOOP;
                }
                if (mySimpleArray[i] == 2) break inner_loop;
                System.out.print(mySimpleArray[i]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("***********");
        int i;
        for (i=0; i<5; ++i) {
            System.out.println(i);
        }


        System.out.println("#####################");
        int j = 100;
        // iterative for loop only requires 2 semicolons for valid syntax
        for(;;) {
            System.out.println(j++);
            if (j==120) break;
        }

    }
}
