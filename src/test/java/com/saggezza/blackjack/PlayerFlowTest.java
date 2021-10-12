package com.saggezza.blackjack;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;



public class PlayerFlowTest {

    @Test
    public void playerDrawTest() {
        String userInput = "D\nH";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
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

    @Test
    public void playerHoldNoDrawTest() {
        String userInput = "H";
        System.setIn(new ByteArrayInputStream(userInput.getBytes())); //Filling in with fake user input
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();

        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        //When: Player stand.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard);
        playerFlow.playerTurn(cards,deck);

        //Then: Draw card is not called.
        verify(drawCard, times(0)).draw(deck);





    }



}
