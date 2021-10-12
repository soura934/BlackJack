package com.saggezza.blackjack;

import java.util.List;

public class PlayerFlow implements IPlayerFlow {

    private IDrawCard drawCard;

    public PlayerFlow(IDrawCard drawCard) {
        this.drawCard = drawCard;
    }

    public void playerTurn(List<String> cards, List<String> deck) {
        drawCard.draw(deck);

    }
}
