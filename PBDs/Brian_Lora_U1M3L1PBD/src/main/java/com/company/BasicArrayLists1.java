package com.company;

/*Task:
* Create an ArrayList that can hold Integers. Add ten copies of the number -113 to the ArrayList.
* Then display the contents of the ArrayList on the screen.This time, you must use a loop, both to fill up
* the ArrayList and to display it.Also, in the condition of your loop, you should not count up to a literal number.
* Instead you should use the size() of your ArrayList.
*/

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {
        List<Integer> tenInts = new ArrayList<Integer>();
        //Loop to add values to list
        for (int i =0; i < 10; i++) {
            tenInts.add(-113);
        }

        //Loop to print values of said list
        for (int i=0; i < tenInts.size(); i++) {
            System.out.println("Slot " + i +" contains a " +tenInts.get(i));
        }
    }
}
