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
    public int getScore() {
        int score = 0;
        int aces = 0;
        for (PlayingCard c : cards) {
            switch (c.getRank()) {
                case ACE: aces++; break;
                case JACK: case QUEEN: case KING: score += 10; break;
                default: score += c.getRank().ordinal() + 1; break;
            }
        }
        // Logic for aces (1 or 11) would go here
        return score;
    }
       /**
     * Returns the string representation of the cards in the hand.
     * @return A list of cards (e.g., "[ACE of SPADES, TEN of HEARTS]")
     */
    @Override
    public String toString() { return cards.toString(); }
}
