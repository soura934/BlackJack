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
        List<Integer> values = new ArrayList<>();


        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");
        values.add(5);
        values.add(10);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(cards)).thenReturn(values);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(values)).thenReturn(16);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        //When: Player decides to draw.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard, displayFlow, cardValues, calculateScore);
        playerFlow.playerTurn(cards, deck);

        //Then: Draw card is called once.
        verify(drawCard, times(1)).draw(deck);

    }

    @Test
    public void playerHoldNoDrawTest() {
        String userInput = "H";
        System.setIn(new ByteArrayInputStream(userInput.getBytes())); //Filling in with fake user input
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();
        List<Integer> values = new ArrayList<>();


        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");
        values.add(5);
        values.add(10);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(cards)).thenReturn(values);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(values)).thenReturn(16);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        //When: Player stands.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard, displayFlow, cardValues, calculateScore);
        playerFlow.playerTurn(cards, deck);

        //Then: Draw card is not called.
        verify(drawCard, times(0)).draw(deck);

    }

    @Test
    public void displayCard() {
        String userInput = "D\nH";
        System.setIn(new ByteArrayInputStream(userInput.getBytes())); //Filling in with fake user input
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();
        List<Integer> values = new ArrayList<>();


        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");
        values.add(5);
        values.add(10);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(cards)).thenReturn(values);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(values)).thenReturn(16);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        //When: Player draws.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard, displayFlow, cardValues, calculateScore);
        playerFlow.playerTurn(cards, deck);


        //Then: Cards are displayed.
        verify(displayFlow, times(1)).displayCards("player", cards, false);
    }

    @Test
    public void getCardValuesOnce() {
        String userInput = "D\nH";
        System.setIn(new ByteArrayInputStream(userInput.getBytes())); //Filling in with fake user input
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");
        values.add(5);
        values.add(10);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(cards)).thenReturn(values);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(values)).thenReturn(16);


        IDisplayFlow displayFlow = mock(IDisplayFlow.class);


        //When: Player draws.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard, displayFlow, cardValues, calculateScore);
        playerFlow.playerTurn(cards, deck);

        //Then: function card values is called once.
        verify(cardValues, times(1)).getCardValues(cards);
    }

    @Test
    public void getHandScore() {
        String userInput = "D\nH";
        System.setIn(new ByteArrayInputStream(userInput.getBytes())); //Filling in with fake user input
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        //Given: Player has a 5,10.
        cards.add("5 of Hearts");
        cards.add("10 of Clubs");
        values.add(5);
        values.add(10);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn("Ace of Spades");

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(cards)).thenReturn(values);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(values)).thenReturn(16);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);


        //When: Player draws.
        IPlayerFlow playerFlow = new PlayerFlow(drawCard, displayFlow, cardValues, calculateScore);
        playerFlow.playerTurn(cards, deck);

        //Then: function card values is called once.
        verify(calculateScore, times(1)).calculate(values);
    }


}
