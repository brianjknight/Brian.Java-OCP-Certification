package chapter3.making_decisions;

import java.util.List;

public class PatternMatching {
    public static void main(String[] args) {

        //****************************
        // Note this section is NOT pattern matching. It is traditional binary instance of operator.
        Number one = 1.0; 
        // *update note that Number is the reference type; 
        // the actual literal 1.0 double is autoboxed to Double which is the actual object type of the instance
        // below asks if ONE Double, is an instance of an integer; Both are related as Numbers which is why this compiles but does not print
        if (one instanceof Double) 
            System.out.println("it's a Double");
        // I think this is allowed to compile because ONE reference type is an abstract class and List is an interface. make more sense after you read Chapter 7
//        if (ONE instanceof List<?>) // also compiles
        if (one instanceof List) // *update omitting the generic type is equivalent of List<Object>
            System.out.println("It is a list");
        
        Integer two = 2;
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
        
        System.out.println();
        pm.subtypeTest();
    }

    void printOnlyIntegers(Number number) {
//        if (!(number instanceof Number data)) // Does not compile because data is not assigned
//        	System.out.println("printOnlyIntegers: " + data.intValue());
        if (number instanceof Integer data)
            System.out.println("printOnlyIntegers: " + data.intValue());
        else
//        	System.out.println(data); // 'data' not declared if not an Integer
            return;
    }

    void printOnlyIntegersFlowScopingCompiles(Number number) {
        if (!(number instanceof Integer data)) {
//        	System.out.println(data); // 'data' not declared
        	System.out.println("flow scoping not instance of Integer: " + number);
            return; // REQUIRED for flow scoping because 'data' variable might not be assigned
            		// ensures the next line of code is not reached
        }
        System.out.println("flow scoping IS integer: " + data.intValue());
    }

    void printIntegerTwice(Number number) {
        if (number instanceof Integer data)
            System.out.print(data.intValue());
//        	System.out.print(data.intValue()); // DOES NOT COMPILE not in code block AND not in scope with flow scoping
    }
    
    void subtypeTest() {
    	System.out.println("strictly subtype test for pattern matching:");
    	Integer i = Integer.valueOf(1);
    	if (i instanceof Integer) {
    		System.out.println(i);
    	}
    	if (i instanceof Integer num) { 
    		System.out.println(num);
    	}

    	Parent p = new Parent();
    	Child c = new Child();
    	if (c instanceof Parent XX) {
    		System.out.println("c instanceof Parent XX");
    	}
    	if (p instanceof Parent YY) {
    		System.out.println("p instanceof Parent YY");
    	}
    	
    	// from book
    	Integer value = 123;
    	if(value instanceof Integer) {}
    	if(value instanceof Integer data) {} // book says "DOES NOT COMPILE"
    }
}

class Parent {}
class Child extends Parent {}
