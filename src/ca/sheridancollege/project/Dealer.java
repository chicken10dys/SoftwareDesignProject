/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author doria
 */
public class Dealer extends BlackJackPlayer {
  public Dealer(String name){
        super(name);
    }
/**
     * The Dealer's AI logic. 
     * The dealer hits until it has 17 or higher.
     */
    public void playTurn(Deck deck) {
        System.out.println(getName() + " is taking their turn...");
        
        // Loop while score is under 17
        while (getHand().getScore() < 17) {
            System.out.println("Dealer score is " + getHand().getScore() + ". Dealer Hits.");
            PlayingCard c = deck.deal();
            getHand().addCard(c);
            System.out.println("Dealer drew: " + c);
        }
        
        System.out.println("Dealer finishes with score: " + getHand().getScore());
        if (getHand().getScore() > 21) {
            System.out.println("Dealer Busts!");
        } else {
            System.out.println("Dealer Stands.");
        }
    }  
}
