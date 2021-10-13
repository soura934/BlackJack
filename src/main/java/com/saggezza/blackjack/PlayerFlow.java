package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.Scanner;

@Component
public class PlayerFlow implements IPlayerFlow {

    private IDrawCard drawCard;
    private IDisplayFlow displayFlow;
    private ICardValues cardValues;
    private ICalculateScore calculateObject;

    @Autowired
    public PlayerFlow(IDrawCard drawCard, IDisplayFlow displayFlow, ICardValues cardValues, ICalculateScore calculateObject) {
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
        this.cardValues = cardValues;
        this.calculateObject = calculateObject;
    }

    public void playerTurn(List<String> cards, List<String> deck) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter H to hold or D to Draw");
        String userInput = scan.nextLine();

        while(userInput.equals("D")) { //while they are drawing cards
            String newCard = drawCard.draw(deck); //they would only draw card if they enter D.
            cards.add(newCard);
            displayFlow.displayCards("player", cards, false);
            List <Integer> cardVals  = cardValues.getCardValues(cards);
            int score = calculateObject.calculate(cardVals);
            if (score >= 21 || cards.size() == 5) {
                break;
            }
            System.out.println("Enter H to hold or D to Draw");
            userInput = scan.nextLine();
        }
    }
}
