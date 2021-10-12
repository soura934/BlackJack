package com.saggezza.blackjack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DealerFlowTest {
    List<String> dealerCards = new ArrayList<>();
    List<String> deck = new ArrayList<>();
    List<Integer> scores = new ArrayList<Integer>();



    @Test
    public void dealerCardsTest() {
        scores.add(5);
        scores.add(3);
        deck.add("3 of Clubs");
        deck.add("5 of Hearts");
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("3 of Clubs", "5 of Hearts");

        ICardValue mockCardValue = mock(ICardValue.class);
        when(mockCardValue.Compare("3 of Clubs")).thenReturn(2);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValue, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call draw card method once
        verify(mockDrawCard, times(1)).draw(deck);
    }

    @Test
    public void dealerCardsTest2() {
        scores.add(5);
        scores.add(3);
        deck.add("3 of Clubs");
        deck.add("5 of Hearts");
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("3 of Clubs", "5 of Hearts");

        ICardValue mockCardValue = mock(ICardValue.class);
        when(mockCardValue.Compare("3 of Clubs")).thenReturn(3);
        when(mockCardValue.Compare("5 of Hearts")).thenReturn(5);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValue, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call draw card method once
        verify(mockCardValue, times(1)).Compare("3 of Clubs");
    }

    @Test
    public void dealerCardsTest3() {
        scores.add(3);
        scores.add(5);
        deck.add("3 of Clubs");
        deck.add("5 of Hearts");
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("3 of Clubs", "5 of Hearts");

        ICardValue mockCardValue = mock(ICardValue.class);
        when(mockCardValue.Compare("3 of Clubs")).thenReturn(3);
        when(mockCardValue.Compare("5 of Hearts")).thenReturn(5);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValue, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call draw card method once
        verify(mockCalculateScore, times(1)).calculate(scores);
    }
}
