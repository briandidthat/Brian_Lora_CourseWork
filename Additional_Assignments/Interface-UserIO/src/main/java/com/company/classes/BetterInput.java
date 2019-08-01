package com.company.classes;
import com.company.interfaces.UserIO;
import java.util.Scanner;

/*Task:
 *
 */

public class BetterInput implements UserIO {

    public String handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public int readInt(String prompt) {
        try {
            System.out.println(prompt);
            return Integer.parseInt(handleInput());
        } catch (Exception e) {
            System.out.println("incorrect Value, enter a valid integer.");
            return readInt(prompt);
        }
    }

    public long readLong(String prompt) {
        try {
            System.out.println(prompt);
            return Long.parseLong(handleInput());
        } catch (Exception e) {
            System.out.println("incorrect Value, enter a valid long.");
            return readLong(prompt);
        }
    }

    public double readDouble(String prompt) {
        try {
            System.out.println(prompt);
            return Double.parseDouble(handleInput());
        } catch (Exception e) {
            System.out.println("incorrect Value, enter a valid double.");
            return readLong(prompt);
        }
    }

    public float readFloat(String prompt) {
        try {
            System.out.println(prompt);
            return Float.parseFloat(handleInput());
        } catch (Exception e) {
            System.out.println("incorrect value, enter a valid float.");
            return readFloat(prompt);
        }
    }

    public String readString(String prompt) {
        try {
            System.out.println(prompt);
            return handleInput();
        } catch (Exception e) {
            System.out.println("incorrect value, enter a valid float.");
            return readString(prompt);
        }
    }
}
