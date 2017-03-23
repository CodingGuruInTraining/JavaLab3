package com.mark;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This program gathers sales information from the user, validates the input,
 * and calculates the total sales for the day.
 */
public class Problem_3 {

        //Create two scanners
        static Scanner stringScanner = new Scanner(System.in);
        static Scanner numberScanner = new Scanner(System.in);

        public static void main(String[] args) {
            // Displays message
            System.out.println("Coffee Shop Sales Calculator Program");
            // Creates accumulator variable and string array of drink names
            double totalSales = 0;
            String[] drinks = {"coffee", "hot chocolate", "tea", "cappuccino"};
            // Loops through array, retrieves data from function,
            // and adds amount to accumulator
            for (int i = 0; i < drinks.length; i++) {
                double drinkSales = gatherSalesInfo(drinks[i]);
                totalSales += drinkSales;
            }
            // Displays total sales amount.
            System.out.println(String.format("Total sales for the day are $%.2f.",
                    totalSales));
            //Close scanners.
            stringScanner.close();
            numberScanner.close();
        }

        public static double gatherSalesInfo(String drinkName) {
            // Asks user for number of drinks sold while validating input
            int cups = intValidation("How many cups of " + drinkName +
                    " did you sell today?");
            // Asks user for price per drink while validating input
            double price = doubleValidation("What does a cup of " +
                    drinkName + " cost?");
            // Calculates total sales of this drink
            double drinkSales = price * cups;
            return drinkSales;
        }

        public static double doubleValidation(String question) {
            // Validates user input
            // Loops until false
            while (true) {
                // Displays question to user if not empty string
                if (question != null) {
                System.out.println(question);
                }
                // Exception handler
                try {
                    return numberScanner.nextDouble();
                }
                // Catch for incorrect entry
                catch (InputMismatchException err) {
                    System.out.println("That is not a correct data type. Please" +
                            " enter a number.");
                    numberScanner.next();
                }
            }
        }
        public static int intValidation(String question) {
            // Validates user input
            // Loops until false
            while (true) {
                // Displays question to user if not empty string
                if (question != null) {
                    System.out.println(question);
                }
                // Exception handler
                try {
                    return numberScanner.nextInt();
                }
                // Catch for incorrect entry
                catch (InputMismatchException err) {
                    System.out.println("That is not a correct data type. Please" +
                            " enter an integer number.");
                    numberScanner.next();
                }
            }
        }
    }
