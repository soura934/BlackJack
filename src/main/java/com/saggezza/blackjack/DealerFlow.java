package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealerFlow implements IDealerFlow{

    private IDrawCard drawCard;
    private ICardValues cardValues;
    private ICalculateScore calculateScore;

    @Autowired
    public DealerFlow(IDrawCard drawCard, ICardValues cardValues, ICalculateScore calculateScore){
        this.drawCard = drawCard;
        this.cardValues = cardValues;
        this.calculateScore = calculateScore;
    }

    public void dealerDraw(List<String> deck, List<String> dealerCards) {
        // dealer cards : ["3 of Heart", "4 of Club"];
        // loop through dealer cards
        // pass it in cardValue.compare() then return 3;
        // pass it in a List then it will become: [3, 4]
        // pass it in the calculate score method
        List<Integer> scores = cardValues.getCardValues(dealerCards);

        int totalScore = calculateScore.calculate(scores);
        while (dealerCards.size() < 5 && totalScore < 17){
            String card = drawCard.draw(deck);
            dealerCards.add(card);
            scores = cardValues.getCardValues(dealerCards);
            totalScore = calculateScore.calculate(scores);
        }
    }
}
