package chapter6.classDesign;

public class TopLevel {
//	public static class TopLevel { // only public, abstract, and final modifiers permitted on TOP level classes

	// Nested classes can have modifiers
	public static class InnerLevel {}
	
	protected class ProtectedLevel {}
	
	static class PakcageLevel {}
	
	private class PrivateLevel {}
}

//public class other {} only ONE public top level class allowed in a file
//static class otherTopLevel {} // only nested classes can be static

abstract class otherTpLvl {}

final class NotLevel {}

//private class SecretLevel {} // not allowed

//protected class TopSecretLevel {} // not allowed