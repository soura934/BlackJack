package com.saggezza.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackFlow implements IBlackJackFlow{

    private IGenerateDeck generateDeck;
    private IDrawCard drawCard;
    private IDisplayFlow displayFlow;
    private ICardValues cardValues;

    public BlackJackFlow(IGenerateDeck generateDeck, IDrawCard drawCard, IDisplayFlow displayFlow,
                         ICardValues cardValues) {
        this.generateDeck = generateDeck;
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
    }
    public void playGame() {
        List<String> deck = generateDeck.Generate();
        List<String> dealerCards = new ArrayList<>();
        List<String> playerCards = new ArrayList<>();
        dealerCards.add(drawCard.draw(deck));
        playerCards.add(drawCard.draw(deck));
        dealerCards.add(drawCard.draw(deck));
        playerCards.add(drawCard.draw(deck));

        displayFlow.displayCards("Dealer", dealerCards, true );
        displayFlow.displayCards("Player", playerCards, false );
        List<Integer> playerValues = cardValues.getCardValues(playerCards);
        List<Integer> dealerValues = cardValues.getCardValues(dealerCards);
    }
}
