package chapter6.classDesign;

public class TopLevel {
//	public static class TopLevel { // only public, abstract, and final modifiers permitted on TOP level classes

	// Nested classes can have modifiers
	public static class InnerLevel {}
	
	protected class ProtectedLevel {}
	
	static class PakcageLevel {}
	
	private class PrivateLevel {}
	

	public TopLevel() {
		System.out.println(this); 
	}
	public static void main(String[] args) {
		new TopLevel();
	}
}

//public class other {} only ONE public top level class allowed in a file

//only nested classes can be static, private, or protected
//static class otherTopLevel {}
//private class SecretLevel {}
//protected class TopSecretLevel {}

abstract class otherTpLvl {}

final class NotLevel {}
