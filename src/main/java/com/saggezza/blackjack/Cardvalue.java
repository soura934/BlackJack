package com.saggezza.blackjack;
//import java.util.stream.Collectors;
//import java.util.stream.Streams;

//import java.lang.constant.Constable;

import java.util.HashMap;
import java.util.Map;

public class Cardvalue implements ICardValue {

    private Map<String, Integer> cardMap;

    public Cardvalue() {
        cardMap = new HashMap<>();
        cardMap.put("Ace", 11);
        cardMap.put("2", 2);
        cardMap.put("3", 3);
        cardMap.put("4", 4);
        cardMap.put("5", 5);
        cardMap.put("6", 6);
        cardMap.put("7", 7);
        cardMap.put("8", 8);
        cardMap.put("9", 9);
        cardMap.put("10", 10);
        cardMap.put("Jack", 10);
        cardMap.put("Queen", 10);
        cardMap.put("King", 10);
    }

    public int Compare(String card) {
        // "3 of Hearts";
        // "Ace of Diamonds";
        String[] cardComponents = card.split(" ");
        // ['3', 'of', 'hearts']

        return cardMap.get(cardComponents[0]);
    }
}



