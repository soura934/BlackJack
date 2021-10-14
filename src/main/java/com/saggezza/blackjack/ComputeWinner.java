package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

@Component
public class ComputeWinner implements IComputeWinner {
    public String compute(int dealerScore, int playerScore, int handSize) {
        if(dealerScore > 21) {
            System.out.println("Dealer busted Player wins!");
            return "win";

        } else if (handSize == 5) {
            System.out.println("Dealer drew 5 cards so they win");
            return "loose";

        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins");
            return"loose";

        } else if (playerScore > dealerScore) {
            System.out.println("Player wins");
            return"win";

        } else {
            System.out.println("Tie");
            return "tie";
        }
    }
}
