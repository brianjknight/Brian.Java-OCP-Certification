package chapter6.classDesign;

public class CreateAClass {

    static String name = "Brian";
    String color = null;
    int num = 10;

    CreateAClass(String color) {

        color = color;
        System.out.println("color = " + color);
        
        System.out.println("this.color = " + this.color);

        this.color = color;
        System.out.println("this.color = " + this.color);

        this.color = "blue";
        System.out.println("this.color = " + this.color);
        
        color = this.color;
        System.out.println("color = " + color);
    }

    static void changeName() {
        // this.name = "Jim"; // this keyword cannot be referenced in a static context. an instance of the class is required
    }


    public static void main(String[] args) {
        CreateAClass red = new CreateAClass("red");
    }
}
