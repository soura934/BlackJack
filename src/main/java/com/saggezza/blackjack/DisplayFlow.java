package com.saggezza.blackjack;

import java.util.List;

public class DisplayFlow implements IDisplayFlow {

    public void displayCards(String player, List<String> cards, boolean hidden) {
        System.out.println(player + " cards");
        if(hidden) {
            System.out.println(cards.get(0) + " ?");
        } else {
            String cardOutput = cards.get(0);
            for(int i = 1; i < cards.size(); i++) {
                cardOutput += ", " + cards.get(i);
            }
            System.out.println(cardOutput);
        }

    }
}
