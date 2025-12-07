/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author doria
 */
public class BlackJackPlayer extends Player{
  private Hand hand;
  private Status status; 
  
    /**
     * A constructor that allows you to set the a card's rank and suit
     *
     */
public BlackJackPlayer(String name) {
        super(name);
        this.hand = new Hand();
        this.status = Status.PLAYING;
    }

    public Hand getHand() { return hand; }
    
    public Status getStatus() { return status; }
    
    public void setStatus(Status status) { this.status = status; }

    /**
     * Logic to add a card and check for bust immediately.
     * This keeps the internal state consistent.
     */
    public void addCard(PlayingCard c) {
        hand.addCard(c);
        if (hand.getScore() > 21) {
            this.status = Status.BUST;
        }
    }

    @Override
    public void play() {
        // This is the abstract method from the Parent class.
        // We can use it to display the player's current state.
        System.out.println(getName() + " current Hand: " + hand + " (Score: " + hand.getScore() + ")");
    }
    
    
}
