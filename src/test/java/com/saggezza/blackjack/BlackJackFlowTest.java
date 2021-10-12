package com.saggezza.blackjack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BlackJackFlowTest {
    List<String> deck;
    String dealerCard1;
    String dealerCard2;
    String dealerCard3;
    String playerCard1;
    String playerCard2;
    String playerCard3;
    List<String> playerCards;
    List<String> dealerCards;
    List<Integer> playerValues;
    List<Integer> dealerValues;

    @Before
    public void beforeEach(){
         deck = new ArrayList<>();
        dealerCard1 = "10 of Hearts";
        dealerCard2 = "4 of Clubs";
        dealerCard3 = "5 of Diamonds";
        playerCard1 = "3 of Spades";
        playerCard2 = "8 of Hearts";
        playerCard3 = "9 of Diamonds";
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
        playerValues = new ArrayList<>();
        dealerValues = new ArrayList<>();
    }

    @Test
    public void generateDeckOnceTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(playerCards)).thenReturn(playerValues);
        when(cardValues.getCardValues(dealerCards)).thenReturn(dealerValues);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues);
        blackJackFlow.playGame();

//      Then: I call generate deck once
        verify(generateDeck, times(1)).Generate();
    }

    @Test
    public void drawCardFourTimesTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(playerCards)).thenReturn(playerValues);
        when(cardValues.getCardValues(dealerCards)).thenReturn(dealerValues);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues);
        blackJackFlow.playGame();
//      Then: I call generate draw card 4 times
        verify(drawCard, times(4)).draw(deck);
    }

    @Test
    public void displayCardFlowTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);
        ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<List<String>> argCaptor2 = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<Boolean> argCaptor3 = ArgumentCaptor.forClass(Boolean.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(playerCards)).thenReturn(playerValues);
        when(cardValues.getCardValues(dealerCards)).thenReturn(dealerValues);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues);
        blackJackFlow.playGame();

//      Then: I call display card 4 times
        verify(displayFlow, times(2)).displayCards(argCaptor.capture(),
                argCaptor2.capture(), argCaptor3.capture());
    }

    @Test
    public void getCardValuesTwice() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(playerCards)).thenReturn(playerValues);
        when(cardValues.getCardValues(dealerCards)).thenReturn(dealerValues);
        ArgumentCaptor<List<String >> argCaptor = ArgumentCaptor.forClass(List.class);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(cardValues, times(2)).getCardValues(argCaptor.capture());
    }

}
