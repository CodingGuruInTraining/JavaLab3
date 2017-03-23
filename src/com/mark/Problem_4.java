package com.mark;
import java.util.Scanner;
/**
 * This program retrieves a string of numbers from the user and
 * converts that string into an array of integers.
 */
public class Problem_4 {
    // Creates Scanner object
    static Scanner stringScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Prompts user to enter a string of numbers
        System.out.println("Please enter a string of numbers with " +
                "no separaters:");
        String nums = stringScanner.nextLine();
        // Runs conversion function and receives int array
        int[] convertedNumbers = convertToIntArray(nums);
        // Loops through array and displays its items
        for (int i = 0; i < convertedNumbers.length; i++) {
            System.out.println(convertedNumbers[i]);
        }
        // Closes Scanner object
        stringScanner.close();
    }

    public static int[] convertToIntArray(String numbers) {
        // Splits the provided string into individual array items
        String[] strArr = numbers.split("");
        // Creates int array the same size as the split string
        // array
        int[] intArray = new int[strArr.length];
        // Exception handler
        try {
            // Loops through string array and attempts to
            // convert its content to integers and fill the
            // int array with them
            for (int i = 0; i < strArr.length; i++) {
                intArray[i] = Integer.parseInt(strArr[i]);
            }

        }
        // Catch for failed conversion attempt
        catch (NumberFormatException err) {
            System.out.println("Cannot compute.");
        }
        // Returns array
        return intArray;
    }
}
//some help from:
//http://stackoverflow.com/questions/7646392/convert-string-to-int-array-in-java