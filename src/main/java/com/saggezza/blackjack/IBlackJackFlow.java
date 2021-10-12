package com.saggezza.blackjack;

import java.util.List;

public interface IBlackJackFlow {
    void playGame(List<String> playerCards, List<String> dealerCards);
}
