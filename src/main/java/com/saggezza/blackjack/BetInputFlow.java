package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class BetInputFlow implements IBetInputFlow {

    private IBetValidation betValidation;
@Autowired
    public BetInputFlow(IBetValidation betValidation) {
        this.betValidation = betValidation;
    }

    public double getUserBet(double userAmount) {
        Scanner scanObj = new Scanner(System.in);
        System.out.println("Enter your bet amount (Between 1 and " + userAmount + "): ");
        double betAmount = scanObj.nextInt();
        while (!betValidation.validateBet(userAmount, betAmount)) {
            System.out.println("Invalid bet amount, try again: ");
            betAmount = scanObj.nextInt();
        }
        System.out.println("You have bet $" + betAmount);
        return betAmount;
    }
}
