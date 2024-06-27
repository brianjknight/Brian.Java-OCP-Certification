package chapter3.making_decisions;

public class StatementAndBlocks {
    public static void main(String[] args) {
        int x = 5;
        while (true) {
            x--;
            if (x == 0) {
                System.out.println("x == 0 break");
            	break;
//                System.out.println("unreachable");
            }
            if (x == 4)
            	System.out.println("x == 4");
//            	System.out.println("indented but NOT part of if statement"); // code block {} is NOT used 
            else if (x == 3)
            	System.out.println("if x == 3");
            	System.out.println("not part of else if always prints ");

        }


//        while(false) {
//        	System.out.println("unreachable");
//        }
        
        System.out.println();
        if (false) {
        	System.out.println("dead code different from unreachable");
        }
        else
        	System.out.println("else statment");
    }
}
