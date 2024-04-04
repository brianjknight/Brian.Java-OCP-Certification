package chapter6.classDesign;

public class TopLevel {

	// Nested classes can have access modifiers
	public class InnerLevel {}
	
	class PakcageLevel {}
	
	protected class ProtectedLevel {}
	
	private class PrivateLevel {}
}


//public class NextLevel {} only one public top level class allowed in a file
class NextLevel {}

class LowerLevel {}

class NotLevel {}

//private class SecretLevel {} // not allowed

//protected class TopSecretLevel {} // not allowed