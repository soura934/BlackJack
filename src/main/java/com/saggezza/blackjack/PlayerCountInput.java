package com.saggezza.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PlayerCountInput implements IPlayerCountInput {

    private IPlayerCountValidation playerCountValidation;

    @Autowired
    public PlayerCountInput(IPlayerCountValidation playerCountValidation) {
        this.playerCountValidation = playerCountValidation;
    }

    public int getPlayerCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of player between 1 and 5");
        int input = scanner.nextInt();

        while (!playerCountValidation.validate(input)){
            System.out.println("Incorrect input please enter number of player between 1 and 5");
            input = scanner.nextInt();
        }

        return input;
    }
}
