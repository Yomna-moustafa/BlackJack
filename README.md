# Game description:
It's a simplified version of the popular card game Blackjack (without bets).

At the beginning of the game, the 3 players and the dealer are dealt 2 cards each. We see both players&#39;

cards but see only 1 of the dealer&#39;s cards. The aim of the game is to have the sum of the card values

(score) in your hand be 21 ( **BLACKJACK** ), or as close to 21 as possible. However, you lose if y ou go

over 21.

The players go first in turns and have two choices: Hit or Stand. **HIT** means the player wants to pick

another card. You make this move to increase your score. **STAND** means that the player is done picking

new cards (i.e. Hitting) and their turn ends. You do this move when you are comfortable with your score

(e.g. score=19 is very close to 21, picking another card could make you lose the game by going over 21

(Player **BUSTED** ).

When the player&#39;s turn ends, the next player starts to play in turns. If the maximum score of all players is

less than the value of the two cards of the dealer&#39;s then the dealer will win the game and doesn&#39;t need to

hit more cards. Other than that, then the dealer starts hitting until he either scores 21, scores a score bigger

than all of the other players or go over 21 (Dealer **BUSTED** ).

Finally, if more than one player have the same high score then it&#39;s a tie situation ( **PUSH** ) , but if only a

single player had the maximum score then that player **WINs** the game

The strategy is to increase your score by hitting to get close to 21 (but not over), while also taking into

consideration what the dealer&#39;s score could be.

## Game Main components:

1. Deck creation &amp; initial card draw.

a. Create deck

b. Do the initial card draw for the player and the dealer (a total of 4 cards)

c. Remove drawn cards from the deck

2. Player&#39;s turn (repeated 3 times for the 3 players)

a. Hit or Stand

b. Update the player&#39;s score.

3. Dealer&#39;s turn

a. Hit until he either scores 21 ( **BLACKJACK** ), a score more than the maximum score of the 3 players

or bust.

4. Make decisions(someone **WINS** or it&#39;s a **PUSH** ) and end the game.
