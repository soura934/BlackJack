package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
@Component
public class MainFlow implements IMainFlow {
  private IBetInputFlow betFlow;
  private IBlackJackFlow blackjackobj;
  private ICalculateBet calculateobj;
  private IPlayerCountInput playerCountObj;
@Autowired
    public MainFlow(IBetInputFlow betFlow,IBlackJackFlow blackjackobj,ICalculateBet calculateobj, IPlayerCountInput playerCountObj) {
        this.betFlow= betFlow;
        this.blackjackobj= blackjackobj;
        this.calculateobj= calculateobj;
        this.playerCountObj = playerCountObj;
    }

    public void playBets() {
         int numPlayers = playerCountObj.getPlayerCount();
        List<Double> userAmounts = new ArrayList<>();
        List<Boolean> playing = new ArrayList<>(numPlayers);
        for(int i = 0; i < numPlayers; i++) {
            userAmounts.add(100.0);
            playing.add(true);
        }
        List<Double> bets = new ArrayList<>(numPlayers);
       boolean playAgain=true;
        Scanner scanner=new Scanner(System.in);
        while(playAgain){
            for(int i = 0; i < numPlayers; i++) {
                if(userAmounts.get(i) > 0) {
                    double bet=betFlow.getUserBet(userAmounts.get(i));
                    bets.set(i, bet);
             } else {
                    playing.set(i, false);
                }
            }
            List <String> results = blackjackobj.playGame(playing);
            for(int i = 0; i < numPlayers; i++) {
                if(playing.get(i)) {
                    double userAmount = userAmounts.get(i);
                    double bet = bets.get(i);
                    double newAmount = calculateobj.calculate(userAmount, bet, results.get(i));
                    userAmounts.set(i, newAmount);
                }
            }
            System.out.println("Would you press P to play again");
         String input= scanner.nextLine();
         playAgain=input.equals("P");
        }
    }
}
