package chapter3.making_decisions;

import java.util.List;

public class PatternMatching {
    public static void main(String[] args) {

        //****************************
        // Note this section is NOT pattern matching. It is traditional binary instance of operator.
        Number one = 1.0;
        if (one instanceof Integer)
            System.out.println("it's an Integer");
        // I think this is allowed to compile because one reference type is an abstract class and List is an interface. make more sense after you read Chapter 7
        if (one instanceof List<?>)
            System.out.println("It is a list");

        Integer two = (Integer) 2;
        if (two instanceof Number)
            System.out.println("it's a Number");
//        if (two instanceof List<?>) // does not compile make more sense after you read Chapter 7
//            System.out.println("it's a List");
        //****************************


        PatternMatching pm = new PatternMatching();
        Integer six = 6;
        Double seven = 7.0;
        pm.printOnlyIntegers(six);
        pm.printOnlyIntegers(seven);

        pm.printOnlyIntegersFlowScopingCompiles(six);
        pm.printOnlyIntegersFlowScopingCompiles(seven);
    }

    void printOnlyIntegers(Number number) {
//        if (!(number instanceof Number data)) Does not compile because it is not a strict subtype
        if (number instanceof Integer data)
            System.out.println(data.intValue());
        else
            return;
    }

    void printOnlyIntegersFlowScopingCompiles(Number number) {
        if (!(number instanceof Integer data)) {
            return;
        }
        System.out.println(data.intValue());
    }

    void printIntegerTwice(Number number) {
        if (number instanceof Integer data)
            System.out.print(data.intValue());
//        System.out.print(data.intValue()); // DOES NOT COMPILE not in code block
    }
}
