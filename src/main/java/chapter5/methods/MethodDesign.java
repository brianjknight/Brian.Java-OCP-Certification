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

    void doNothing() {
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
    
    

    public static void main(String[] args) {
    	System.out.println("run");
    }
}	
