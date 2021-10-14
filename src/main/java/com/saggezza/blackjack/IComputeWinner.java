package com.saggezza.blackjack;

public interface IComputeWinner {
    String compute(int dealerScore, int playerScore, int handSize);
}
