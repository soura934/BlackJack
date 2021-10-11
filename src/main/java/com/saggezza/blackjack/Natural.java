package com.saggezza.blackjack;

public class Natural implements INatural {

    public boolean validate(int card1, int card2) {
        if (card1 == 10 && card2 == 11) {
            return true;
        } else if (card1 == 11 && card2 == 10) {
            return true;
        }
        return false;

    }
}




