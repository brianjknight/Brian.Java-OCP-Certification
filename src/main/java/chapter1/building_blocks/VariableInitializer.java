package chapter1.building_blocks;

public class VariableInitializer {


    public void setTwo() {
        two = 2;
    }

    public int two() {
        return two;
    }

    private int two;

    public int three() {
        int one;
        int three;
        three = 3;
        return three;
    }

    public int valid() {
        int y = 10;
        int x; // x is declared here
        x = 3; // x is initialized here
        int z; // z is declared here but never initialized or used
        int reply = x + y;
        return reply;
    }

    public void initialize() {
        int a;
    }

    public void var() {
        var var
                = 4;

    }

    Primitives p = new Primitives();


    public static void main(String    ... args) {

        System.out.println(Primitives.code);

        VariableInitializer v = new VariableInitializer();

        System.out.println(v.two());
        v.setTwo();
        System.out.println(v.two());
        System.gc();
        System.out.println(v.three());
        System.out.println(v.valid());
    }

}
