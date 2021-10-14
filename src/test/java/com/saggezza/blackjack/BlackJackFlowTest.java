package com.saggezza.blackjack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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
        playerValues.add(3);
        playerValues.add(8);
        playerValues.add(9);
        dealerValues.add(10);
        dealerValues.add(4);
        dealerValues.add(5);
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
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
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
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);


        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
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
        ArgumentCaptor<List> argCaptor2 = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<Boolean> argCaptor3 = ArgumentCaptor.forClass(Boolean.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call display card 4 times
        verify(displayFlow, times(4)).displayCards(argCaptor.capture(),
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
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);
        ArgumentCaptor<List> argCaptor = ArgumentCaptor.forClass(List.class);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(cardValues, times(4)).getCardValues(argCaptor.capture());
    }

    @Test
    public void getNaturalsTwice() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);
        ArgumentCaptor<Integer> argCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> argCaptor2 = ArgumentCaptor.forClass(Integer.class);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(natural, times(2)).validate(argCaptor.capture(),argCaptor2.capture());
    }

    @Test
    public void getPlayerFlowTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);
        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(playerFlow, times(1)).playerTurn(Mockito.anyList(), Mockito.anyList());
    }

    @Test
    public void getDealerFlowTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);

        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(dealerFlow, times(1)).dealerDraw(Mockito.anyList(), Mockito.anyList());
    }

    @Test
    public void computeScoreTwiceTest() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);

        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);
        ArgumentCaptor<List> argCapture = ArgumentCaptor.forClass(List.class);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(calculateScore, times(2)).calculate(argCapture.capture());
    }

    @Test
    public void checkNaturalWinnerOnce() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 3)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);

        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call carvalues card 2 times
        verify(naturalCheck, times(1)).checkForWinner(false, false);
    }

    @Test
    public void checkComputeWinnerOnce() {
//      Given: I am user
        IGenerateDeck generateDeck = mock(IGenerateDeck.class);
        when(generateDeck.Generate()).thenReturn(deck);

        IDrawCard drawCard = mock(IDrawCard.class);
        when(drawCard.draw(deck)).thenReturn(dealerCard1).thenReturn(playerCard1)
                .thenReturn(dealerCard2).thenReturn(playerCard2);

        IDisplayFlow displayFlow = mock(IDisplayFlow.class);

        ICardValues cardValues = mock(ICardValues.class);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(playerValues);
        when(cardValues.getCardValues(Mockito.anyList())).thenReturn(dealerValues);

        INatural natural = mock(INatural.class);
        when(natural.validate(3,8)).thenReturn(false);
        when(natural.validate(10,4)).thenReturn(false);

        INaturalCheck naturalCheck = mock(INaturalCheck.class);
        when(naturalCheck.checkForWinner(false, false)).thenReturn("none");

        IComputeWinner computeWinner = mock(IComputeWinner.class);
        when(computeWinner.compute(19, 20, 2)).thenReturn("win");

        IPlayerFlow playerFlow = mock(IPlayerFlow.class);

        IDealerFlow dealerFlow = mock(IDealerFlow.class);

        ICalculateScore calculateScore = mock(ICalculateScore.class);
        when(calculateScore.calculate(Mockito.anyList())).thenReturn(20).thenReturn(19);

//      When: I start the game
        IBlackJackFlow blackJackFlow = new BlackJackFlow(generateDeck, drawCard, displayFlow,
                cardValues, natural, playerFlow, dealerFlow, calculateScore, naturalCheck, computeWinner);
        blackJackFlow.playGame();

//      Then: I call compute winner 1 times
        verify(computeWinner, times(1)).compute(19, 20, 2);
    }
}
