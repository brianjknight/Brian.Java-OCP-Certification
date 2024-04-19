package chapter5.methods;

public class PassByValue {

	   public static void main(String[] args) {      
		   var first = "Tiffany";
		   talk(first);
		   System.out.println(first);
		   	   
		   var name = new StringBuilder("Webby");      
		   speak(name);      
		   System.out.println(name); 
		   
		   speakAgain(name);
		   System.out.println(name);
		   
		   
		   String letters = "abc";
		   System.out.println("letters: " + letters);
		   addLetters(letters); // does not assign return value to local letters variable
		   System.out.println("letters after addLetters(): " + letters);
		   letters = addLetters(letters);
		   System.out.println("letters after letters = addLetters(letters): " + letters);
	   }   
	   
	   public static void talk(String firstName) {
		   firstName = "Sarah";
	   }
	   
	   public static void speak(StringBuilder s) {      
		   s.append("Georgette");
	   }
	   
	   public static void speakAgain(StringBuilder s) {
		   StringBuilder x = s.append("Brian"); // append to object reference name passed in then assigns to a new object x
		   x.append("Carol"); // calling method on reference to new object does not affect s/name reference now
		   System.out.println("x: " + x.toString());
		   
		   StringBuilder t = s;
		   s.append("Tammy");
		   t.append("Sally");
	   }
	   
	   static String addLetters(String letters) { // careful Strings are immutable; input param is a new variable
		   letters.toUpperCase(); // immutable returns new string which is not assigned
		   letters += "d";
		   return letters;
	   }
	
}
