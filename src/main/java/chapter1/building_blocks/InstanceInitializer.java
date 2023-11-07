package chapter1.building_blocks;

public class InstanceInitializer {
    String hello = "Hello in class";
    {
        // instance initializer block i.e. code block outside of a method
        System.out.println(hello + " before main");
    }

    InstanceInitializer() {
        System.out.println("Constructor called.");
    }


    public void doSomething() {
        //code block of a method

        {
            // code block inside of a method is only executes when the method is called.
            System.out.println("did something");
        }
    }

    public static void main(final String[] args) {
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
