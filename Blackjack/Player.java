/* Qingfang Xue
 * Mr Kwok
 * ICS 4U1-02
 * 22 January 2025
 * This class represents a player in the Blackjack game. It manages the player's hand, calculates the total value of cards, tracks the number of Aces, adjusts the value of Ace and calculates points.
 */
package Blackjack;
import java.util.*;
public class Player {
    public ArrayList<Card> hand; // List of cards in the player's hand
    public int sum; // Total value of all cards in the player's hand
    private double points; // The player's current points in the game
    private int aceCount; // Counter for the number of Aces in the player's hand

    public Player() // Constructor
    {
        hand = new ArrayList<>();
        sum = 0;
        points = 2.0;
    }

    public void addCard(Card card) // Adds a card to the player's hand and updates the sum of card values
    {
        hand.add(card); 
        if (card.isAce()) // Check if the card is an Ace
            aceCount++;
        sum += card.getValue(); // Update the sum with the card's value
        reduceAce();
    }

    public void reduceAce() // Adjusts the value of Aces in the hand from 11 to 1 as needed to ensure the total hand value does not exceed 21
    {
        while (sum > 21 && aceCount > 0) 
        { 
            sum -= 10; // Adjust Ace from 11 to 1
            aceCount--; // Reduce the Ace count
        }
    }

    public void resetHand() // Resets the player's hand for a new round
    {
        hand.clear();
        sum = 0;
        aceCount = 0;
    }

    public int getSum() // Returns the sum
    {
        return sum;
    }

    public ArrayList<Card> getHand() // Returns the list of cards
    {
        return hand;
    }

    public double getPoints() // Returns the point
    {
        return points;
    }

    public void addPoints(double amount) // Add points to the player's total points.
    {
        points += amount;
    }

    public void deductPoints(double amount) // Deducts points to the player's total points.
    {
        points -= amount;
    }
}
