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
  protected Hand hand;
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

    public void printState() {
        // This is the abstract method from the Parent class.
        // We can use it to display the player's current state.
        System.out.println(getName() + " current Hand: " + hand + " (Score: " + hand.getScore() + ")");
    }
    
    @Override
    public String play(String action) {
        String actionResultMessage;
        
        if (action.equalsIgnoreCase("Hit")) {
            PlayingCard c = Deck.getDeck().deal();
            this.addCard(c); // This method inside Player checks for BUST automatically
            
            actionResultMessage = this.getName() + " draws: " + c;
            if (this.getStatus() == Status.BUST)
                actionResultMessage += System.lineSeparator() + "BUST! Score: " + this.getHand().getScore();
             
        } else if (action.equalsIgnoreCase("Stand"))  {
            this.setStatus(Status.STAND);
            actionResultMessage = this.getName() + " Stands.";
        } else {
            actionResultMessage = "Error!!! Unexpected action parameter value" +
                    "in BlackJackPlayer named " + this.getName();
        }
        
        return actionResultMessage;
    }
}
