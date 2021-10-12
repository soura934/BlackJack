package com.saggezza.blackjack;

import java.util.ArrayList;
import java.util.List;

public class CardValues implements ICardValues {

    private ICardValue cardValue;

    public CardValues(ICardValue cardValue) {
        this.cardValue = cardValue;
    }

    public List<Integer> getCardValues(List<String> cards) {
        List<Integer> values = new ArrayList<>();
        for (String card : cards) {
            values.add(cardValue.Compare(card));
        }
        return values;
    }
}
