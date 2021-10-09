# BlackJack

- Given: I have a 10 and a 11
- When: I check for natural
- Then: should return true

- Given: I have a 9 and a 10
- When: I check for natural
- Then: should return false

### Generate random numbers

- Given: I generated four 6's
- And: I generate another 6
- When: I validate the number
- Then: I should back false

- Given: I ask for a card 
- When: I draw the card
- Then: should return a random number between 1 through 13

### Cards Conversion

- Given: I have the number 1
- When: I convert it to a card
- Then: I should get back an Ace

- Given: I have the number 11
- When: I convert it to a car
- Then: I should get back a Jack

### Calculate the card value

- Given: I have a 12
- When: I get the value
- Then: I get 10

### Calculate the hands Score

- Given: I have a 5 and 10
- When: I calculate the score
- Then: I get a value of 15

- Given: I have an 8 a 10 and a 11
- When: I calculate the score
- Then: I get back 19

### Calculate Winner

- Given: I have a 18
- And: the dealer has 19
- When: I determine the winner
- Then: The dealer win

- Given: I have a 19
- And: the dealer has a 18
- When: I determine the winner
- Then: I win

- Given: I have a 18
- And: the dealer has a 18
- When: I determine the winner
- Then: It's a draw




