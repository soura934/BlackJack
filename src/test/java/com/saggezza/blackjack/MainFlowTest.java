package com.saggezza.blackjack;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

// import org.testng.util.Strings;

public class MainFlowTest {
    List<String> playerCards;
    List<String> dealerCards;

    @Before
    public void beforeEach() {
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    @Test
    public void betInputFlowTest() {
        System.setIn(new ByteArrayInputStream("N".getBytes()));

        //Given I am a user
        IBetInputFlow inputobj = mock(IBetInputFlow.class);
        when(inputobj.getUserBet(100.0)).thenReturn(50.0);
        IBlackJackFlow blackjackobj = mock(IBlackJackFlow.class);
        when(blackjackobj.playGame()).thenReturn("natural");
        ICalculateBet calculateobj = mock(ICalculateBet.class);
        when(calculateobj.calculate(100.0, 50.0, "natural")).thenReturn(175.0);

        IPlayerCountInput playerCountobj = mock(IPlayerCountInput.class);
        when(playerCountobj.getPlayerCount()).thenReturn(2);

        //when I start the game
        IMainFlow mainFlowobj = new MainFlow(inputobj, blackjackobj, calculateobj, playerCountobj);
        mainFlowobj.playBets();
        //Then i call betInputFlowOnce
        verify(inputobj, times(1)).getUserBet(100);
    }

    @Test
    public void blackJackTest() {
        System.setIn(new ByteArrayInputStream("N".getBytes()));
        //Given I am a user
        IBetInputFlow inputobj = mock(IBetInputFlow.class);
        when(inputobj.getUserBet(100)).thenReturn(50.0);

        IBlackJackFlow blackjackobj = mock(IBlackJackFlow.class);
        when(blackjackobj.playGame()).thenReturn("natural");

        ICalculateBet calculateobj = mock(ICalculateBet.class);
        when(calculateobj.calculate(100, 50, "natural")).thenReturn(175.0);

        IPlayerCountInput playerCountobj = mock(IPlayerCountInput.class);
        when(playerCountobj.getPlayerCount()).thenReturn(2);

        //when I start the game
        IMainFlow mainFlowobj = new MainFlow(inputobj, blackjackobj, calculateobj, playerCountobj);
        mainFlowobj.playBets();

        //Then I call blackjack once
        verify(blackjackobj, times(1)).playGame();
    }

    @Test
    public void calculateBettest() {
        System.setIn(new ByteArrayInputStream("N".getBytes()));
        //Given I am a user
        IBetInputFlow inputobj = mock(IBetInputFlow.class);
        when(inputobj.getUserBet(100)).thenReturn(50.0);

        IBlackJackFlow blackjackobj = mock(IBlackJackFlow.class);
        when(blackjackobj.playGame()).thenReturn("natural");

        ICalculateBet calculateobj = mock(ICalculateBet.class);
        when(calculateobj.calculate(100, 50, "natural")).thenReturn(175.0);

        IPlayerCountInput playerCountobj = mock(IPlayerCountInput.class);
        when(playerCountobj.getPlayerCount()).thenReturn(2);

        //when I start the game
        IMainFlow mainFlowobj = new MainFlow(inputobj, blackjackobj, calculateobj, playerCountobj);
        mainFlowobj.playBets();

        //Then I call blackjack once
        verify(calculateobj, times(1)).calculate(100, 50, "natural");
    }

    @Test
    public void restartGameTets() {
        System.setIn(new ByteArrayInputStream("P\nN".getBytes()));
        //Given I am a user
        IBetInputFlow inputobj = mock(IBetInputFlow.class);
        when(inputobj.getUserBet(100)).thenReturn(50.0);
        when(inputobj.getUserBet(175.0)).thenReturn(100.0);

        IBlackJackFlow blackjackobj = mock(IBlackJackFlow.class);
        when(blackjackobj.playGame()).thenReturn("natural").thenReturn("loose");

        ICalculateBet calculateobj = mock(ICalculateBet.class);
        when(calculateobj.calculate(100, 50, "natural")).thenReturn(175.0);
        when(calculateobj.calculate(175, 100, "loose")).thenReturn(75.0);
        ArgumentCaptor<Double> argumentCaptor = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<String> argumentCaptor2 = ArgumentCaptor.forClass(String.class);

        IPlayerCountInput playerCountobj = mock(IPlayerCountInput.class);
        when(playerCountobj.getPlayerCount()).thenReturn(2);


        //when I start the game
        IMainFlow mainFlowobj = new MainFlow(inputobj, blackjackobj, calculateobj, playerCountobj);
        mainFlowobj.playBets();

        //Then I call blackjack once
        verify(calculateobj, times(2)).calculate(argumentCaptor.capture(), argumentCaptor.capture(),
                argumentCaptor2.capture());
    }

    @Test
    public void playerCountInputOnce() {

        System.setIn(new ByteArrayInputStream("N".getBytes()));
        //Given I am a user
        IBetInputFlow inputobj = mock(IBetInputFlow.class);
        when(inputobj.getUserBet(100)).thenReturn(50.0);
        when(inputobj.getUserBet(175.0)).thenReturn(100.0);

        IBlackJackFlow blackjackobj = mock(IBlackJackFlow.class);
        when(blackjackobj.playGame()).thenReturn("natural").thenReturn("loose");

        ICalculateBet calculateobj = mock(ICalculateBet.class);
        when(calculateobj.calculate(100, 50, "natural")).thenReturn(175.0);
        when(calculateobj.calculate(175, 100, "loose")).thenReturn(75.0);

        IPlayerCountInput playerCountobj = mock(IPlayerCountInput.class);
        when(playerCountobj.getPlayerCount()).thenReturn(2);

        //when I start the game
        IMainFlow mainFlowobj = new MainFlow(inputobj, blackjackobj, calculateobj, playerCountobj);
        mainFlowobj.playBets();

        //Then I call player once
        verify(playerCountobj, times(1)).getPlayerCount();
    }

}



