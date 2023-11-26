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
		   
	   }   
	   
	   public static void talk(String firstName) {
		   firstName = "Sarah";
	   }
	   
	   public static void speak(StringBuilder s) {      
		   s.append("Georgette");
	   }
	   
	   public static void speakAgain(StringBuilder s) {
		   StringBuilder t = s;
		   s.append("Tammy");
		   t.append("Sally");
	   }
	
}
