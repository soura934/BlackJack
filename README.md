# BlackJack

## Small Objects

### Generate Random Number (Card) (Priyanka)

(Need the object, but not a test)
- Given: I ask for a card
- When: I draw the card
- Then: should return a random number between 1 through 13

### Naturals (Ramsha)

- Given: I have a 10 and a 11
- When: I check for natural
- Then: should return true


- Given: I have a 9 and a 10
- When: I check for natural
- Then: should return false


### Validating Random Number

- Given: I generated four 6's
- And: I generate another 6
- When: I validate the number
- Then: I should back false


### Cards Conversion (Mansour)

- Given: I have the number 1
- When: I convert it to a card
- Then: I should get back an Ace


- Given: I have the number 11
- When: I convert it to a car
- Then: I should get back a Jack

### Calculate the card value (Priyanka)

- Given: I have a 12
- When: I get the value
- Then: I get 10

### Calculate the hands Score (Chuck)

- Given: I have a 5 and 10
- When: I calculate the score
- Then: I get a value of 15


- Given: I have an 8 a 10 and a 11
- When: I calculate the score
- Then: I get back 19


## Flow Classes

- Given: I am the user
- When: The game is started
- Then: The dealer is given a card, then player, then dealer face down, then player


- Given: The player is dealt 8 and 9, the dealer is dealt a 10 and 7
- When: We check for Naturals
- Then: We call the checkNatural function twice


- Given: The player has been given numbers
- When: We display the cards
- Then: The numbers are converted to cards and displayed to user


- Given: The player has a value of 10 with cards 4 and 6
- When: the user is playing the game
- Then: The player is asked to hit or stand once


- Given: The player has a value of 21 with cards, 10, 5, 6
- When: the user playing the game
- Then: the player is not asked to hit or stand

- Given: The player has a value of 22 with cards, 10, 5, 7
- When: the user playing the game
- Then: the player is not asked to hit or stand


- Given: The player has a value of 18 with cards, 5, 6, 2, 5
- When: the user playing the game
- Then: the player is asked to hit or stand once


- Given: The player has a value of 18 with 5 cards, 3, 4, 2, 5, 4
- When: the user playing the game
- Then: the player is not asked to hit or stand


- Given: The player has stood with 18 with a 10 and 8
- And: the dealer has 14 with 6 and 8
- When: we determine if dealer draws
- Then: The dealer draws one card


- Given: The player has stood with 18 with a 10 and 8
- And: the dealer has 19 with ace and 8
- When: we determine if dealer draws
- Then: The dealer does not draw a card


- Given: The player has stood with 18 with a 10 and 8
- And: the dealer has 16 with 2, 3, 4, 3, 4
- When: we determine if dealer draws
- Then: The dealer does not draw a card

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