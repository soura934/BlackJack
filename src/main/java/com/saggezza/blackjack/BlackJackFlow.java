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
        List<String> results = new ArrayList<>();
        for(int i = 0; i < players.size(); i++) {
            playersCards.add(new ArrayList<>());
            results.add("");
        }
        List<String> dealerCards = new ArrayList<>();

        for(int j = 0; j < 2; j++) {
            dealerCards.add(drawCard.draw(deck));
            for(int i = 0; i < playersCards.size(); i++) {
                if (!players.get(i)) {
                    continue;
                }
                List <String> cards = playersCards.get(i);
                cards.add(drawCard.draw(deck));
            }
        }
        displayFlow.displayCards("Dealer", dealerCards, true );
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i)) {
                results.set(i, "noplay");
                continue;
            }
            List<String> currentPlayerCards = playersCards.get(i);
            displayFlow.displayCards("Player " + (i + 1), currentPlayerCards, false);
            List<Integer> playerValues = cardValues.getCardValues(currentPlayerCards);
            List<Integer> dealerValues = cardValues.getCardValues(dealerCards);

            boolean playerNatural = naturalValues.validate(playerValues.get(0), playerValues.get(1));
            boolean dealerNatural = naturalValues.validate(dealerValues.get(0), dealerValues.get(1));

            String naturalWinner = naturalCheck.checkForWinner(dealerNatural, playerNatural);
            if (!naturalWinner.equals("none")) {
                results.set(i, naturalWinner);
                continue;
            }

            playerFlow.playerTurn(currentPlayerCards, deck);
            playerValues = cardValues.getCardValues(currentPlayerCards);
            int playerScore = calculateScore.calculate((playerValues));
            if (playerScore > 21) {
                System.out.println("Player busted Dealer wins");
                results.set(i, "loose");
                continue;
            } else if (currentPlayerCards.size() == 5) {
                System.out.println("Player drew 5 cards so they win");
                results.set(i, "win");
                continue;
            }
            displayFlow.displayCards("Player " + (i + 1), currentPlayerCards, false);
        }
        dealerFlow.dealerDraw(deck, dealerCards);
        displayFlow.displayCards("Dealer", dealerCards, false);

        List<Integer> dealerValues = cardValues.getCardValues(dealerCards);
        int dealerScore = calculateScore.calculate(dealerValues);

        for (int i = 0; i < players.size(); i++) {
            if (results.get(i).equals("")) {
                List<String> currentPlayerCards = new ArrayList<>();
                List<Integer> playerValues = cardValues.getCardValues(currentPlayerCards);
                int playerScore = calculateScore.calculate(playerValues);

                String result = computeWinner.compute(dealerScore, playerScore, dealerCards.size());
                results.set(i, result);
            }
        }
        return results;
    }
}
