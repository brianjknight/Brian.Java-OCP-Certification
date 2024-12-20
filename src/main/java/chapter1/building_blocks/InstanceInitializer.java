package chapter1.building_blocks;

public class InstanceInitializer {
    	
	{System.out.println("test 1");}
	
	
	{hello = "HELLO!";}
//	{System.out.println(hello);}  // initializers can initialize variable but NOT reference them otherwise until declared in lines code
	String hello = "Hello in class";
	{System.out.println(hello);}
	
	
	{System.out.println("test 2");}
	
	{hello = "hi";}
	
	static {System.out.println("static initializer");}
	
    {
        // instance initializer block i.e. code block outside of a method
        System.out.println(hello + " object iniitialization");
    }

    /*
     * Constructor
     */
    InstanceInitializer() {
        System.out.println("Constructor runs.");
    }


    public void doSomething() {
        //code block of a method

        {
            // code block inside of a method is only executes when the method is called.
            System.out.println("did something");
        }
    }

    // main method compiles but not best practice
    static final public void main(final String args[]) {
        System.out.println("hello from main");
        InstanceInitializer i = new InstanceInitializer();
        {
            // main is method so this is not considered an instance initializer
            System.out.println("hello main again?");
        }
        i.doSomething();
    }

    {
        // initializer block
        System.out.println("World");
    }
}
