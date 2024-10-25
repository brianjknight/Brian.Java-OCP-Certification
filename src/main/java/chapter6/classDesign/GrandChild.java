package chapter6.classDesign;

public class GrandChild extends Child {
	
	public GrandChild() throws Exception {
		
	}
	
	public void doMoreWork() {
		super.doWork(); // inherited from Child which was inherited from Parent
	}
	
	public static void main(String[] args) {
		GrandChild gc;
		try {
			gc = new GrandChild();
			gc.sayGoodBye();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sayGoodBye() {
		super.sayGoodBye();
	}
}
