package chapter6.classDesign;

public class CreateAClass {

    static String first = "Brian";
    String middle;
    String last;
    String color = null;
    int num = 10;

    CreateAClass(String color) {

        color = color;
        System.out.println("color = " + color);
        
        System.out.println("this.color = " + this  .  color);
        String clr = this   .   color;
        
        // "this" is allowed because an instance is being created
        this.color = color;
        System.out.println("this.color = " + this.color);

        this.color = "blue";
        System.out.println("this.color = " + this.color);
        
        color = this.color;
        System.out.println("color = " + color);
    }

    static void changeName() {
        // this.name = "Jim"; // this keyword cannot be referenced in a static context. an instance of the class is required
    	first = "James";
    }
    
    public void setMiddleANdLast(String newMiddle, String last) {
    	middle = newMiddle;
    	this.last = last;
    }


    public static void main(String[] args) {
        CreateAClass orange = new CreateAClass("orange");
        CreateAClass red = new   CreateAClass    ("red")    ;
        red.changeName();
        red   .   changeName();
//        red.    color;
        System.out.println(Math .   random (  )   );
    }
}
