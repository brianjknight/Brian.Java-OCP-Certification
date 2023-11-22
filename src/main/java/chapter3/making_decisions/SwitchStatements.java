package chapter3.making_decisions;

public class SwitchStatements {

    public static void main(String[] args) {
//        long x = 1; type not allowed for switch parameter
        int x = 9;
        switch (x) {
            case 1,2:
                System.out.println("one or two");
                break;
            case 9/3:
                System.out.println("three");
                break;
            case 4: case 5: // equivalent to case 4,5:
                System.out.print("four ");
                System.out.println("or five");
                break;

            case 2*3: System.out.println("six"); break;
            // default branch can go anywhere
            default:
                System.out.println("no match");

            case 7: break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
            case 10:
                System.out.println("ten");
            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
        }

        System.out.println("$".repeat(20));

        int y = 6;
        int six = 6;
        final int SIX = 6;
        boolean isSwitch = true;
        int num = 101;
        String result = switch (y) {
            case 1,2 -> result = "one or two";
            case 3 -> {
                System.out.println("case 3 reached");
                yield "three";
            }
            case 4, 5 -> "four or five";
//            case six -> "six";
            case SIX -> "six";
            case 7 -> {
                // yield not needed for this case
                throw new IllegalArgumentException("we don't like sevens");
            }
//            case 8 -> 8;
            case 8 -> {
                if (num < 0) {
                    yield "eight and negative num";
                } else if (num > 0) {
                    yield "eight and positive";
                }
                else {
                    yield "eight and zero";
                }
            }


            default -> "invalid input";
        };
        System.out.println("switch expression result: " + result);

        switch (2+3) {
            case SIX -> System.out.println("switch expression with no return does not need to cover all cases");
        }

        // parameter/expression required for switch statement
//        switch() {
//            case 1 :
//                System.out.println("1");
//        }

        System.out.println("###############");
        System.out.println("grades");
        final char a = 'A', e = 'E';
        char grade = 'F';
        switch (grade) {
            default: System.out.print(" default ");
            case a:
            case 'B': System.out.print("great ");
            case 'D': System.out.print("good "); break;
            case e:
            case 'F': System.out.print("not good ");
        }
        System.out.println("");
        System.out.println("###############");
       

        String empty = "";
        switch(empty) {

        }

        String blank = "";
        int zero = switch(blank) {
            default -> 0;
        };

        char Q = 'z';
        var queue = switch (Q) {
            case 'Q' -> {
                yield "QQQ";
            }
            case 'z' -> {
                yield "zzz";
            }

            default -> "default";
        };
        System.out.println("queue = " + queue);
        
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        
        
        // not execution first happens for a case match then continues, including default, until a break
        // no case match, starts executing at default branch then continues until a break
        byte number = 1;
        byte NUMBER = 5;
        switch (number) {
			case 1:
				System.out.println(1);
			case 2: 
				System.out.println(2);
	
			default:
				System.out.println("default");
			case (byte)500: 
				System.out.println(3);
				
		}
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        switch (number) {
        	case 1 -> System.out.println(1);
        	case 2 -> {
        		System.out.println(2);
        		break;
        	}
        }
    }
}
