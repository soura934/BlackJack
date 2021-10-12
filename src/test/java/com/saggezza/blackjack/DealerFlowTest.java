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
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("4 of Clubs").thenReturn("6 of Hearts");

        ICardValues mockCardValues = mock(ICardValues.class);
        when(mockCardValues.getCardValues(dealerCards)).thenReturn(scores);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8).thenReturn(12).thenReturn(18);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValues, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call draw card method twice
        verify(mockDrawCard, times(2)).draw(deck);
    }

    @Test
    public void dealerCardsTest2() {
        scores.add(5);
        scores.add(3);
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("4 of Clubs").thenReturn("6 of Hearts");

        ICardValues mockCardValues = mock(ICardValues.class);
        when(mockCardValues.getCardValues(dealerCards)).thenReturn(scores);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8).thenReturn(12).thenReturn(18);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValues, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call Compare card method twice
        verify(mockCardValues, times(3)).getCardValues(dealerCards);
    }

    @Test
    public void dealerCardsTest3() {
        scores.add(3);
        scores.add(5);
        dealerCards.add("3 of Clubs");
        dealerCards.add("5 of Hearts");
//      Given: the dealer has 3 and 5
        IDrawCard mockDrawCard = mock(IDrawCard.class);
        when(mockDrawCard.draw(deck)).thenReturn("4 of Clubs").thenReturn("6 of Hearts");

        ICardValues mockCardValues = mock(ICardValues.class);
        when(mockCardValues.getCardValues(dealerCards)).thenReturn(scores);

        ICalculateScore mockCalculateScore = mock(ICalculateScore.class);
        when(mockCalculateScore.calculate(scores)).thenReturn(8).thenReturn(12).thenReturn(18);

//      When: the dealer hand is less than 17 and hand less than 5
        IDealerFlow dealerFlow = new DealerFlow(mockDrawCard, mockCardValues, mockCalculateScore);
        dealerFlow.dealerDraw(deck, dealerCards);

//      Then: We call calculate card method once
        verify(mockCalculateScore, times(3)).calculate(scores);
    }
}
