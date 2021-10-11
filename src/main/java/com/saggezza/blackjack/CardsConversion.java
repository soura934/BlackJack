package com.saggezza.blackjack;

public class CardsConversion implements ICardsConversion{

    public String numberToCard(int num) {
        String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8",
                            "9", "10", "J", "K", "Q"};
        return cards[num -1];
    }
}
