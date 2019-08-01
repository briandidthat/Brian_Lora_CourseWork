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
        System.out.println(prompt);
        return Integer.parseInt(handleInput());
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(handleInput());
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(handleInput());
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(handleInput());
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return handleInput();
    }
}
