package com.saggezza.blackjack;

import java.util.List;

public interface IBlackJackFlow {
    String playGame(List<String> playerCards, List<String> dealerCards);
}
