package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    public BlackJackFlow(IGenerateDeck generateDeck, IDrawCard drawCard, IDisplayFlow displayFlow,
                         ICardValues cardValues, INatural naturalValues, IPlayerFlow playerFlow,
                         IDealerFlow dealerFlow, ICalculateScore calculateScore) {
        this.generateDeck = generateDeck;
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
        this.naturalValues = naturalValues;
        this.playerFlow = playerFlow;
        this.dealerFlow = dealerFlow;
        this.calculateScore = calculateScore;
    }
    public void playGame(List<String> playerCards, List<String> dealerCards) {
        List<String> deck = generateDeck.Generate();
        dealerCards.add(drawCard.draw(deck));
        playerCards.add(drawCard.draw(deck));
        dealerCards.add(drawCard.draw(deck));
        playerCards.add(drawCard.draw(deck));

        displayFlow.displayCards("Dealer", dealerCards, true );
        displayFlow.displayCards("Player", playerCards, false );
        List<Integer> playerValues = cardValues.getCardValues(playerCards);
        List<Integer> dealerValues = cardValues.getCardValues(dealerCards);

        boolean playerNatural = naturalValues.validate(playerValues.get(0), playerValues.get(1));
        boolean dealerNatural = naturalValues.validate(dealerValues.get(0), dealerValues.get(1));

        if(dealerNatural && playerNatural) {
            System.out.println("The game is a tie. Both players have naturals");
            return;

        } else if(dealerNatural) {
            System.out.println("The dealer wins with a natural");
            return;
        } else if(playerNatural) {
            System.out.println("The player wins with a natural");
            return;
        }

        playerFlow.playerTurn(playerCards, deck);
        playerValues = cardValues.getCardValues(playerCards);
        int playerScore = calculateScore.calculate((playerValues));
        if (playerScore > 21) {
            System.out.println("Player busted Dealer wins");
            return;
        } else if (playerCards.size() == 5){
            System.out.println("Player drew 5 cards so they win");
            return;
        }
        dealerFlow.dealerDraw(deck, dealerCards);
        displayFlow.displayCards("Dealer", dealerCards, false );
        displayFlow.displayCards("Player", playerCards, false );

         dealerValues = cardValues.getCardValues(dealerCards);
         int dealerScore = calculateScore.calculate(dealerValues);
         if(dealerScore > 21) {
             System.out.println("Dealer busted Player wins!");
         } else if (dealerCards.size() == 5) {
             System.out.println("Dealer drew 5 cards so they win");
         } else if (dealerScore > playerScore) {
             System.out.println("Dealer wins");
         } else if (playerScore > dealerScore) {
             System.out.println("Player wins");
         } else {
             System.out.println("Tie");
         }
    }
}
