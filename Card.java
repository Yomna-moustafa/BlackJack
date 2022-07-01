package blackjack;
public class Card {
    private final  int suit;
    private final  int rank;
    private  final int value;


    public Card(int value, int suit,int rank){
        this.rank=rank;
        this.suit=suit;
        this.value=value;
    }
    public Card(Card card){

        this.rank= card.rank;
        this.suit= card.suit;
        this.value=card.value;
    }




    public int getRank() {
        return rank;
    }
    public int getValue(){
        return value;
    }
    public int getSuit(){
        return suit;
    }


}
