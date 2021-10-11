package com.saggezza.blackjack;

public class Natural implements INatural {

    public boolean validate(int natural) {
        if (natural == 10 && natural == 11) {
            return true;
        } else {
            return false;
        } }}




