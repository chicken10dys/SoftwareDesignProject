package ca.sheridancollege.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author doria
 */
public class Deck extends GroupOfCards{
    /**
     * Constructor: Creates a new 52-card deck.
     * It iterates through all Suits and Ranks to populate the deck.
     */
   public Deck(){
       super(52); //Initialize the parent class with a size of 52
  for (CardSuits s : CardSuits.values()) {
            for (CardRank r : CardRank.values()) {
                getCards().add(new PlayingCard(r, s));
            }
        }
        shuffle(); // Shuffle immediately upon creation
    }
   public PlayingCard deal() {
        if (getCards().isEmpty()) {
            return null; // Or throw exception
    
       }
        // Casting is necessary because GroupOfCards holds generic 'Card'
        return (PlayingCard) getCards().remove(0);
   }
}