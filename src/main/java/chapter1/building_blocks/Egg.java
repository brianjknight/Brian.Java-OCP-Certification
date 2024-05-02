package chapter1.building_blocks;

public class Egg {
    public Egg() {
        number = 5;
    }
    public static void main(String[] eggcellent) {
        System.out.println("main method");
        Egg egg = new Egg();
//        egg.main("a","b");
        egg.main(new String[] {}); // compiles but creates infinite loop
        System.out.println(egg.number);
    }
    private int number = 3;
    {
        System.out.println(number);
    }
    { number = 4; }
    {
        System.out.println(number);
    }
}
