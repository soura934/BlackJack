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

    @Autowired
    public BlackJackFlow(IGenerateDeck generateDeck, IDrawCard drawCard, IDisplayFlow displayFlow,
                         ICardValues cardValues, INatural naturalValues, IPlayerFlow playerFlow,
                         IDealerFlow dealerFlow, ICalculateScore calculateScore, INaturalCheck naturalCheck) {
        this.generateDeck = generateDeck;
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
        this.naturalValues = naturalValues;
        this.playerFlow = playerFlow;
        this.dealerFlow = dealerFlow;
        this.calculateScore = calculateScore;
        this.naturalCheck = naturalCheck;
    }

    // public List<String> playGame(List<Boolean> players) {
    public String playGame() {
        List<String> deck = generateDeck.Generate();

//        List<List<String>> playersCards = new ArrayList<>();
//        for(int i = 0; i < players.size(); i++) {
//            playersCards.add(new ArrayList<>());
//        }

        List<String> playerCards = new ArrayList<>();
        List<String> dealerCards = new ArrayList<>();

        // List<String> results = new ArrayList<>();

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

         // String result = ComputeWinner.getWinner(dealerScore, playerScore, dealerHandSize)
         if(dealerScore > 21) {
             System.out.println("Dealer busted Player wins!");
            return "win";

         } else if (dealerCards.size() == 5) {
             System.out.println("Dealer drew 5 cards so they win");
             return "loose";

         } else if (dealerScore > playerScore) {
             System.out.println("Dealer wins");
             return"loose";

         } else if (playerScore > dealerScore) {
             System.out.println("Player wins");
             return"win";

         } else {
             System.out.println("Tie");
             return "tie";
         }
    }
}
