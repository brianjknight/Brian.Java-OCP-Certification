package chapter1.building_blocks;

import java.util.Random;

public class OrderOfElements {

    Random r = new Random();
    public void print(String text) {
        System.out.println(text);
        System.out.println(r.nextInt(10));
    }
    public OrderOfElements(){};
    private int num;


    public static void main(String[] args) {
        OrderOfElements o = new OrderOfElements();
        o.print("hello");
    }
}
