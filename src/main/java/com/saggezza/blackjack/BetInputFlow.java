package com.saggezza.blackjack;

import java.util.Scanner;

public class BetInputFlow implements IBetInputFlow {

    private IBetValidation betValidation;

    public BetInputFlow(IBetValidation betValidation) {
        this.betValidation = betValidation;
    }

    public int getUserBet(int userAmount) {
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Enter your bet amount (Between 1 and " + userAmount + "): ");
        int betAmount = scanObj.nextInt();
        while (!betValidation.validateBet(userAmount, betAmount)) {
            System.out.println("Invalid bet amount, try again: ");
            betAmount = scanObj.nextInt();
        }
        System.out.println("You have bet $" + betAmount);
        return betAmount;
    }
}
