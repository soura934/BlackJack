package com.saggezza.blackjack;
//import java.util.stream.Collectors;
//import java.util.stream.Streams;

//import java.lang.constant.Constable;

public class Cardvalue implements ICardValue {
    public int Compare() {
        int[] array1 = {11, 12, 13};
        // int[]array2={10,10,10};
        int value = 10;

       for (int i = 0; i < array1.length; i++) {

           if (array1[i] > value) {
               System.out.println("the value of the card is:" +value);
           }

       }

        return value;
    }
}



