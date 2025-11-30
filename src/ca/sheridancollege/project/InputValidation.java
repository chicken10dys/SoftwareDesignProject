/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author doria
 */
public class InputValidation {
   private static Scanner input = new Scanner(System.in);

    /**
     * Reads user input. If the input is not in the 'expected' array, 
     * it prints the errorMessage and asks again.
     * * @param expected An array of valid strings (e.g., {"Hit", "Stand"})
     * @param errorMessage The message to show on invalid input
     * @return The valid string the user eventually typed
     */
    public static String readString(String[] expected, String errorMessage) {
        while (true) {
            String userIn = input.nextLine();
            
            // Check if input matches any of the expected strings
            for (String s : expected) {
                if (userIn.equalsIgnoreCase(s)) {
                    return userIn; // Found a match, return it
                }
            }
            
            // If we get here, the input was invalid
            System.out.println(errorMessage);
        }
    } 
}
