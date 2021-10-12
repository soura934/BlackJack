package com.saggezza.blackjack;

import java.util.List;

import java.util.Scanner;
public class PlayerFlow implements IPlayerFlow {

    private IDrawCard drawCard;
    private IDisplayFlow displayFlow;

    public PlayerFlow(IDrawCard drawCard, IDisplayFlow displayFlow) {
        this.drawCard = drawCard;
        this.displayFlow = displayFlow;
    }

    public void playerTurn(List<String> cards, List<String> deck) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter H to hold or D to Draw");
        String userInput = scan.nextLine();

        while(userInput.equals("D")) { //while they are drawing cards
            String newCard = drawCard.draw(deck); //they would only draw card if they enter D.
            cards.add(newCard);
            displayFlow.displayCards("player", cards, false);

            System.out.println("Enter H to hold or D to Draw");
            userInput = scan.nextLine();

        }

    }
}
