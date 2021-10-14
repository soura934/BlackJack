package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCountValidationTest {

    @Test
    public void validInputNumberTest(){
//        Given: the user wants 4 player

//        When: we validate the number
        IPlayerCountValidation playerCountValidation = new PlayerCountValidation();
        boolean result = playerCountValidation.validate(4);
//        Then: we return true
        assertTrue(result);

    }

    @Test
    public void invalidInputNumberTest(){
//        Given: the user wants 6 player

//        When: we validate the number
        IPlayerCountValidation playerCountValidation = new PlayerCountValidation();
        boolean result = playerCountValidation.validate(6);
//        Then: we return false
        assertFalse(result);

    }

    @Test
    public void invalidInputNumberTest2(){
//        Given: the user wants 0 player

//        When: we validate the number
        IPlayerCountValidation playerCountValidation = new PlayerCountValidation();
        boolean result = playerCountValidation.validate(0);
//        Then: we return false
        assertFalse(result);

    }
}
