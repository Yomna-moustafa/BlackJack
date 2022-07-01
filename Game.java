package blackjack;
import java.util.Random;

public class Game {
    public  Player[] players=new Player[4];
    public  Card[] cards=new Card[52];
    boolean Tie=false;
    public int maxScore=0;
    public Game(){
        int  index=0;
        int val;   // for value
        for (int j=0 ; j<4 ;j++) {  //for suit
            val = 0;

            for (int k = 0; k < 13; k++) { //for Rank
                index++; //index
                val++;

                if (val > 10) {
                    val = 10;
                } // to make value of images equal 10;
                cards[index-1]= new Card(val,j,k);


            }
        }
        for(int i=0 ;i<4;i++){

            players[i]=new Player();

            players[i].CardCollection(PopCard());
            players[i].CardCollection(PopCard());  //give each player two cards


          /*System.out.println(players[i].myCard[0].getValue());
      System.out.println(players[i].myCard[1].getValue());*/ //debuging



        }

    }
    public int Generate(){
        Random rand=new Random();
        int drawn= rand.nextInt(52);
        while (cards[drawn]==null){
            drawn= rand.nextInt(52);
        }
        return drawn;

    }

    public Card taken(int i){

        Card card=cards[i];
        cards[i]=null;
        return card;
    } //take index of generated card and pass it to obj from Card and return this obj and make cards with that index =0
    public Card PopCard(){
        Card card= taken(Generate()); //remove card from cards by give it to taken fn  and give it to popcard fn to return it to player hand
        return card ;

    } //give a card*/
    void IntialDeal(String name, int index){
        players[index].setName(name);
        players[3].setName("Dealer");
    }// give name for four players


    //take array of my card and index of player

public boolean TestTie() //if two players has BJ then game is tie regardless dealer score
{


    for(int i=0 ;i<3 ;i++){
        if(players[i].isGetBlackJack()){
            for(int j=0 ; j<3 ;j++){
                if(j==i){
                    continue;
                }
                else
                {
                    if(players[j].isGetBlackJack()){
                        Tie=true;

                    }
                }
            }
        }
       /* if(players[index].getScore()==players[i].getScore()){ //index for player that have maxScore compare it with all other player include dealer to cheack no one has same score;
            Tie=true;
        }*/

    }  // if two player has black jack the result is tie regardless dealer Score
    return Tie;

}
    public void MaxScore(){
        boolean foundBJ=false;
        for(int i=0 ;i<3 ;i++){
            if(players[i].isGetBlackJack()){
                maxScore=players[i].getScore(); //max score 21
                players[i].setWinner(true); // make this player winner
                foundBJ=true; //avoid serch for max Score

                break;
            }
        } //test if any of player has a blackJack and assigned it as winner
      if(!foundBJ) //if not found BlackJack
     {
         if(!players[0].istLost()){
maxScore=players[0].getScore();
         } // assume max score is first player score after check his score doesn't exceed 21
        for(int i=1 ;i<3 ;i++){
    if(players[i].getScore()>maxScore && !players[i].istLost())
    maxScore=players[i].getScore();
            players[i].setWinner(true);
        }

}

    } //calc max score for three players

    public boolean DealerStatus(){
        if(players[3].istLost()){
            return false;
        }
        else if( (players[3].getScore() > maxScore || players[3].isGetBlackJack())  )
        {
            return true;
        }
        else
            return false;
    }

    public boolean allLost(){
        boolean Alllost=true;
        for (int i=0 ;i<4 ;i++){
            if(players[i].isWinner()){
                Alllost=false;
            }
        }
        return Alllost;
 }


}

    

