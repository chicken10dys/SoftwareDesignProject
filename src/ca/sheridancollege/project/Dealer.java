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
    
public Dealer(String name) {
        super(name);
    }

    /**
     * The dealer has a strict rule: Hit if score < 17.
     * The Game class will query this to decide if the dealer gets a card.
     */
    public boolean wantsToHit() {
        return getHand().getScore() < 17;
    }

    @Override
    public void play() {
        System.out.println("Dealer shows hand: " + getHand());
    }
}
