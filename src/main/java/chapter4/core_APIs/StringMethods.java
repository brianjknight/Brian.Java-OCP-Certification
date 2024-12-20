package chapter4.core_APIs;

public class StringMethods {

    public static void main(String[] args) {
        String nnn = null;
    	System.out.println("NULL: " + nnn);
    	
    	String animal = "elephants";

        int pChar = animal.indexOf('p');
        int pInt= animal.indexOf(112); // 112 is the ascii int value for p
        System.out.println("pChar index: " + pChar);
        System.out.println("pInt index: " + pInt);

//        System.out.println(animal.startsWith('a')); // invalid parameter
        System.out.println(animal.startsWith("e"));
        System.out.println(animal.contains("ant"));
        
        
        // substring index
        System.out.println(animal.substring(0,3));
        // IndexOutOfBoundsException -> RuntimeException
//        System.out.println(animal.substring(10));
        System.out.println(animal.substring(animal.indexOf("a")));
        System.out.println(animal.substring(animal.indexOf('a'),9));


        // formatting runtime error when mixing data types float with integer %d
//        System.out.println("float %d".formatted(10.123456));

        double n = 1.12345678; // default is 6 decimal places
        System.out.println(String.format("format number to decimals %f", n).toString());
        System.out.println(String.format("format number to decimals %.2f", n));
        System.out.println(String.format("format number to decimals %1.2f", n));
        System.out.println(String.format("format number to decimals %12.4f", n));
        System.out.println(String.format("format number to decimals %08.4f", n));
        
        
        // String pool
        var a = "Hello World";
        var b = "Hello World"; // literal
        var b2 = "Hello" + " World"; //compile time constant
        var world = " World";
        final var worldFinal = " World"; // compile time constant with final
        var b3 = "Hello" + world;
        var b4 = "Hello" + worldFinal;
        var c = new String("Hello World");
        var d = "Hello World".strip();  // first creates string which is already in pool, then calls strip
        var e = " Hello World\n".strip(); // with space and return is NOT in String pool yet
        var f = new String("Hello World").intern();
        var g = "Hello".concat(" World");
        var h = "Hello World".concat("");
        var i = "Hello World".concat("!!!");
        var j = a.substring(0,11);
        
        System.out.println();
        System.out.println("###String pool###");
        System.out.println("-----");
        System.out.println("a==b: " + a == b); //order of operations binary before equality "a==b: Hello World" == b
        System.out.println("a==b: " + (a==b));
        System.out.println("a==b2: " + (a==b2));
        System.out.println("a==b3: " + (a==b3));
        System.out.println("a.equals(b3): " + a.equals(b3)); // overridden method compares characters in the object
        System.out.println("a==b4: " + (a==b4));
        System.out.println("a==c: " + (a==c));
        System.out.println("a==d: " + (a==d));
        System.out.println("a==e: " + (a==e));
        System.out.println("a==f: " + (a==f));
        System.out.println("a==g: " + (a==g));
        System.out.println("a==h: " + (a==h));
        System.out.println("a==i: " + (a==i));
        System.out.println("a==j: " + (a==j));
        System.out.println();
        
        // 3 spaces after 'a' but text block drops the spaces and adds return '\n'
        var block = """
        		a   
        		 b
        		c""";
        
        System.out.println("block.length(): " + block.length());
        System.out.println(block);
        
        // 3 spaces after a
        var concat = " a   \n" + // trailing incidental whitespace gets stripped BUT NOT the return \n
                     "   b\n" + 
        		     " c";
        System.out.println("concat.length(): " + concat.length());
        System.out.println(concat);
        System.out.println("stripIndent length: " + concat.stripIndent().length());
        System.out.println(concat.stripIndent());
        System.out.println();
        
        String s2 = "";
        s2 += 2; // s2 = s2 + 2;
        s2 += 'c'; // s2 = s2 + 'c';
        s2 += false; // s2 = s2 + false;
        if ( s2 == "2cfalse") System.out.println("==");
        if ( s2.equals("2cfalse")) System.out.println("equals");
        
        String s1 = """
        		purr""";
        System.out.println(s1.length());
        
//        String s1B = s1.replaceAll('p', "P");
        
        System.out.println("1\\t2.length() = " + "1\\t2".length());
        System.out.println("1\\\\t2.translateEscapes() = " + "1\\t2".translateEscapes());
        
        System.out.println();
        testMethod();
        
        System.out.println();
        textBlock();
        
        System.out.println();
        String newBlock = """
        		\""" "\"" ""
        		""";
        System.out.println(newBlock);
       }
  

    static void testMethod() {
    	System.out.println("OCP 17/21 page 255 ex #3");
    	String s = "a";
    	String[] sa = { "a", s, s.substring(0, 1), new String("a"), ""+'a' };
    	for(int i=0; i<sa.length; i++){
	    	System.out.println(i);
	    	System.out.println(s == sa[i]);
	    	System.out.println(s.equals(sa[i]));
    	}
    }
    
    static void textBlock() {
    	String commonHeader =
    			"<head/>\n" +
    			"<meta charset=\"utf-8\" />\n" +
    			"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
    			"</head>";
    	
    	String sameHeader =
    			"""
    			<head/>
    			<meta charset="utf-8" />
    			<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
    			</head>
    			""";
    			
    	System.out.println(commonHeader);
    	System.out.println(sameHeader);
    	System.out.println(commonHeader.equals(sameHeader));  //escapes needed in concatenation
    }

}
