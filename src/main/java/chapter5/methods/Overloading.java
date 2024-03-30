package chapter5.methods;

import java.util.ArrayList;
import java.util.List;

public class Overloading {
    public static void main(String[] args) {
    	Overloading over = new Overloading();
    	long a = 100;
    	short b = 1;
    	
//    	over.fly(a); // cannot call method with smaller primitive type. requires explicit casting
    	over.fly((int)a);
    	over.fly(b);
    }

    void go(int[] list) {}
    void go(Integer[] list) {}

    void fly(int i) {}
    void fly(Integer i) {}
    
 // not overloading since method names are case sensitive
    void FLY(int i) {} 
    void fLy(int i ) {}
    
    // different parameterized types are considered the same signature List<T> 
    // sub types are different signatures
    void methodOverload(List<String> list) {}
    void methodOverload(ArrayList<String> list) {}
//    void methodOverload(List<Integer> list) {}  // does not compile
//    void methodOverload(List<CharSequence> list) {} // does not compile
    
    
}
