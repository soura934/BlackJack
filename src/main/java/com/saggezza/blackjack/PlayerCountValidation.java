package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

@Component
public class PlayerCountValidation implements IPlayerCountValidation {
    public boolean validate(int num) {
        return num > 0 && num <= 5;
    }
}
