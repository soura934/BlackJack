package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BetValidationTest {

    @Test
    public void validBetTest() {
        // Given: User has $100 and bet $90
        int userAmount = 100;
        int userBet = 90;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return True
        assertTrue(result);
    }

    @Test
    public void invalidBetTest() {
        // Given: User has $100 and bet $150
        int userAmount = 100;
        int userBet = 150;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return False
        assertFalse(result);
    }

    @Test
    public void invalidBetTest2() {
        // Given: User has $100 and bet -$10
        int userAmount = 100;
        int userBet = -10;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return False
        assertFalse(result);
    }

    @Test
    public void invalidBetTest3() {
        // Given: User has $100 and bet 0
        int userAmount = 100;
        int userBet = 0;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return False
        assertFalse(result);
    }

    @Test
    public void validBetTest2() {
        // Given: User has $100 and bet 1
        int userAmount = 100;
        int userBet = 1;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return True
        assertTrue(result);
    }

    @Test
    public void validBetTest3() {
        // Given: User has $100 and bet $100
        int userAmount = 100;
        int userBet = 100;

        // When: we validate the bet
        IBetValidation betValidationObj = new BetValidation();
        boolean result = betValidationObj.validateBet(userAmount, userBet);

        // Then: Return True
        assertTrue(result);
    }
}
