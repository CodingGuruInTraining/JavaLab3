package com.mark;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This program calculates how many weeks one would need to improve their
 * running to meet their goal.
 */
public class Problem_1_marat {
    // Creates Scanner object
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Asks user for two inputs to calculate schedule
        System.out.println("What percentage would you like to increase each week?");
        double percentage = numberScanner.nextDouble();
        System.out.println("How many miles is the race you're training for?");
        double miles = numberScanner.nextDouble();

        // Creates separate lists of calculation results so they can be
        // displayed side by side
        List<Double> inputData = calc_weeks_till_marathon(percentage, miles);
        List<Double> oneData = calc_weeks_till_marathon(1, miles);
        List<Double> fiveData = calc_weeks_till_marathon(5, miles);
        List<Double> tenData = calc_weeks_till_marathon(10, miles);

        // Makes array of List lengths and sorts them. These were originally
        // for an inner loop attempt, but they are currently benched.
        int[] countArray = {inputData.size(), oneData.size(), fiveData.size(), tenData.size()};
        Arrays.sort(countArray);

        // Determines which List has the most lines to display
        int maxCount = Math.max(inputData.size(), Math.max(oneData.size(), Math.max(fiveData.size(), tenData.size())));

        // Presents some starting structure to results
        System.out.println("Below is what your schedule could look like:\n");
        System.out.println(String.format("Week #     %.0fperc        1perc        5perc        10perc", percentage));

        // Loops through the largest List length to include all results
        for (int i = 0; i < (maxCount - 1); i++) {
            //First displays the week number
            System.out.print(String.format("Week %-1d || ", i + 1));

            // Checks if the input List from the User still has items to display (less items than max)
            if (inputData.size() > i) {
                System.out.print(String.format("%-1.2f miles", inputData.get(i)));
            }
            // Prints a blank line if the last item has already been printed.
            // The line is the same length as the last printed item.
            else {
                int stringSize = (String.format("%-1.2f miles", inputData.get(inputData.size() - 1))).length();
                System.out.print(new String(new char[stringSize]).replace("\0"," "));
            }
            // Prints the base Lists on the same line if there are still items to print.
            printTableLine(oneData, i);
            printTableLine(fiveData, i);
            printTableLine(tenData, i);
            // Wraps data to next line for new week
            System.out.print("\n");
        }
        // Closes Scanner object
        numberScanner.close();
    }

    public static List<Double> calc_weeks_till_marathon(double percentage, double miles) {
        // Creates new List
        double current_miles = 1.0;
        List<Double> dataList = new ArrayList<>();

        // Adds current miles number to List and then calculates next week's number
        do {
            dataList.add(current_miles);
            current_miles = current_miles * (1 + (percentage / 100));
        }
        while (current_miles < miles);
        // Returns completed List
        return dataList;
    }

    public static void printTableLine(List<Double> myList, int iteration) {
        // Checks if List still has items to print. Since the Lists are printed largest to smallest count,
        // the output should be a cascade, which shouldn't require adding blank lines
        if ((myList.size() - 1) > iteration) {
            System.out.print(String.format(" | %-1.2f miles", myList.get(iteration)));
        }
    }
}

//Learned some new tricks from these sites:
//http://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
//http://stackoverflow.com/questions/8938235/java-sort-an-array
//http://stackoverflow.com/questions/2843366/how-to-add-new-elements-to-an-array
//http://stackoverflow.com/questions/4982210/find-the-max-of-3-numbers-in-java-with-different-data-types