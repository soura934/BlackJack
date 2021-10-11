package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaturalsTest {

    @Test
    public void checkNaturalOne() {
        //Given we have angle of 10

        INatural obj1 = new Natural();
        //When: I check for natural
        boolean resolvedEquals = obj1.validate(10);

        // Then it should return true
        assertTrue(resolvedEquals);
    }

    @Test
    public void checkNaturalTwo() {
        //Given we have angle of 11

        INatural obj2 = new Natural();
        //When: I check for natural
        boolean resolvedEqualsOne = obj2.validate(11);

        // Then it should return true
        assertTrue(resolvedEqualsOne);

    }

    @Test
    public void checkNaturalThree() {
        //Given we have angle of 9

        INatural obj3 = new Natural();
        //When: I check for natural
        boolean resolvedEqualsTwo = obj3.validate(9);

        // Then it should return false
        assertFalse(resolvedEqualsTwo);

    }}



