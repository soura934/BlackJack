package com.saggezza.blackjack;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValueTest {
    @Test
    public void Test1(){
      //  Given: I have a 12

        int n=12;
        //int v=10;
        //- When: I get the value
        ICardValue number=new Cardvalue();
        int result=number.Compare("King of Spades");
        // - Then: I get 10
        assertEquals(10,result);

    }
}
