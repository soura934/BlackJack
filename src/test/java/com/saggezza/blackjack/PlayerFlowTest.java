package com.saggezza.blackjack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;



public class PlayerFlowTest {

    @Test
    public void playerDrawTest() {

        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();

        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        //When: Player decides to draw.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard);
        playerFlow.playerTurn(cards,deck);

        //Then: Draw card is called once.
        verify(drawCard, times(1)).draw(deck);

    }



}
