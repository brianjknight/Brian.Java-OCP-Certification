package chapter3.making_decisions;

public class SwitchStatements {

    public static void main(String[] args) {
        int x = 9;
        switch (x) {
            case 1,2:
                System.out.println("one or two");
                break;
            case 9/3:
                System.out.println("three");
                break;
            case 4: case 5:
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

        System.out.println("$".repeat(100));

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

        final char a = 'A', e = 'E';
        char grade = 'B';
        switch (grade) {
            default:
            case a:
            case 'B': System.out.print("great ");
            case 'D': System.out.print("good "); break;
            case e:
            case 'F': System.out.print("not good ");
        }
    }
}
