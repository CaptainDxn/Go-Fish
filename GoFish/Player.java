import java.util.ArrayList; 


abstract class Player
{
    protected ArrayList<Card> hand = new ArrayList<Card>();
    private int numSets;
 
    public Player()
    {
        for(int i=0;i<8;i++)
            fish();
    }
 
    public boolean hasGiven(Card cType)
    {
        return hand.contains(cType);
    }
 
    public ArrayList<Card> giveAll(Card cType)
    {
        ArrayList<Card> x = new ArrayList<Card>(); 
        for(int i=0;i<hand.size();i++)            
            if (hand.get(i) == cType)
              x.add(hand.get(i));
        for(int c=0;c<x.size();c++)
            hand.remove(cType);
        return x;
    }
 
    protected boolean askFor(Card cType)
    {
        int tmp = 0;
        if (this instanceof PlayerOne)
            tmp = 1;
        Player other = MainGoFish.Players[tmp];
 
        if (other.hasGiven(cType))
        {
            for(Card c: other.giveAll(cType))
                hand.add(c);
            return true;
        }
        else
        {
            return false;
        }
    }
 
    protected void fish()
	    {
	        if (MainGoFish.deckSize() > 0)
	        	hand.add(MainGoFish.draw());
	        else
	        	System.out.println("But that's impossible since the deck is empty.");
    }
 
    public int getNumSets()
    {
        return numSets;
    }
 
    protected Card checkForSets()
    {
        for(Card c: hand) 
        {
            int num = 0;
            for(Card d: hand)
              if (c == d)
                  num++;
            if (num == 4)
            {
                for(int i=0;i<4;i++)
                    hand.remove(c);
                numSets++;
                return c;
            }
        }
        return null;
 
    }
    public abstract void haveTurn();
    public abstract void haveTurnTwo();
 
}