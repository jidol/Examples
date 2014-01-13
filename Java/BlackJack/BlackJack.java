package BlackJack;
import java.lang.NumberFormatException;

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
			if(1 == args.length)
			{
				BlackJack.play(Integer.valueOf(args[0]));
			}
			else
			{
				BlackJack.printUsage();
			}
		}
		catch(NumberFormatException e)
		{
			BlackJack.printUsage();
		}
	}

	/**
	 * Print Usage for Blackjack game
	 */
	public static void printUsage()
	{
		System.out.println("BlackJack <# of players>");
	}

	/**
	 * Play the game
	 * @param numberOfPlayers Number of players for the game
	 */
	public static void play(int numberOfPlayers)
	{
		System.out.println("Number of players = " + numberOfPlayers);
	}
}
