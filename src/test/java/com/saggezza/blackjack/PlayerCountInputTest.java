package com.saggezza.blackjack;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class PlayerCountInputTest {

    @Test
    public void playerCountOnceTest(){
        String input = "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Given: I start the game
        IPlayerCountValidation playerCountValidation = mock(IPlayerCountValidation.class);
        when(playerCountValidation.validate(4)).thenReturn(true);
//        When: I get the player count of 4
        IPlayerCountInput playerCountInput = new PlayerCountInput(playerCountValidation);
        playerCountInput.getPlayerCount();
//        Then: Player Count Validate Once
        verify(playerCountValidation, times(1)).validate(4);
    }

    @Test
    public void playerCountTwiceTest(){

        String input = "6\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

//        Given: I start the game
        IPlayerCountValidation playerCountValidation = mock(IPlayerCountValidation.class);
        when(playerCountValidation.validate(6)).thenReturn(false);
        when(playerCountValidation.validate(4)).thenReturn(true);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

//        When: I get the player count of 6 and 4
        IPlayerCountInput playerCountInput = new PlayerCountInput(playerCountValidation);
        playerCountInput.getPlayerCount();

//        Then: Player Count Validate twice
        verify(playerCountValidation, times(2)).validate(argumentCaptor.capture());
    }
}
