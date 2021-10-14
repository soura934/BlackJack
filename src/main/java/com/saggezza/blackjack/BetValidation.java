package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

@Component
public class BetValidation implements IBetValidation {

    public boolean validateBet(double userAmount, double userBet) {
        if (userBet <= 0) {
            return false;
        } else if (userBet <= userAmount) {
            return true;
        }
        return false;
    }
}
