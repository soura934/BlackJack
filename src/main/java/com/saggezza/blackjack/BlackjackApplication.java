package com.saggezza.blackjack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		List<String> playerCards = new ArrayList<>();
		List<String> dealerCards = new ArrayList<>();

		IBlackJackFlow blackJackFlow = ctx.getBean(BlackJackFlow.class);
		blackJackFlow.playGame(playerCards, dealerCards);
	}

}
