package com.saggezza.blackjack;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculateBetTest {
    @Test
    public void Test(){
     //Given I bet $10
        double money =100;
       int bet=10;
       //when I win the game by natural
        ICalculateBet caluculateBet=new CalculateBet();
        double result=caluculateBet.calculate(money,bet,"natural");

        //Then I win $25
        assertEquals(115,result);
    }

    @Test
    public void Test2(){
        //Given I bet $10
        double money =100;
        int bet=10;
        //when I win the game without natural
        ICalculateBet caluculateBet=new CalculateBet();
        double result=caluculateBet.calculate(money,bet,"win");

        //Then I win 20
        assertEquals(110,result);
    }

    @Test
    public void Test3(){
        //Given I bet $10
        double money =100;
        int bet=10;
        //when I win the game by natural
        ICalculateBet caluculateBet=new CalculateBet();
        double result=caluculateBet.calculate(money,bet,"loose");

        //Then I loose $10
        assertEquals(90,result);
    }


    @Test
    public void Test4(){
        //Given I bet $10
        double money =100;
        int bet=10;
        //when I win the game by natural
        ICalculateBet caluculateBet=new CalculateBet();
        double result=caluculateBet.calculate(money,bet,"tie");

        //Then I get back my betting money
        assertEquals(100,result);
    }
}
