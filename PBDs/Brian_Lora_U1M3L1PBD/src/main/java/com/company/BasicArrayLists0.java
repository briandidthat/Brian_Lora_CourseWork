package com.company;

import java.util.ArrayList;
import java.util.List;

/*Task:
* Create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList.
* Then display the contents of the ArrayList on the screen. Do not use a loop. Also, do not use any variable
* for the index; you must use literal numbers to refer to each slot.
 */
public class BasicArrayLists0 {

    public static void main(String[] args) {
        List<Integer> tenInts = new ArrayList<Integer>();
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);
        tenInts.add(-113);

        System.out.println("Slot 0 contains a " + tenInts.get(0));
        System.out.println("Slot 1 contains a " + tenInts.get(1));
        System.out.println("Slot 2 contains a " + tenInts.get(2));
        System.out.println("Slot 3 contains a " + tenInts.get(3));
        System.out.println("Slot 4 contains a " + tenInts.get(4));
        System.out.println("Slot 5 contains a " + tenInts.get(5));
        System.out.println("Slot 6 contains a " + tenInts.get(6));
        System.out.println("Slot 7 contains a " + tenInts.get(7));
        System.out.println("Slot 8 contains a " + tenInts.get(8));
        System.out.println("Slot 9 contains a " + tenInts.get(9));

    }
}
