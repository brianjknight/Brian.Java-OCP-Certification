package chapter4.core_APIs;

public class StringBuilderMethods {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(3,100);
        System.out.println(sb);

    }
}
