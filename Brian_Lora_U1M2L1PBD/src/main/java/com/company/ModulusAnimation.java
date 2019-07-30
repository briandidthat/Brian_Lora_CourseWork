package com.company;

/*Task:
 * In this program, you'll use a loop to draw a simple ASCII-based animation on the screen,
 * and you will use modulus (%) to determine which frame of the animation to show.
 */

public class ModulusAnimation {

    public static void main(String[] args) throws Exception {
        for ( int i=0; i<80; i++ ) {
            if ( i%16 == 0 )
                System.out.print(" ********                 \r");
            else if ( i%16 == 1 )
                System.out.print("   ********               \r");
            else if ( i%16 == 2 )
                System.out.print("     ********             \r");
            else if ( i%16 == 3 )
                System.out.print("       ********           \r");
            else if ( i%16 == 4 )
                System.out.print("         ********         \r");
            else if ( i%16 == 5 )
                System.out.print("           ********       \r");
            else if ( i%16 == 6 )
                System.out.print("             ********     \r");
            else if ( i%16 == 7 )
                System.out.print("               ********   \r");
            else if ( i%16 == 8 )
                System.out.print("                 ******** \r");
            Thread.sleep(200);
        }
    }
}
