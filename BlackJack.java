package blackjack;




//import java.util.Locale;
import java.util.Scanner;

public class BlackJack {

   static GUI gui = new GUI();

    static Scanner input = new Scanner(System.in);
static Game game=new Game(); // intial round 



    //variable used in turn fn
static  String choice;
   static int turn=0;


    //variable used in turn fn



    public static void Turns() {

        System.out.println("Turn of player "+game.players[turn].getName() +" and your score "+game.players[turn].getScore());
        do {

            if (turn == 3) //Dealer turn
            {
                DealerTurn();
                break;
            }
            if (game.players[turn].getScore() > 21) {
                System.out.println("pusted");
                game.players[turn].setLost(true);
                turn++;
                Turns();
            } else {

                System.out.println(" Please Enter  \"STAND\" OR \"HIT\" ");
                choice = input.next();
                choice = choice.toUpperCase(); // Stand or hit
                if (choice.equals("HIT")) {
                    game.players[turn].CardCollection(game.PopCard()); //give it a card
                    gui.updatePlayerHand(game.players[turn].myCard[(game.players[turn].getIndexCard()-1)], turn);  //get card index from player and -1 to get last card that is add



                    System.out.println("your score now is "+game.players[turn].getScore());
                    if (game.players[turn].getIndexCard() > 10) {   //avoid mycard array become out of boundry
                        System.out.println("BUSTED");
                        turn++;
                        Turns();

                    } //each player has number of cards max 11
                    if (game.players[turn].istLost()) {   //if player have Score bigger than 21 is busted
                        System.out.println("BUSTED");
                        turn++;
                        Turns();
                    }

                } else if (choice.equals("STAND")) {
                    turn++;
                    Turns();
                } else
                    System.out.println("Invalid option , please input \"STAND\" OR \"HIT\" ");

            }
        } while (true); //condition is handled inside


    }

 public static void DealerTurn(){
        game.MaxScore(); //calculate max score for three players
     /*if(game.TestTie()){
         game.Tie=true; //finish game
     }*/ //wrong assumption

  if(game.maxScore==21){
    while ( game.players[3].getScore()<=21 ){
        if (game.players[3].getIndexCard() > 10) {
            break;
        }
        game.players[3].CardCollection(game.PopCard()); //give it a card
        gui.updateDealerHand(game.players[3].myCard[(game.players[3].getIndexCard()-1)] , game.cards);
        
    }
    if(game.players[3].getScore()==21){
        game.Tie=true;
    } // a player and dealer both has Bj so the game is tie
 } //Bsuted cases // this statment isn't reached if and only if it is not tie
    else {
     while (game.players[3].getScore()<= game.maxScore ||  game.players[3].getScore()<=21 ){
         if (game.players[3].getIndexCard() > 10) {
             break;
         } //hit more than 11 card
         game.players[3].CardCollection(game.PopCard()); //give it a card
         gui.updateDealerHand(game.players[3].myCard[(game.players[3].getIndexCard()-1)] , game.cards);

     }
     if(game.players[3].getScore()> game.maxScore && (game.players[3].getScore()<=21)){
         game.players[3].setWinner(true);
     } // if dealer has max score his the winner
 } //Busted cases



     /*if(game.players[3].getScore()> game.maxScore &&  !game.players[3].istLost())   //test that dealer has max score and not max 21
     {
         game.players[3].setWinner(true) ;
     }
     else {
         do{
             game.players[3].CardCollection(game.PopCard()); //give it a card
             if( (game.players[3].getScore()> game.maxScore && !game.players[3].istLost()) || game.players[3].isGetBlackJack()){
                 break;
             }
             else if(game.players[3].istLost()){
                 break;
             }
         }while();
     }*/

        }


    public static void main(String[] args) {
        
      
	// write your code here
//int highScore=0;
   for (int id = 0; id< 3; id++) {
            game.IntialDeal(input.next(),id);
        } 
        
        gui.runGUI( game.cards, game.players[0].myCard ,  game.players[1].myCard,  game.players[2].myCard,  game.players[3].myCard );
  Turns(); //start Game
      if(game.TestTie()){
          System.out.println("Tie");
      }   // if tie
     else if(game.players[3].isWinner()){
         System.out.println("Dealer is the winner ");
         if(game.players[3].isGetBlackJack()){
             System.out.println("winner by get Black Jack ");
         }
         
     } //if dealer win

      else if(game.allLost()){
          System.out.println("No winner");
      } //no winner
    else {
          for (int i = 0; i < 4; i++) {
              if (game.players[i].isWinner()) {
                              System.out.println("The winner is : " + game.players[i].getName());
                                  if (game.players[i].isGetBlackJack()) {
                                            System.out.println("winner by get Black Jack ");
                                                                             }
                                  else {
                                      System.out.println("win by score " + game.players[i].getScore());
                                      break;
                                  }
              }
              else
                  System.out.println("couldn't determine the winner");
          }

      }

    // if a player is the winner

// who is the winner




for (int i=0 ;i<4 ;i++){
    System.out.println("player "+game.players[i].getName()+"   score "+ game.players[i].getScore());
}


    }
}
