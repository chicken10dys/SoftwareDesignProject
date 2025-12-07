/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 *
 * @author doria
 */
public class Hand {
    // A list to hold the specific PlayingCard objects in this hand
    private ArrayList<PlayingCard> cards = new ArrayList<>();
    /**
     * Adds a card to the hand.
     * @param c The PlayingCard to be added.
     */
    public void addCard(PlayingCard c) { cards.add(c); }
    /**
     * Calculates the score of the hand.
     * Number cards are worth their face value.
     * Face cards (J, Q, K) are worth 10.
     * Aces are worth 1 or 11, whichever benefits the player most.
     * * @return The total integer score of the hand.
     */
    
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

public int getScore() {
        int score = 0;
        int aceCount = 0;

        for (PlayingCard c : cards) {
            CardRank rank = c.getRank();
            if (rank == CardRank.ACE) {
                aceCount++;
                // We assume Ace is 11 initially
                score += 11; 
            } else if (rank == CardRank.JACK || rank == CardRank.QUEEN || rank == CardRank.KING) {
                score += 10;
            } else {
                // In your enum, ACE is 0, TWO is 1. So TWO's value is ordinal + 1 = 2.
                score += rank.ordinal() + 1;
            }
        }

        // If we busted, downgrade Aces from 11 to 1 until we are safe
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }

        return score;
    }
       /**
     * Returns the string representation of the cards in the hand.
     * @return A list of cards (e.g., "[ACE of SPADES, TEN of HEARTS]")
     */
    @Override
    public String toString() { return cards.toString(); }
}
