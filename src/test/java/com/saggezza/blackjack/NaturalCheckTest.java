package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NaturalCheckTest {

    @Test
    public void bothNatural() {
        // Given: both the player and dealer have a natural

        // When: I check for naturals
        INaturalCheck naturalCheckObj = new NaturalCheck();
        String result = naturalCheckObj.checkForWinner(true, true);

        // Then: I return "tie"
        assertEquals("tie", result);
    }

    @Test
    public void playerNatural() {
        // Given:  the player has a natural but dealer does not

        // When: I check for naturals
        INaturalCheck naturalCheckObj = new NaturalCheck();
        String result = naturalCheckObj.checkForWinner(false, true);

        // Then: I return "natural"
        assertEquals("natural", result);
    }

    @Test
    public void dealerNatural() {
        // Given:  the dealer has a natural but player does not

        // When: I check for naturals
        INaturalCheck naturalCheckObj = new NaturalCheck();
        String result = naturalCheckObj.checkForWinner(true, false);

        // Then: I return "loose"
        assertEquals("loose", result);
    }

    @Test
    public void noNatural() {
        // Given:  neither dealer nor player has natural

        // When: I check for naturals
        INaturalCheck naturalCheckObj = new NaturalCheck();
        String result = naturalCheckObj.checkForWinner(false, false);

        // Then: I return "none"
        assertEquals("none", result);
    }
}
