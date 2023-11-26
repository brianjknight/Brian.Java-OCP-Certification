package chapter5.methods;

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
    
 // not overloading
    void FLY(int i) {} 
    void fLy(int i ) {}
}
