package com.saggezza.blackjack;

import java.util.List;

public interface IDealerFlow {
    void dealerDraw(List<String> deck, List<String> dealerCards);
}
