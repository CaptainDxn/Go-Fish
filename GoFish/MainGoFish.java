import java.util.ArrayList; 
import java.util.Random;


public class MainGoFish
{
    static public Player[] Players;
    static final Random rng = new Random();
    static private ArrayList<Card> cards;
    
 
    public static Card draw()
	{
        return cards.remove(rng.nextInt(cards.size()));
        
	}
 
	public static int deckSize()
	{
        return cards.size();
        
    }
 
    public static void main(String[] args)
    {
 
        cards = new ArrayList<Card>();
        for(int i=0;i<4;i++)
            for(Card c: Card.values())
                cards.add(c);
        Player p0 = new PlayerOne();
        Player p1 = new PlayerTwo();

        // Player ai = new AIPlayer();
        Players = new Player[] {p0, p1};
 
        while(Players[0].getNumSets() + Players[1].getNumSets() < 13)
        {
            Players[0].haveTurn();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            Players[1].haveTurnTwo();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }
 
        int playerOneScore = Players[0].getNumSets(); int playerTwoScore = Players[1].getNumSets();
        if (playerOneScore > playerTwoScore)
            System.out.println("Congratulations, Player 1 win "+ playerOneScore + " to "+ playerTwoScore +"!");
        else if (playerTwoScore > playerOneScore)
            System.out.println("Congratulations, Player 2 win "+ playerTwoScore + " to "+ playerOneScore +"!");
        else
            System.out.println("It's a tie at "+playerOneScore+" each!");
    }
}

enum Card 
{
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}


