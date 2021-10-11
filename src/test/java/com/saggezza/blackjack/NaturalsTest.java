package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaturalsTest {

    @Test
    public void checkNaturalOne() {
        //Given we have natural of 10 and 11

        INatural obj1 = new Natural();
        //When: I check for natural
        boolean resolvedEqualsOne = obj1.validate(10,11);

        // Then it should return true
        assertTrue(resolvedEqualsOne);
    }

    @Test
    public void checkNaturalTwo() {
        //Given we have natural of 11 and 10

        INatural obj2 = new Natural();
        //When: I check for natural
        boolean resolvedEqualsTwo = obj2.validate(11,10);

        // Then it should return true
        assertTrue(resolvedEqualsTwo);

    }

    @Test
    public void checkNaturalThree() {
        //Given we have angle of 9 and 10

        INatural obj3 = new Natural();
        //When: I check for natural
        boolean resolvedEqualsThree = obj3.validate(9,10);

        // Then it should return false
        assertFalse(resolvedEqualsThree);

    }}



