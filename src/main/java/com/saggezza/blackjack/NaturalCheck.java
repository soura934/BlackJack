package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

@Component
public class NaturalCheck implements INaturalCheck {

    public String checkForWinner(boolean dealerNatural, boolean playerNatural) {
        if (dealerNatural && playerNatural) {
            System.out.println("The game is a tie. Both players have naturals");
            return "tie";
        } else if (!dealerNatural && playerNatural) {
            System.out.println("The player wins with a natural");
            return "natural";
        } else if (dealerNatural) {
            System.out.println("The dealer wins with a natural");
            return "loose";
        }
        return "none";
    }
}
