package chapter4.core_APIs;

import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] a, b;
        a = new int[2];
        b = new int[]{1,2,3};

//        a = {1,2}; //does not compile
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
        int[] one = {2,4,6};
        int[] two = {1};
        System.out.println(Arrays.compare(one,two));

        int[] oneDifferentOrder = {4,6,2};
        System.out.println(Arrays.mismatch(one, oneDifferentOrder));
    }
}
