package chapter6.classDesign;

import javax.management.remote.SubjectDelegationPermission;

public class GrandChild extends Child {
	
	public void doMoreWork() {
		super.doWork(); // inherited from Child which was inherited from Parent
	}
	
	public static void main(String[] args) {
		GrandChild gc = new GrandChild();
		gc.sayGoodBye();
	}
	
	public void sayGoodBye() {
		super.sayGoodBye();
	}
}
