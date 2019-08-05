package com.company;
import java.util.HashSet;
import java.util.Iterator;

/*Task:
 *
 */
public class SetIterator {
    public static void printSet(int ... nums) {
        HashSet<Integer> hashy = new HashSet<Integer>();
        // Loop over initial array of values and add them to HashSet
        for(int i : nums) {
            hashy.add(i);
        }

        // Declare and instantiate iterator
        Iterator<Integer> iterator = hashy.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
