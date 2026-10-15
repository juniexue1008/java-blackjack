/* Qingfang Xue
 * Mr Kwok
 * ICS 4U1-02
 * 22 January 2025
 * This class represents a deck of cards for the Blackjack game. It includes methods to build, shuffle, and draw cards.
 */
package Blackjack;
import java.util.*;
public class Deck {
    private ArrayList<Card> deck; // The list of cards in the deck
    private Random r = new Random(); 

    public Deck() // Constructor
    {
        buildDeck();
        shuffleDeck();
    }

    public void buildDeck() // Method to build a standard deck of 52 playing cards
    {
        deck = new ArrayList<>(); // Initialize the deck as an empty list.
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // Card values
        String[] types = {"Clubs", "Diamonds", "Hearts", "Spades"}; // Card suits

        for (String type : types) // Loop through each suit
        {
            for (String value : values) // Loop through each value for the current suit
            {
                Card card = new Card(value, type);
                deck.add(card);
            }
        }
    }

    public void shuffleDeck() // Method to shuffle the deck randomly
    {
        for (int i = 0; i < deck.size(); i++) 
        {
            int j = r.nextInt(deck.size()); // Generate a random index within the deck
            Card temp = deck.get(i); // Temporarily store the current card
            deck.set(i, deck.get(j)); // Replace the current card with the card at the random index
            deck.set(j, temp); // Place the current card at the random index
        }
    }

    public Card drawCard() 
    {
        return deck.remove(deck.size() - 1); // Remove and return the last card in the deck
    }

    public void printDeck() 
    {
        System.out.println("Current Deck: " + deck); // Testing Method
    }
}
