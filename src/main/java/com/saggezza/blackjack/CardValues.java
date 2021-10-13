package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardValues implements ICardValues {

    private ICardValue cardValue;

    @Autowired
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
