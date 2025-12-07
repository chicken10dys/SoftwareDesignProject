/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author doria
 */
public class BlackJackGame extends Game {

private Deck deck;
    private Dealer dealer;
    private Scanner scanner;

    public BlackJackGame(String name) {
        super(name);
        deck = new Deck();
        dealer = new Dealer("House");
        scanner = new Scanner(System.in);
        // 'players' is inherited from Game. We initialize it here if null, 
        // though Game constructor usually does it.
        if(getPlayers() == null) {
            setPlayers(new ArrayList<>());
        }
    }

    public void addPlayer(String name) {
        getPlayers().add(new BlackJackPlayer(name));
    }

    @Override
    public void play() {
        // 1. Initial Deal
        dealInitialRound();

        // 2. Human Players Turn
        for (Player p : getPlayers()) {
            // We must cast because the parent 'Player' doesn't know about Blackjack logic
            if (p instanceof BlackJackPlayer) {
                processPlayerTurn((BlackJackPlayer) p);
            }
        }

        // 3. Dealer Turn
        processDealerTurn();

        // 4. End Game
        declareWinner();
    }

    private void dealInitialRound() {
        System.out.println("--- Dealing Cards ---");
        // Deal 2 cards to everyone
        for (Player p : getPlayers()) {
            if (p instanceof BlackJackPlayer) {
                BlackJackPlayer bjp = (BlackJackPlayer) p;
                bjp.addCard(deck.deal());
                bjp.addCard(deck.deal());
            }
        }
        // Deal 2 cards to dealer
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());
    }

    private void processPlayerTurn(BlackJackPlayer player) {
        System.out.println("\n--- " + player.getName() + "'s Turn ---");
        
        while (player.getStatus() == Status.PLAYING) {
            player.play(); // Displays current score
            
            // Validate Input
            String[] choices = {"Hit", "Stand"};
            String input = InputValidation.readString(choices, "Please type 'Hit' or 'Stand'");

            if (input.equalsIgnoreCase("Hit")) {
                PlayingCard c = deck.deal();
                System.out.println(player.getName() + " draws: " + c);
                player.addCard(c); // This method inside Player checks for BUST automatically
                
                if (player.getStatus() == Status.BUST) {
                    System.out.println("BUST! Score: " + player.getHand().getScore());
                }
            } else {
                player.setStatus(Status.STAND);
                System.out.println(player.getName() + " Stands.");
            }
        }
    }

    private void processDealerTurn() {
        System.out.println("\n--- Dealer's Turn ---");
        dealer.play(); // Show initial hand
        
        while (dealer.wantsToHit()) {
            PlayingCard c = deck.deal();
            System.out.println("Dealer hits and gets: " + c);
            dealer.addCard(c);
        }

        if (dealer.getStatus() == Status.BUST) {
             System.out.println("Dealer BUSTS with " + dealer.getHand().getScore());
        } else {
             dealer.setStatus(Status.STAND);
             System.out.println("Dealer Stands with " + dealer.getHand().getScore());
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("\n--- FINAL RESULTS ---");
        int dealerScore = dealer.getHand().getScore();
        boolean dealerBusted = (dealer.getStatus() == Status.BUST);

        for (Player p : getPlayers()) {
            if (p instanceof BlackJackPlayer) {
                BlackJackPlayer bjp = (BlackJackPlayer) p;
                int playerScore = bjp.getHand().getScore();
                boolean playerBusted = (bjp.getStatus() == Status.BUST);

                System.out.print(bjp.getName() + ": ");

                if (playerBusted) {
                    System.out.println("Loss (Busted)");
                } else if (dealerBusted) {
                    System.out.println("WIN! (Dealer Busted)");
                } else if (playerScore > dealerScore) {
                    System.out.println("WIN! (" + playerScore + " vs " + dealerScore + ")");
                } else if (playerScore == dealerScore) {
                    System.out.println("PUSH (Tie)");
                } else {
                    System.out.println("Loss (" + playerScore + " vs " + dealerScore + ")");
                }
            }
        }
    }
}
