/* Qingfang Xue
 * Mr Kwok
 * ICS 4U1-02
 * 22 January 2025
 * The Game class manages the main game logic for Blackjack, managing the player, dealer, deck, and rounds. It handles card drawing, scoring, and deciding winners while letting the player choose to play again or quit.
 */
package Blackjack;
import java.util.*;
public class Game {
    private Deck deck; // The deck of cards used in the game
    private Player player; // Represents the user
    private Player dealer; // Represents the computer
    private Scanner s;
    private boolean flag = true;

    public Game() // Constructor
    {
        deck = new Deck();
        player = new Player();
        dealer = new Player();
        s = new Scanner(System.in);
    }

    public void startGame() 
    {
        System.out.println("\nWelcome to Blackjack! You and the dealer both have 2 points at the beginning of the game.");
        while (true) // Loops until the user choose to quit
        {
            player.resetHand(); // Resets the player's hand at the start of each round
            dealer.resetHand(); // Resets the dealer's hand at the start of each round
            deck = new Deck(); // Create new deck for each round
            // deck.printDeck(); // Testing 
            flag = true;
            // Dealer draws the initial two cards
            Card hiddenCard = deck.drawCard();
            dealer.addCard(hiddenCard); // Hidden card for the dealer
            dealer.addCard(deck.drawCard());
            // Player draws their initial two cards
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());

            checkInitialBlackjack(); // Checks if the player has a blackjack with initial cards
            if (flag) // If no initial blackjack, proceed with the game
            {
                playGame(hiddenCard);
            }
            
            System.out.print("\nDo you want to play another round? (Yes/No): ");
            String choice = s.nextLine();
            if (!choice.equalsIgnoreCase("yes")) // Prompt the player to decide whether to play another round
            {
                System.out.println("Thank you for playing! See you next time!");
                break;
            }
        }
    }
    // Method checks for initial blackjack
    public void checkInitialBlackjack() 
    {
        if (player.getSum() == 21 && dealer.getSum() != 21) // If player has blackjack but dealer does not
        {
            System.out.println("Your hand: " + player.hand + " (Total: " + player.getSum() + ")");
            System.out.println("Blackjack! You win 1.5 points from the dealer.");
            player.addPoints(1.5); // Adds 1.5 points to the player's score
            dealer.deductPoints(1.5); // Deducts 1.5 points from the dealer's score
            flag = false;
        }
    }
    // Main gameplay logic for the player's turn
    public void playGame(Card hiddenCard) 
    {
        while (true) // Loop until the player decides to stay or busts
        {
            System.out.println("Your hand: " + player.hand + " (Total: " + player.getSum() + ")");
            System.out.println("Dealer's visible card: " + dealer.hand.get(1)); // Shows dealer's visible card

            if (player.getSum() > 21) // Player busts if their sum exceeds 21
            {
                System.out.println("You busted! Dealer gains 1 point from you.");
                dealer.addPoints(1);
                player.deductPoints(1);
                System.out.println("Your points: " + player.getPoints());
                System.out.println("Dealer's points: " + dealer.getPoints());
                return; // Ends the round
            }

            if (player.getSum() == 21) // If player reaches 21 after hitting cards
            {
                System.out.println("You reached 21!");
                break; // Ends the loop, moving to the dealer's turn
            }
            // Prompt the player to hit (draw a card) or stay (end their turn)
            System.out.print("Do you want to hit or stay? (hit/stay): ");
            String choice = s.nextLine();
    
            if (choice.equalsIgnoreCase("hit")) 
            {
                Card card1 = deck.drawCard();
                player.addCard(card1); // Adds the drawn card to the player's hand
                System.out.println("You draw: " + card1);
            }   
            else if (choice.equalsIgnoreCase("stay")) 
                break; // Ends the loop, moving to the dealer's turn
            else
                System.out.println("Invalid choice. Please type 'hit' or 'stay'.");
        }
        dealerTurn(hiddenCard); // Proceeds to the dealer's turn
    }
    // Main gameplay logic for the dealer's turn
    public void dealerTurn(Card hiddenCard) 
    {
        System.out.println("\nDealer's hand: " + dealer.hand + " (Total: " + dealer.getSum() + ")");

        while (dealer.getSum() < 17) // Dealer draws cards until their sum is at least 17
        {
            Card card2 = deck.drawCard();
            dealer.addCard(card2); // Adds the drawn card to the dealer's hand
            System.out.println("Dealer draws: " + card2);
        }

        System.out.println("Dealer's final hand: " + dealer.hand + " (Total: " + dealer.getSum() + ")");
        determineWinner(); // Determines the winner of the round
    }

    public void determineWinner() 
    {
        if (dealer.getSum() > 21) // If dealer busts
        {
            System.out.println("Dealer busted! You gain 2 points from the dealer.");
            player.addPoints(2); // Player gains 2 points
            dealer.deductPoints(2); // Dealer loses 2 points
        } 
        else if (player.getSum() > dealer.getSum()) // If player's total is higher
        {
            System.out.println("You win! You gain 1 point from the dealer.");
            player.addPoints(1);
            dealer.deductPoints(1);
        } 
        else if (player.getSum() == dealer.getSum()) // If player's total equals to dealer's total
        {
            System.out.println("It's a tie!");
        } 
        else if (dealer.getSum() > player.getSum()) // If dealer's total is higher
        {
            System.out.println("Dealer wins! Dealer gains 1 point from you.");
            dealer.addPoints(1);
            player.deductPoints(1);
        }
        // Prints the updated scores
        System.out.println("Your points: " + player.getPoints());
        System.out.println("Dealer's points: " + dealer.getPoints());
    }
}
