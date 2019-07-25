package com.company;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

/**Task:
 * Write a program that takes user input (integer) and checks if it is a Java keyword.
 * Will need Scanner (System.in), Test input val against array of keywords.
 */

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a keyword");
        String input = in.nextLine();

        String[] keywords = new String[]{
                "abstract",	"assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do",	"double", "else", "enum", "extends", "final", "finally", "float",
                "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public",	"return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        // Convert into List to access the contains() method for comparison.
        List<String> list = Arrays.asList(keywords);

        // Test values and output result
        if (list.contains(input)) {
            System.out.println(input.toUpperCase() + " is a Java keyword.");
        } else {
            System.out.println(input.toUpperCase() + " is not a Java keyword.");
        }

    }
}
