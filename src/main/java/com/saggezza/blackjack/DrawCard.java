package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrawCard implements IDrawCard {
    public String draw(List<String> deck) {
        int index = (int) (Math.random() * (deck.size() - 1)); // Get a number between 0 and the size of the remaining deck
        String card = deck.remove(index);
        return card;
    }
}
