package com.saggezza.blackjack;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardsConversonTest  {

    @Test
    public void numberToCardTest() {

//      Given: I have the number 1
        int num = 1;

//      When: I convert it to a card
        ICardsConversion cardsConversion = new CardsConversion();
        String result = cardsConversion.numberToCard(num);

//      Then: I should get back an Ace
        assertEquals("A", result);
    }

    @Test
    public void numberToCardTest2() {

//      Given: I have the number 1
        int num = 11 ;

//      When: I convert it to a card
        ICardsConversion cardsConversion = new CardsConversion();
        String result = cardsConversion.numberToCard(num);

//      Then: I should get back an Ace
        assertEquals("J", result);
    }
}
