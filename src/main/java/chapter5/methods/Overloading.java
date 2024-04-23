package chapter5.methods;

import java.util.ArrayList;
import java.util.List;

public class Overloading {
    public static void main(String[] args) {
    	Overloading over = new Overloading();
    	long a = 100;
    	short b = 1;
    	Integer c = 2;
    	
//    	over.fly(a); // cannot call method with smaller primitive type. requires explicit casting
    	over.fly((int)a);
    	over.fly(a);
    	over.fly(b);
    	over.fly(c);
    	
    	int i = 1;
    	over.swim(i); // exact match not available, checks for larger primitive before Autoboxing to Integer

    	int[] intArr = {1,2,3};
    	Integer[] INTarr = {4,5,6};
    	over.go(i); // following the overloading order, Java tries to Autobox then check for varargs so primitive is now Wrapper
    	over.go(c);
    	over.go(intArr);
    	over.go(INTarr);
    }

    void go(int[] list) {System.out.println("go(int[] list)");}
    void go(Integer... list) {System.out.println("go(Integer... list)");}

    void fly(int i) {System.out.println("int i");}
    void fly(long i) {System.out.println("long i");}
    void fly(Integer i) {System.out.println("Integer i");}
    
    void swim(byte b) {System.out.println("swim(byte b)");}
    void swim(long l) {System.out.println("swim(long l)");}
    void swim(Integer i) {System.out.println("swim(Integer i)");}
    
    
 // not overloading since method names are case sensitive
    void FLY(int i) {} 
    void fLy(int i) {}
    
    // different parameterized types are considered the same signature List<T> 
    // sub types are different signatures
    void methodOverload(List<String> list) {}
    void methodOverload(ArrayList<String> list) {}
//    void methodOverload(List<Integer> list) {}  // does not compile
//    void methodOverload(List<CharSequence> list) {} // does not compile
    
    
}
