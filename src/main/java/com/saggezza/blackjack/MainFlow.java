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
       double userAmount=100;
       boolean playAgain=true;
        Scanner scanner=new Scanner(System.in);
        while(playAgain){
            double bet=betFlow.getUserBet(userAmount);
            String result= blackjackobj.playGame();
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
