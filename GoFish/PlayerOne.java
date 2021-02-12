import java.util.Scanner;

class PlayerOne extends Player {
    public void haveTurn() {
        Scanner scnOne = new Scanner(System.in);
        boolean playing = true;
        do {
            Card set = checkForSets();
            if (set != null)
                System.out.println("************************************You got a set of " + set
                        + "'s!************************************");

            if (hand.size() == 0) {
                System.out.print("Your hand is empty, you must ");
                break;
            } else {
                System.out.print("Your hand: ");
                for (Card c : hand)
                    System.out.print(c + " ");
                System.out.println();
            }

            System.out.println("Ask player 2 for what card?");

            Card req;
            try {
                req = Card.valueOf(scnOne.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Card not present in this deck. May have been miss spelled Try again:");
                continue;
            }

            if (!hand.contains(req)) {
                System.out.println("You may not ask for a card you have none of. Please try something else:");
                continue;
            }

            System.out.println("You ask for a " + req);
            playing = askFor(req);
        } while (playing);
        System.out.println("Go fish!");
        fish();
        for (int n = 0; n < 10; ++n)

            for (int i = 0; i < 50; ++i)
                System.out.println();

        int w = 1;
        while (w < 11){
            try {
                Thread.sleep(1000);
                System.out.println("In 10 seconds, switching to player 2: "+w); 
            ++w;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println();
     }
    @Override
    public void haveTurnTwo() {
        // TODO Auto-generated method stub

    }
}

