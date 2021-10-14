package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputeWinnerTest {

    @Test
    public void dealerBustTest() {
//        Given: Dealer has over 24


//        When: We check for a winner
        IComputeWinner computeWinner = new ComputeWinner();
        String result = computeWinner.compute(24,21,3);

//        Then: The dealer is busted
        assertEquals("win", result);
    }

    @Test
    public void dealerHandSizeTest() {
//        Given: Dealer has 5 cards


//        When: We check for a winner
        IComputeWinner computeWinner = new ComputeWinner();
        String result = computeWinner.compute(18,21,5);

//        Then: The dealer is win
        assertEquals("loose", result);
    }

    @Test
    public void playerLooseTest() {
//        Given: Dealer has 18
//        And: Player has 17


//        When: We check for a winner
        IComputeWinner computeWinner = new ComputeWinner();
        String result = computeWinner.compute(18,17,4);

//        Then: The player is loose
        assertEquals("loose", result);
    }

    @Test
    public void playerWinTest() {
//        Given: Dealer has 16
//        And: Player has 17


//        When: We check for a winner
        IComputeWinner computeWinner = new ComputeWinner();
        String result = computeWinner.compute(16,17,4);

//        Then: The player is win
        assertEquals("win", result);
    }

    @Test
    public void tieGameTest() {
//        Given: Dealer has 16
//        And: Player has 16


//        When: We check for a winner
        IComputeWinner computeWinner = new ComputeWinner();
        String result = computeWinner.compute(16,16,4);

//        Then: The game is tie
        assertEquals("tie", result);
    }
}
