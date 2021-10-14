package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class MainFlow implements IMainFlow {
  private IBetInputFlow betFlow;
  private IBlackJackFlow blackjackobj;
  private ICalculateBet calculateobj;
@Autowired
    public MainFlow(IBetInputFlow betFlow,IBlackJackFlow blackjackobj,ICalculateBet calculateobj) {
        this.betFlow=betFlow;
        this.blackjackobj=blackjackobj;
        this.calculateobj=calculateobj;
    }

    public void playBets() {
        // PlayingInputFlow that returns # between 1-5
        // int numPlayers = 3;
        // List<Double> userAmounts = new ArrayList<>();
        // userAmounts.add(100);
        // List<Double> bets = new ArrayList<>();
        // bets.add(0);
       double userAmount=100;
       boolean playAgain=true;
        Scanner scanner=new Scanner(System.in);
        while(playAgain){
            // betFlow would be in a loop
            double bet=betFlow.getUserBet(userAmount);
            // blackjackobj would return List<String>
            // playGame would have to take in a List<Boolean>
            // True, False, True
            String result= blackjackobj.playGame();
            // calculateobj would be in a loop
            // calculate "noplay"
            userAmount = calculateobj.calculate(userAmount,bet,result);
            if(userAmount==0){
                System.out.println("You have no more money");
                break;
            }
            System.out.println("Would you press P to play again");
         String input= scanner.nextLine();
         playAgain=input.equals("P");
        }
    }
}
