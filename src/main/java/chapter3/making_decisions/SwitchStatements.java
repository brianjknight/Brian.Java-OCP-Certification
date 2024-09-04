package chapter3.making_decisions;

import java.time.DayOfWeek;

public class SwitchStatements {

	static final int eight = 8; 
	
	double computeTax2(double income, int taxBracket){
		return income * 
				switch(taxBracket){
					case 0 : yield 0.1; //observe the new keyword yield
					case 1 : { yield 0.2; } //enclosing the code within { } is optional
					default : yield 0.3;
				};
		}
	
    public static void main(String[] args) {
    	
    	// switch expressions means it returns value. CAN STILL use old syntax with ':' and yield
    	DayOfWeek day = DayOfWeek.FRIDAY;
    	String v = switch(day) {
    		case MONDAY : yield "sucks";
    		case WEDNESDAY : yield "humpday";
    		case FRIDAY:
    		case SATURDAY, SUNDAY : {yield "weekend";}
//    		case null: yield "null"; // preview feature switch with pattern matching only available version 20 and up
    		default: {yield "unkown";}
    	};
    	System.out.println(v);
    	System.out.println();
    	
//        long x = 1; type not allowed for switch parameter
        int x = 9;
        switch (x) {
            case 1,2:
                System.out.println("ONE");
            	String or = "o" + "r";
	            System.out.println(or + " two");
                break;
            case 9/3:
        	MONDAY: // exam trickery what may look like an enum case is actually a label here
                System.out.println("three");
                break;
            case 4: 
        	case 5: // equivalent to case 4,5:
                {
                	System.out.print("four ");
                }
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
//            default: // only ONE default allowed
//                System.out.println("no match");
            case 11:
                System.out.println("eleven");
//                return; // allowed but ends method; don't do this
            case 12:
                System.out.println("twelve");
//            case 13 -> System.out.println(""); // cannot mix old and new syntax
//            case 13:
//            	14:
//            	15:
        }
        
        switch (x) { // variables are within the same block of code and in scope but need to follow initialization rule
        	case 1:
        		int blockA = 1;
        		break;
        	case 2:
        		blockA=2;
        		break;
        	case 3:
        		break;
    		default:
//    			System.out.println(blockA); // might be uninitialized
    			break;
        }

        System.out.println();

        int y = 6;
        int six = 6;
        final var SIX = 6;
        boolean isSwitch = true;
        int num = 101;
        String result = switch (y) {
            case 1,2 -> result = "ONE or two"; 
//            	System.out.println("not allowed");
            case 3 -> {
                System.out.println("case 3 reached");
                yield "three";
            }
            case 4, 5 -> "four or five";
//            case six -> "six";
            case SIX -> "six"; // compile time known literal and final
            case 7 -> {
                // yield not needed for this case
                throw new IllegalArgumentException("we don't like sevens");
            }
//            case 8 -> 8;
            case SwitchStatements.eight -> { // constant
            	// will not compile if all branching within the case is not covered
                if (num < 0) {
                    yield "eight and negative num";
                } else if (num > 0) {
                    yield "eight and positive";
                }
                else {
                    yield "eight and zero";
                }
            }
//            case 8 -> break;

            default -> "invalid input";
        };
        System.out.println("switch expression result: " + result);

        // notice without assignment, you do not need to cover all cases or use yield for code block
        switch (2+4) {
            case SIX -> System.out.println("switch expression with no return does not need to cover all cases");
            case 8 -> {
            	// code block
            	System.out.println("eight");
            	break; // allowed when not assigning the switch expression result
            			// however switch expression only yields ONE case regardless of break;
            }
            case 9 -> System.out.println("nine");
            
            // cannot return/yield for switch expression value not assigned
//            case 9 -> "nine";
//            case 10 -> {yield "ten"}
            case 11 -> {
            	if (num > 0) {
            		System.out.println("postive number");
            	}
            }
        }

        // parameter/expression required for switch statement
//        switch() {
//            case 1 :
//                System.out.println("1");
//        }
        
        System.out.println();
        System.out.println("grades");
        final char a = 'A', e = 'E';
        final byte b = 120;
        Character grade = 'x';
        switch (grade) {
            default: System.out.println("\tdefault ");
            case a:
            case 'B': 
            	LABEL_NOTaCASE: System.out.println("\tgreat ");
            case 'D': System.out.println("\tgood "); break;
            case e:
            case 'F': System.out.println("not good ");
            case 10: // grade == 10 unboxes and casts grade to unicode value then compares primitive integral values
//            case 70_000: // out of range for 16 bit char unicode value
            case (short) 22:
            case b:
//            default: System.out.print(" default ");
        }
        System.out.println();
        System.out.println();
       

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
        System.out.println();
        
        
        // note execution first happens for a case match then continues, including default, until a break
        // no case match, starts executing at default branch then continues until a break
        System.out.println();
        System.out.println("number");
        byte number = 1;
        byte NUMBER = 5;
        switch (NUMBER) {
			case 1:
				System.out.println(1);
			case 2: 
				System.out.println(2);
//				return; // does compile
//				return 2; // does not compile
	
			default:
				System.out.println("default");
			case (byte)500: 
				System.out.println(3);
				
		}
        
        System.out.println();
        switch (number) {
        	case 1 -> System.out.println(1);
        	case 2 -> { // careful new syntax does not execute all cases 
        		System.out.println(2);
        		break;
        	}
        }
        
//        Integer dddd = 10;
        int dddd = 10;
        final byte bb = 1;
        final short ss = 2;
        final char cc = 'a';
        final var vv = 20;

        switch(dddd) { 
	        case (byte) 5: 
	        case (short) 22:
	        case 33:
	        case bb:  // Java will cast primitive values 
	        case ss:  // however remember it CANNOT autobox AND cast at the same time if switch param is a Wrapper
	        case cc:
	        case vv:
        }
        
        System.out.println();
        System.out.println("enthuware test question test 2 #31: ");
        int k = 10, s = 5;
        switch(k)
        {
           default :
        	   System.out.println("default case");
	           if( k == 10) {
	        	   System.out.println("if k==10");
	        	   s = s*2; 
        	   } else {
        		  System.out.println("else k!=10");
	              s = s+4;
	              break;
	           }
           case 7 : 
        	   System.out.println("case 7: ");
        	   s = s+3;
        }
        System.out.println("s = " + s);
    }
    
    String switchMethod(int i) {
    	
    	switch(i) {
    		case 1: return "ONE"; // not a void method so allowed to return
    		case 2: return "two";
    		case 3: System.out.println("three");
    		default: System.out.println("");
    	}
    	
    	String result = switch (i) {
    		case 2 -> "two";
    		default -> "NaN";
    	};
    	
    	switch(i) {
//    		case 3 -> "three";
    		case 3 -> System.out.println("three");
    		
    	}
    	
    	return "";
    }
}
