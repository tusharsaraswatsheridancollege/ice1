/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * Modified By:- Tushar Saraswat
 * Student Number:- 991718063
 * Date:- 30-01-2024
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        
        // Add a hardcoded lucky card (2 of clubs)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit(Card.SUITS[3]);
        magicHand[0] = luckyCard; // Add the lucky card to the magicHand array

        for (int i = 1; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        // Ask the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick a card (enter card value Ace = 1, 2-10, Jack -11, Queen =12, King = 13): ");
        int userCardValue = scanner.nextInt();

        System.out.print("Pick a suit (enter suit name - Hearts, Diamonds, Spades, Clubs): ");
        String userCardSuit = scanner.next();

        // Convert suit name to suit index using a switch statement
        int userCardSuitIndex;
        switch (userCardSuit.toLowerCase()) {
            case "hearts":
                userCardSuitIndex = 0;
                break;
            case "diamonds":
                userCardSuitIndex = 1;
                break;
            case "spades":
                userCardSuitIndex = 2;
                break;
            case "clubs":
                userCardSuitIndex = 3;
                break;
            default:
                System.out.println("Invalid suit name.");
                return;
        }

        // Search for the user's card and report the result
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCardValue && card.getSuit().equals(Card.SUITS[userCardSuitIndex])) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    // Helper method to generate a random value for the cards (between 1 and 13)
    private static int generateRandomValue() {
        return new Random().nextInt(13) + 1;
    }

    // Helper method to generate a random number within a range
    private static int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
