package chapter4.core_APIs;

import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] a, b;
        a = new int[2];
//        a = {1,2}; //does not compile
        b = new int[]{1,2,3};

        int c  []= {1,2};

        int nums[], num;
        nums = new int[]{1,2};
        num = 3;

        // sorting & binary search arrays:
        int[] moreNums = {5,3,1,2,4};
        System.out.println(Arrays.binarySearch(moreNums, 2));
        System.out.println(Arrays.binarySearch(moreNums, 3));
        java.util.Arrays.sort(moreNums);
        System.out.println(java.util.Arrays.toString(moreNums));
        System.out.println(Arrays.binarySearch(moreNums, 3));

        // comparing arrays
        int  []   one = {2,4,6};
        int[] two = {3};
        System.out.println(Arrays.compare(one,two));
        System.out.println(Arrays.compare(two,one));

        int[] oneDifferentOrder = {4,6,2};
        System.out.println("Arrays.mismatch: " + Arrays.mismatch(one, oneDifferentOrder));
        
        System.out.println(Arrays.equals(one, oneDifferentOrder));
        Arrays.sort(oneDifferentOrder);
        System.out.println("Arrays.equals(): " + Arrays.equals(one, oneDifferentOrder));
        System.out.println("one.equals(oneDifferentOrder: )" + one.equals(oneDifferentOrder));
        
        int[][] abc = new int[4][4];
        int def[][] = new int[4][];
        def[0] = new int[4];
        
        int[] f[], g[][], h[][][][];

        int i[], j;
        j = 2;
        i = new int[] {1,j};
        
        int[] x = new int[2];
        String[] y = new String[2];
        Integer[] z = new Integer[] {1,2};
        // must be of same type
//        Arrays.equals(x, y);
//        Arrays.mismatch(x, y);
//        Arrays.compare(x, y);
//        Arrays.equals(x, z);
        
        // compiles but throws runtime outofbounds exception
        String[][][] threeD = new String[3][0][5];
        threeD[0][0][1] = "hello";
    }
}
