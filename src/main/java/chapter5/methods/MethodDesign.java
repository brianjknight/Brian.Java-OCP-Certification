package chapter5.methods;

import java.util.ArrayList;
import java.util.List;

public class MethodDesign {
    int a;
    final int b = 4;
    final int c;
    {c=1;}
    final int d;
    //final int e; // final instance variables must be assigned.

    MethodDesign() {
        d = 2;
    }

    { int a = 11; } // initialer block in class is new scope to declare variable
//    int a = 20; // duplicate variable
    
    void doNothing() {
    	int a = 10; // create new local variable within a method i.e. SHADOWING
    	int z = 0;
    	System.out.println(a);
    	System.out.println(this.a);
//    	{ int a = 11; } // considered duplicate local variable code block in method
    	
//    	if (true) {
//    		int a = 11; // considered duplicate local variable
//    	}
//    	if (true) {
//    		int z = 5; // not SHADOWING 
//    	}
    }
//	default void nothing() {
//	}

//	package void notValid() {
//	}
    public static void $method1() {
        final int x;
    }

    static public final void _method2() {
    	System.out.println();
    }
    
    void method4() {
        return;
    }
    
//    void _() { 
//    	
//    }

    // does not compile
//	void method5() {
//		return "hello";
//	}
    // compiles but with unreachable code

    public String method6(int x) {
        if (5<10) {
        	return "less";
//        	System.out.println("unreachable compile error");
        }
        return "greater"; // unreachable warning since method must return String for all branches
    }
    
    String hike(int a) {
    	if (1<2) return "hike";
    	return "can't hike";
    }

    public static void main(String[] args) {
    	System.out.println("run");
    }
}	
