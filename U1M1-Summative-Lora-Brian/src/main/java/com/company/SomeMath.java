package com.company;

/**Task: SomeMath
 * Create a method called total5.  This method must take 5 int parameters and return the total. You must call
 * the method with the following parameters and print the returned total to the screen: 1, 2, 3, 4, 5.
 * Create a method called average5. This method must take 5 int parameters and return the average of the numbers
 * as a double. You must call the method with the following parameters and print the returned average to the
 * screen: 1, 3, 5, 7, 9.
 * Create a method called largest5. This method must take 5 double parameters and return the largest. You must call
 * the method with the following parameters and print the returned value to the screen: 42.0, 35.1, 2.3, 40.2, 15.6.
 */

public class SomeMath {

    public static int totalFive(int ...nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        return total;
    }

    public static double averageFive(int ... nums) {
         double sum = 0;
         double avg;

         for (int i : nums) {
            sum += i;
         }
         avg = sum / 5;
         return avg;
    }

    public static double largestFive(double ... nums) {
         double max = nums[0];

         for(int i = 1; i < nums.length; i++) {
             if(nums[i] > max) {
                 max = nums[i];
             }
         }

         return max;
    }

    public static void main(String[] args) {
        System.out.println("The sum is: "+ totalFive(1,2,3,4,5) + ".");
        System.out.println("The average is: " + averageFive(1,3,5,7,9) + ".");
        System.out.println("The average is: " + largestFive(42.0, 35.1, 2.3, 40.2, 15.6) + ".");
    }
}
