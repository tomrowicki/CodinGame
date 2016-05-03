package smashthecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Player
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int[] nextEightColors = new int[8];
            for (int i = 0; i < 8; i++) {
                int colorA = in.nextInt(); // color of the first block
                nextEightColors[i] = colorA;
                int colorB = in.nextInt(); // color of the attached block
            }
            List<Character> myTopBlocks = new ArrayList<Character>();
            for (int i = 0; i < 12; i++) {
                String row = in.next();
                myTopBlocks = getTopBlocks( row, myTopBlocks );
            }
            for (int i = 0; i < 12; i++) {
                String row = in.next(); // One line of the map ('.' = empty, '0' = skull block, '1' to '5' = colored block)
            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

//            System.out.println("0"); // "x": the column in which to drop your blocks
            System.out.println( decideAction(myTopBlocks, nextEightColors) );
        }
    }
    
    private static int decideAction( List<Character> myTopBlocks, int[] nextEightColors )
    {
        if (myTopBlocks.contains( new Character((char) nextEightColors[0]))) {
            return myTopBlocks.indexOf( nextEightColors[0] );
        } else {
            return myTopBlocks.indexOf( '.' );
        }
    }

    private static List<Character> getTopBlocks(String row, List<Character> topBlocks) {
        char[]blocks = row.toCharArray();
//        List<Character> charList = new ArrayList<Character>();
//        for(char block : blocks) {
//            charList.add(block);
//        }
        
        for (int i=0; i<blocks.length; i++) {
            if (topBlocks.get( i ) == null && blocks[i] != '.') {
                topBlocks.add( i, blocks[i] );
            }
        }
        return topBlocks;
    }
}