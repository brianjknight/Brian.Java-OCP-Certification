package chapter1.building_blocks;

public class TextBlock {

    /*sa d

    *  sdaf
      s              sdafd
        dssd
    *
    sdf///////**
    /**

             */

    String escape = "\"Java Study Guide\"\n\tby Scott & Jeane";

    String block = """
        "Java Study Guide"
            by Scott & Jeanne
            """;

    String quotes = "\"\"\"";

    String quotesBlock = """
            \"""
            """;

    public static void main(String args[]) {
        TextBlock t = new TextBlock();
        System.out.println(t.escape);
        System.out.println(t.block);
        System.out.println(t.quotes);
        System.out.println(t.quotesBlock);
        
        System.out.println("Brian".substring(1,1));
        System.out.println("Brian".substring(0,1));
    }
}
