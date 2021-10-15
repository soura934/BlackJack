package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BlackJackFlow implements IBlackJackFlow{

    private IGenerateDeck generateDeck;
    private IDrawCard drawCard;
    private IDisplayFlow displayFlow;
    private ICardValues cardValues;
    private INatural naturalValues;
    private IPlayerFlow playerFlow;
    private IDealerFlow dealerFlow;
    private ICalculateScore calculateScore;
    private INaturalCheck naturalCheck;
    private IComputeWinner computeWinner;

    @Autowired
    public BlackJackFlow(IGenerateDeck generateDeck, IDrawCard drawCard, IDisplayFlow displayFlow,
                         ICardValues cardValues, INatural naturalValues, IPlayerFlow playerFlow,
                         IDealerFlow dealerFlow, ICalculateScore calculateScore, INaturalCheck naturalCheck,
                         IComputeWinner computeWinner) {
        this.generateDeck = generateDeck;
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
        this.naturalValues = naturalValues;
        this.playerFlow = playerFlow;
        this.dealerFlow = dealerFlow;
        this.calculateScore = calculateScore;
        this.naturalCheck = naturalCheck;
        this.computeWinner = computeWinner;
    }

    public List<String> playGame(List<Boolean> players) {
        List<String> deck = generateDeck.Generate();
        List<List<String>> playersCards = new ArrayList<>();
        for(int i = 0; i < players.size(); i++) {
            playersCards.add(new ArrayList<>());
        }
        List<String> dealerCards = new ArrayList<>();
        List<String> results = new ArrayList<>();
        for(int j = 0; j < 2; j++) {
            dealerCards.add(drawCard.draw(deck));
            for(int i = 0; i < playersCards.size(); i++) {
                List <String> cards = playersCards.get(i);
                cards.add(drawCard.draw(deck));
            }
        }
        

        displayFlow.displayCards("Dealer", dealerCards, true );
        displayFlow.displayCards("Player", playerCards, false );
        List<Integer> playerValues = cardValues.getCardValues(playerCards);
        List<Integer> dealerValues = cardValues.getCardValues(dealerCards);

        boolean playerNatural = naturalValues.validate(playerValues.get(0), playerValues.get(1));
        boolean dealerNatural = naturalValues.validate(dealerValues.get(0), dealerValues.get(1));

         String naturalWinner = naturalCheck.checkForWinner(dealerNatural, playerNatural);
         if (!naturalWinner.equals("none")) return naturalWinner;

        playerFlow.playerTurn(playerCards, deck);
        playerValues = cardValues.getCardValues(playerCards);
        int playerScore = calculateScore.calculate((playerValues));
        if (playerScore > 21) {
            System.out.println("Player busted Dealer wins");
            return "loose";
        } else if (playerCards.size() == 5){
            System.out.println("Player drew 5 cards so they win");
            return "win";
        }
        dealerFlow.dealerDraw(deck, dealerCards);
        displayFlow.displayCards("Dealer", dealerCards, false );
        displayFlow.displayCards("Player", playerCards, false );

        dealerValues = cardValues.getCardValues(dealerCards);
         int dealerScore = calculateScore.calculate(dealerValues);

          String result = computeWinner.compute(dealerScore, playerScore, dealerCards.size());
          return result;
    }
}
