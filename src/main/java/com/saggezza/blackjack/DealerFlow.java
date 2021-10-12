package com.saggezza.blackjack;

import java.util.ArrayList;
import java.util.List;

public class DealerFlow implements IDealerFlow{

    private IDrawCard drawCard;
    private ICardValue cardValue;
    private ICalculateScore calculateScore;

    public DealerFlow(IDrawCard drawCard, ICardValue cardValue, ICalculateScore calculateScore){
        this.drawCard = drawCard;
        this.cardValue = cardValue;
        this.calculateScore = calculateScore;
    }

    public void dealerDraw(List<String> deck, List<String> dealerCards) {
        // dealer cards : ["3 of Heart", "4 of Club"];
        // loop through dealer cards
        // pass it in cardValue.compare() then return 3;
        // pass it in a List then it will become: [3, 4]
        // pass it in the calculate score method
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < dealerCards.size(); i++){
            int score = cardValue.Compare(dealerCards.get(i));
            scores.add(score);
        }
        int totalScore = calculateScore.calculate(scores);
        if(dealerCards.size() < 5 && totalScore < 17){
            String card = drawCard.draw(deck);
            dealerCards.add(card);
        }
    }
}
