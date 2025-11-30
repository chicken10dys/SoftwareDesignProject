/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author doria
 */
public class PlayingCard extends Card{
    private CardRank rank; //rank of the card
    private CardSuits suit; //suit of the card
    
  /**
     * A constructor that allows you to set the a card's rank and suit
     *
     */
    public PlayingCard(CardRank rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
    }
      /**
     * @return the card rank
     */
    public CardRank getRank() { return rank; }
      /**
     * @return the card suit
     */
    public CardSuits getSuit() { return suit; }
        /**
     * Overriding the original toString method from the Card class
     *
     * @return a String representation of the rank and suit of the card.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
