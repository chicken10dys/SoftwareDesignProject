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
  private int status; // 0=Playing, 1=Bust, 2=Stand
  
    /**
     * A constructor that allows you to set the a card's rank and suit
     *
     */
  public BlackJackPlayer(String name) {
        super(name);
        hand = new Hand();
        this.status =0;
    }
  public Hand getHand() { 
        return hand; 
    }

    public void setHand(Hand hand) { 
        this.hand = hand; 
    }

    public int getStatus() { 
        return status; 
    }

    public void setStatus(int status) { 
        this.status = status; 
    }
    /**
     * The UML defines this as hit(): void. 
     * However, to make the code work, we must pass the deck 
     * so we can actually draw a card.
     */
    public void hit(Deck deck) {
        System.out.println(getName() + " hits.");
        PlayingCard c = deck.deal();
        hand.addCard(c);
        
        // Check for bust
        if (hand.getScore() > 21) {
            this.status = 1; // 1 represents Bust
        }
    }

    public void stand() {
        System.out.println(getName() + " stands.");
        this.status = 2; // 2 represents Stand
    }

    public void withdraw() {
        System.out.println(getName() + " withdraws from the game.");
        // Logic to remove player from game would happen in Game class
        this.status = -1; // -1 represents Quit
    }

    @Override
    public void play() {
        // This is the abstract method from the Parent class.
        // We can use it to display the player's current state.
        System.out.println(getName() + " is playing. Current Score: " + hand.getScore());
    }
    
    
}
