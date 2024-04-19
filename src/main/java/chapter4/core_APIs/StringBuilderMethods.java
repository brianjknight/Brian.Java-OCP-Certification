package chapter4.core_APIs;

public class StringBuilderMethods {
    public static void main(String[] args) {
    	
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(3,100);
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println();
        
        StringBuilder sb1 = new StringBuilder(10);
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        System.out.println(new StringBuilder().capacity());
        System.out.println();
        
        StringBuilder a = new StringBuilder("Brian");
        StringBuilder b = new StringBuilder("Brian");
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println();
        
        String name = "Brian";
        System.out.println(name.equals("Brian"));
        System.out.println(name=="Brian"); // because of String pool
        System.out.println(name==new String("Brian"));
    }
}
