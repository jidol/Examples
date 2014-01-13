/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */
package BlackJack;
import java.lang.NumberFormatException;
import java.util.LinkedList;

/**
 * Basic game of Blackjack
 */
public class BlackJack
{
	/**
	 * Driver
	 */
	public static void main(String[] args)
	{
		try
		{
			if(2 == args.length)
			{
				BlackJack.play(Integer.valueOf(args[0]), 
					Integer.valueOf(args[1]));
			}
			else
			{
				BlackJack.printUsage();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Bad numbers given");
			BlackJack.printUsage();
		}
	}

	/**
	 * Print Usage for Blackjack game
	 */
	public static void printUsage()
	{
		System.out.println("BlackJack <# of players> <# of hands>");
	}

	/**
	 * Play the game
	 * @param numberOfPlayers Number of players for the game
	 * @param numberOfHands Number of times to play
	 */
	public static void play(int numberOfPlayers, int numberOfHands)
	{
		System.out.println("Number of players = " + numberOfPlayers);
		LinkedList<Player> gamePlayers = new LinkedList<Player>();
		Deck deck = new Deck();

		// Create players
		for(int i=0; i < numberOfPlayers; ++i)
		{
			gamePlayers.add(new Player(deck,i));
		}

		// Loop over number of hands
		for(int hand = 0; hand < numberOfHands; ++hand)
		{
			for(Player p:gamePlayers)
				p.draw();

			for(Player p:gamePlayers)
				p.hit();

			int winner = -1;
			int highScore = -1;
			
			for(Player p:gamePlayers)
			{
				int cScore = p.score();
				if(21 >= cScore && 
					cScore > highScore)
				{
					winner = p.number();
					highScore = cScore;
				}
			}
			// Check for tie
			boolean tie = false;
			for(Player p:gamePlayers)
			{
				// Ignore winning player
				if(winner == p.number())
					continue;

				if(highScore == p.score())
				{
					tie = true;
					break;
				}
			}
			if(-1 == winner)
				System.out.println("No winner");
			else
			{
				if(true == tie)
				{
					for(Player p:gamePlayers)
						if(highScore == p.score())
							System.out.println("Tie player:  " + 
								p.number() + " with score of " + highScore);
				}
				else
					System.out.println("Winner is player:  " + winner + " with score of " + highScore);
			}

			// Always rebuild the deck
			deck.populate();
		}
		gamePlayers = null;
	}
}
