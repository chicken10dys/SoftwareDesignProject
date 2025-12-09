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
    // dealer varibale (signleton)
    private static Dealer onlyDealer;
    
    private Dealer(String name) {
        super(name);
    }
    
    // dealer get (signleton)
    public static Dealer getDealer() {
        if (onlyDealer == null)
            onlyDealer = new Dealer("Dealer");
        return onlyDealer;
    }

    @Override
    public void printState() {
        System.out.println("Dealer shows hand: " + getHand() + " (Score: " + hand.getScore() + ")");
    }

    public String dealerAIPlay() {
        /**
         * The dealer has a strict rule: Hit if score < 17. The Game class will
         * query this to decide if the dealer gets a card.
         */
        if (getHand().getScore() < 17) {
            return super.play("hit");
        } else {
            return super.play("stand");
        }

    }
}
