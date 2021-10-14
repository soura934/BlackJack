package com.saggezza.blackjack;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class BetInputFlowTest {

    @Test
    public void validateBetCalledOnce() {
        String input = "90";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Given: The user has $100
        double userAmount = 100;
        double userBet = 90;

        IBetValidation betValid = mock(IBetValidation.class);
        when(betValid.validateBet(userAmount, userBet)).thenReturn(true);

        // When: They bet $90
        IBetInputFlow betInputObj = new BetInputFlow(betValid);
        betInputObj.getUserBet(userAmount);

        // Then: Validate Bet called once
        verify(betValid, times(1)).validateBet(userAmount, userBet);
    }

    @Test
    public void validateBetCalledTwice() {
        String input = "120\n90";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Given: The user has $100
        double userAmount = 100;
        double userBet = 120;

        IBetValidation betValid = mock(IBetValidation.class);
        when(betValid.validateBet(userAmount, userBet)).thenReturn(false);
        when(betValid.validateBet(userAmount, 90)).thenReturn(true);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);


        // When: They bet $120
        IBetInputFlow betInputObj = new BetInputFlow(betValid);
        betInputObj.getUserBet(userAmount);

        // Then: Validate Bet called once
        verify(betValid, times(2)).validateBet(argumentCaptor.capture(), argumentCaptor.capture());
    }

    @Test
    public void validateBetCalledTwice2() {
        // Given: The user amount is 100
        double userAmount = 100;
        double userBet = 0;

        String userBetInput = "0\n95";
        System.setIn(new ByteArrayInputStream(userBetInput.getBytes()));

        IBetValidation betValid = mock(IBetValidation.class);
        when(betValid.validateBet(userAmount, userBet)).thenReturn(false);
        when(betValid.validateBet(userAmount, 95)).thenReturn(true);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // When: They bet $0, then $95
        IBetInputFlow betInputObj = new BetInputFlow(betValid);
        betInputObj.getUserBet(userAmount);

        // Then: The validateBet is called twice
        verify(betValid, times(2)).validateBet(argumentCaptor.capture(), argumentCaptor.capture());
    }
}
