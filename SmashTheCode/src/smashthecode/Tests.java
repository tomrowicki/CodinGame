package smashthecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tests
{

    public static void main( String[] args )
    {
//        String testString = "123456";
//        getTopBlocks(testString);
        
//        List<Object> list = new ArrayList<Object>();
//        for (int i=0; i < 6; i++) {
//            list.add( null );
//        }
//        list.add( 3, "abc" );
//        System.out.println( list.toString() );
        
        compareChars();
    }
    
    private static Map<String, Object> getTopBlocks(String row) {
        char[]blocks = row.toCharArray();
        for (char block : blocks) {
            System.out.println( block );
        }
        return null;
    }
    
    private static void compareChars () {
        String str = "1abc";
        int integer = 1;
        char intChar = Integer.toString(integer).charAt(0);
        Character convertedInt = new Character((char) integer);
        List<Character> listOfChars = new ArrayList<Character>();
        
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            listOfChars.add( ch);
        }
        
        System.out.println( listOfChars.contains( intChar ) );
        System.out.println( listOfChars );
        System.out.println( intChar );
    }
}
