package com.saggezza.blackjack;

import java.util.List;

public class CalculateScore implements ICalculateScore {

    public int calculate(List<Integer> values) {
        int total = 0;
        int elevenCount = 0;
        for (int value : values) {
            total += value;
            if (value == 11) elevenCount++;
        }
        while (total > 21 && elevenCount > 0) {
            total -= 10;
            elevenCount--;
        }
        return total;
    }
}
