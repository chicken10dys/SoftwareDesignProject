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
public class Main {
   public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
        BlackJackGame game = new BlackJackGame("House Group Blackjack");

        System.out.println("Welcome to " + game.getName());

        //Ask for the number of players
        int playerCount = 0;
        while (true) {
            System.out.print("How many players are playing today? ");
            try {
                playerCount = Integer.parseInt(input.nextLine());
                if (playerCount > 0 && playerCount <= 7) { // Limit to 7 to prevent deck running out
                    break;
                }
                System.out.println("Please enter a number between 1 and 7.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        //Loop to get names for each player
        for (int i = 1; i <= playerCount; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = input.nextLine();
            
            //If user presses enter without typing, give a default name
            if (name.trim().isEmpty()) {
                name = "Player " + i;
            }
            
            game.addPlayer(name);
        }

        //Start the game
        System.out.println("\nStarting game with " + playerCount + " players...");
        game.play();
        
        input.close();
    }
}
