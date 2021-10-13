package com.saggezza.blackjack;

public class CalculateBet implements ICalculateBet {
    public double calculate(double money, int bet, String gameResult) {
        money = money - bet;
        if (gameResult == "natural") {
            money += (bet * 2.5);
            System.out.println("You bet: " + bet + "and your new amount is :" + money);

            return money;
        } else if (gameResult == "win") {
            money += (bet * 2);
            System.out.println("You bet: " + bet + "and your new amount is :" + money);

            return money;
        } else if (gameResult == "loose") {
            System.out.println("You bet: " + bet + "and your new amount is :" + money);

            return money;
        } else {
            System.out.println("You bet: " + bet + "and your new amount is :" + money);
        }
        return money + bet;
    }
}

