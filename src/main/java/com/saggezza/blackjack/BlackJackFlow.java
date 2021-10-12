package com.saggezza.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackFlow implements IBlackJackFlow{

    private IGenerateDeck generateDeck;
    private IDrawCard drawCard;
    private IDisplayFlow displayFlow;
    private ICardValues cardValues;
    private INatural naturalValues;
    private IPlayerFlow playerFlow;
    private IDealerFlow dealerFlow;

    public BlackJackFlow(IGenerateDeck generateDeck, IDrawCard drawCard, IDisplayFlow displayFlow,
                         ICardValues cardValues, INatural naturalValues, IPlayerFlow playerFlow, IDealerFlow dealerFlow) {
        this.generateDeck = generateDeck;
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
        this.naturalValues = naturalValues;
        this.playerFlow = playerFlow;
        this.dealerFlow = dealerFlow;
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
        dealerFlow.dealerDraw(dealerCards,deck);
    }
}
