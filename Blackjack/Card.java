/* Qingfang Xue
 * Mr Kwok
 * ICS 4U1-02
 * 22 January 2025
 * This class represents a card in Blackjack. Each card has a value (e.g., "10") and a type (e.g., "Hearts"). It also includes methods to display the card, get its value for Blackjack, and check if it is an Ace.  
 */
package Blackjack;

public class Card {
    private String value, type; // Private variables for the card's value and type.

    Card(String a, String b) // Constructor
    {
        value = a;
        type = b;
    }

    public String toString() // Display the card, combining its value and type with a dash
    {
        return value + "-" + type;
    }

    public int getValue() // Calculates the numerical value of the card
    {
        if (value.equals("J") || value.equals("Q") ||  value.equals("K")) 
        {
            return 10; // If the value is "J", "Q", or "K", return 10
        }
        else if (value.equals("A")) 
        {
            return 11; // If the value is "A", return 11
        }
        else
        {
            return Integer.parseInt(value); // Otherwise, convert the value to an integer
        }
    }

    public boolean isAce() // Checks if the card is an Ace
    {
        return value.equals("A");
    }
}
