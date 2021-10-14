package com.saggezza.blackjack;

public class PlayerCountValidation implements IPlayerCountValidation {
    public boolean validate(int num) {
        return num > 0 && num <= 5;
    }
}
