package chapter4.core_APIs;

public class StringMethods {

    public static void main(String[] args) {
        String animal = "elephants";

        int pChar = animal.indexOf('p');
        int pInt= animal.indexOf(112);
        System.out.println("pChar index: " + pChar);
        System.out.println("pInt index: " + pInt);

//        System.out.println(animal.startsWith('a'));
        System.out.println(animal.startsWith("e"));
        System.out.println(animal.contains("ant"));
        
        
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
        System.out.println(String.format("format number 2 decimals %08.4f", n));
        
        
        // String pool
        var a = "Hello World";
        var b = "Hello World"; // literal
        var b2 = "Hello" + " World"; //compile time constant
        var world = " World";
        var b3 = "Hello" + world;
        var c = new String("Hello World");
        var d = "Hello World".strip();
        var e = " Hello World\n".strip();
        var f = new String("Hello World").intern();
        
        System.out.println("");
        System.out.println("###String pool###");
        System.out.println("-----");
        System.out.println("a==b: " + a == b); //order of operations binary before equality "a==b: Hello World" == b
        System.out.println("a==b: " + (a==b));
        System.out.println("-----");
        System.out.println("a==b2: " + (a==b2));
        System.out.println("a==b3: " + (a==b3));
        System.out.println("a==c: " + (a==c));
        System.out.println("a==d: " + (a==d));
        System.out.println("a==e: " + (a==e));
        System.out.println("a==f: " + (a==f));
    }


}
