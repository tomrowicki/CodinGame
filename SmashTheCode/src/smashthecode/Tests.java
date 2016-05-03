package smashthecode;

import java.util.Map;

public class Tests
{

    public static void main( String[] args )
    {
        String testString = "123456";
        getTopBlocks(testString);
    }
    
    static Map<String, Object> getTopBlocks(String row) {
        char[]blocks = row.toCharArray();
        for (char block : blocks) {
            System.out.println( block );
        }
        return null;
    }
}
