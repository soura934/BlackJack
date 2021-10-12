package com.saggezza.blackjack;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CardValuesTest {

    @Test
    public void cardValues20() {
        // Given I have the cards 9 of Clubs and Ace of Spades
        List<String> cards = new ArrayList<>();
        cards.add("9 of Clubs");
        cards.add("Ace of Spades");

        ICardValue cardValue = mock(ICardValue.class);
        when(cardValue.Compare("9 of Clubs")).thenReturn(9);
        when(cardValue.Compare("Ace of Spades")).thenReturn(11);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // When I get the card values
        ICardValues cardValues = new CardValues(cardValue);
        cardValues.getCardValues(cards);

        // Then I call cardValue twice
        verify(cardValue, times(2)).Compare(argumentCaptor.capture());
    }
}
