package chapter5.methods;

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
    public static void method1() {
        int x;
    }

    static public void method2() {
    }
    void method4() {
        return;
    }

    // does not compile
//	void method5() {
//		return "hello";
//	}
    // compiles but with unreachable code

    public String method6(int x) {
        if (5<10) return "less";
        return "greater";
    }


    public static void main(String[] args) {

    }
}	
