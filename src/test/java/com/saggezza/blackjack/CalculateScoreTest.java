package com.saggezza.blackjack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculateScoreTest {

    @Test
    public void testCalcLessThan21() {
        // Given I have values 4, 8, 7
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(8);
        values.add(7);

        // When I calculate the score
        ICalculateScore calculateScore = new CalculateScore();
        int result = calculateScore.calculate(values);

        // Then I get back 19
        assertEquals(19, result);
    }

    @Test
    public void testCalc21WithAce() {
        // Given I have values 4, 5, 11
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(5);
        values.add(11);

        // When I calculate the score
        ICalculateScore calculateScore = new CalculateScore();
        int result = calculateScore.calculate(values);

        // Then I get 20
        assertEquals(20, result);
    }

    @Test
    public void testCalcOver21WithAce() {
        // Given I have values 4, 8, 11
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(8);
        values.add(11);

        // When I calculate the score
        ICalculateScore calculateScore = new CalculateScore();
        int result = calculateScore.calculate(values);

        // Then I get 13
        assertEquals(13, result);
    }

    @Test
    public void testCalcOver21WithTwoAce() {
        // Given I have values 4, 11, 11
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(11);
        values.add(11);

        // When I calculate the score
        ICalculateScore calculateScore = new CalculateScore();
        int result = calculateScore.calculate(values);

        // Then I get 16
        assertEquals(16, result);
    }

    @Test
    public void testCalcOver21WithTwoAce2() {
        // Given I have values 4, 10, 11, 11
        List<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(10);
        values.add(11);
        values.add(11);

        // When I calculate the score
        ICalculateScore calculateScore = new CalculateScore();
        int result = calculateScore.calculate(values);

        // Then I get 16
        assertEquals(16, result);
    }
}
