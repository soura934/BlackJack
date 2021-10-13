package com.saggezza.blackjack;

public class BetValidation implements IBetValidation {

    public boolean validateBet(int userAmount, int userBet) {
        if (userBet <= 0) {
            return false;
        } else if (userBet <= userAmount) {
            return true;
        }
        return false;
    }
}
