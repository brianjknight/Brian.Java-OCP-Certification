package chapter1.building_blocks;

public class Chick {
    { System.out.println("setting field"); }

    /**
	  Javadocs and multi-line comments do not require '*' on every line 
     * 
     
     */
    public Chick() {
         name = "Tiny";
         System.out.println("setting constructor");
        { System.out.println("initializer block inside constructor"); }
    }

    private String name = "Fluffy";
    {
        System.out.println(name);
    }
    {name = "Muffin";}
    {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);
    }
}
