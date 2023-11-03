package chapter4.core_APIs;

public class StringMethods {

    public static void main(String[] args) {
        String animal = "elephants";

        int pChar = animal.indexOf('p');
        int pInt= animal.indexOf(112);
        System.out.println("pChar index: " + pChar);
        System.out.println("pInt index: " + pInt);

        // substring index
        System.out.println(animal.substring(0,3));
        // IndexOutOfBoundsException -> RuntimeException
//        System.out.println(animal.substring(10));
        System.out.println(animal.substring(animal.indexOf('a')));
        System.out.println(animal.substring(animal.indexOf('a'),9));


        // formatting runtime error when mixing data types float with integer %d
//        System.out.println("float %d".formatted(10.123456));

        double n = 1.123456;
        System.out.println(String.format("format number 2 decimals %f", n));
        System.out.println(String.format("format number 2 decimals %.2f", n));
        System.out.println(String.format("format number 2 decimals %1.2f", n));
        System.out.println(String.format("format number 2 decimals %12.4f", n));
        System.out.println(String.format("format number 2 decimals %012.4f", n));
    }


}
