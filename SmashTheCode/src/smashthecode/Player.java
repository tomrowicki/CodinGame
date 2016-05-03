package smashthecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        // game loop
        while ( true )
        {
            int[] nextEightColors = new int[8];
            for ( int i = 0; i < 8; i++ )
            {
                int colorA = in.nextInt(); // color of the first block
                nextEightColors[i] = colorA;
                int colorB = in.nextInt(); // color of the attached block
            }
            List<Character> myTopBlocks = initializeEmptyBlockList();
            for ( int i = 0; i < 12; i++ )
            {
                String row = in.next();
                myTopBlocks = getTopBlocks( row, myTopBlocks );
            }
            for ( int i = 0; i < 12; i++ )
            {
                String row = in.next(); // One line of the map ('.' = empty, '0' = skull block, '1'
                                        // to '5' = colored block)
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // System.out.println("0"); // "x": the column in which to drop your blocks
            System.out.println( decideAction( myTopBlocks, nextEightColors ) );
        }
    }

    private static List<Character> initializeEmptyBlockList()
    {
        List<Character> emptyList = new ArrayList<Character>();
        for ( int i = 0; i < 5; i++ )
        {
            emptyList.add( null );
        }
        return emptyList;
    }

    private static int decideAction( List<Character> myTopBlocks, int[] nextEightColors )
    {
        char nextColor = Integer.toString( nextEightColors[0] ).charAt( 0 );
        char skull = Integer.toString( 0 ).charAt( 0 );
        System.err.println( "Next color: " + nextColor );
        if ( myTopBlocks.contains( nextColor ) )
        {
            System.err.println( "Returning block position." );
            return myTopBlocks.indexOf(nextColor);
        }
        else
        {
            System.err.println( "Returning empty position." );
            if (myTopBlocks.indexOf( null ) > -1) {
                return myTopBlocks.indexOf( null );
            } else {
                return myTopBlocks.indexOf( skull);
            }
        }
    }

    private static List<Character> getTopBlocks( String row, List<Character> topBlocks )
    {
        System.err.println( "Current row: " + row );
        char[] blocks = row.toCharArray();

        for ( int i = 0; i < blocks.length; i++ )
        {
            System.err.println( "Block in check: " + blocks[i] );
            if ( topBlocks.get( i ) == null && blocks[i] != '.' )
            {
                System.err.println( "Adding block to topList." );
                topBlocks.remove( i );
                topBlocks.add( i, blocks[i] );
            }
        }
        System.err.println( "Top blocks: " + topBlocks );
        return topBlocks;
    }
}