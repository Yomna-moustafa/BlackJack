package blackjack;

public class Player {
    private String Name;
    private int Score=0;
    public Card[] myCard= new Card[11];
    private boolean GetBlackJack=false;
    private  boolean lost=false;
    private boolean MaxScore=false;
    private int indexCard=0;
    private boolean Winner=false;

    public Player(){

    }
    public void CalcScore(int cardValue){
        //System.out.println("int card vaule "+);
        Score+=cardValue;

    }
    /*public void myCards(Card mycards){
        this.myCard=myCard;
        indexCard++;
    }*/









    //addCard
    public void CardCollection(Card card)
    {
        //System.out.println("we recive card  with value"+ card.getValue());
        myCard[indexCard]=card;

        CalcScore(myCard[indexCard].getValue()); //give value of card
        //System.out.println("after add this card value of score "+ Score);
        indexCard++;
    }
// addCard









    //setters
    public void setGetBlackJack(boolean getBlackJack) {
        this.GetBlackJack = getBlackJack;
    }
    public void setName(String Name){
        this.Name=Name;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public void setMaxScore(boolean maxScore) {
        this.MaxScore = maxScore;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void setWinner(boolean winner) {
        Winner = winner;
    }
//setters




    //getters
    public String getName(){
        return Name;
    }

    public int getScore() {
        return Score;
    }
    public boolean istLost(){
        return lost;
    }

    public boolean isGetBlackJack() {
        return GetBlackJack;
    }

    public boolean isMaxScore() {
        return MaxScore;
    }
    public int getIndexCard(){
        return indexCard;
    }

    public boolean isWinner() {
        return Winner;
    }

    public Card[] getMyCard() {
        return myCard;
    }

    // getters






}