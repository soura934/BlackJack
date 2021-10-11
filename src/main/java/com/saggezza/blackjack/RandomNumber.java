package com.saggezza.blackjack;

public class RandomNumber {
        public static void main (String args[]) {
            String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"}; //initialising the suits of the deck in a String array named 'SUITS'
            String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"}; //initialising the ranks of the deck in a String array named 'RANKS'

            // initialize deck
            int n = SUITS.length * RANKS.length; // a deck consists of 4*13 cards
            String[] deck = new String[n];
            for (int i = 0; i < RANKS.length; i++) {
                for (int j = 0; j < SUITS.length; j++) {
                    deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
                }
            }

            // shuffle
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n-i)); //using random function
                String temp = deck[r];
                deck[r] = deck[i];
                deck[i] = temp; //swapping and shuffling
            }

            // print shuffled deck
            for (int i = 0; i < 1; i++) //printing one card at a time
            {
                System.out.println(deck[i]); //displaying a random card
            }
        }

    }

