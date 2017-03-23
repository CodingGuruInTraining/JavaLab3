package com.mark;
import java.util.Scanner;
// This program asks the user for two values and
// calculates the MPG using those values.
public class Problem_1_mpg {
    // Creates Scanner object
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Asks user for miles and stores input
        System.out.println("How many miles have you driven?");
        double miles_driven = numberScanner.nextDouble();
        // Asks user for gallons and stores input
        System.out.println("How many gallons of gas were used on this journey?");
        double gallons_used = numberScanner.nextDouble();
        // Calls calculation method and stores returned result
        double mpg = calcMPG(miles_driven, gallons_used);
        // Displays result in formatted string
        System.out.println(String.format("Your MPG is %.2f.", mpg));
        // Clears up memory
        numberScanner.close();
    }

    public static double calcMPG(double miles, double gas) {
        // Method calculates MPG with given parameters and
        // returns result.
        double mpg = miles / gas;
        return mpg;
    }
}