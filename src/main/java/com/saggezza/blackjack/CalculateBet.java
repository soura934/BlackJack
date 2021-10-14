package com.saggezza.blackjack;

import org.springframework.stereotype.Component;

@Component
public class CalculateBet implements ICalculateBet {
    public double calculate(double money, double bet, String gameResult) {
        money = money - bet;
        if (gameResult.equals("natural")) {
            money += (bet * 2.5);
            System.out.println("You bet: " + bet + " and your new amount is : " + money);

            return money;
        } else if (gameResult.equals("win")) {
            money += (bet * 2);
            System.out.println("You bet: " + bet + " and your new amount is : " + money);

            return money;
        } else if (gameResult.equals("loose")) {
            System.out.println("You bet: " + bet + " and your new amount is : " + money);

            return money;
        } else {
            System.out.println("You bet: " + bet + " and your new amount is : " +( money+bet));
        }
        return money + bet;
    }
}

