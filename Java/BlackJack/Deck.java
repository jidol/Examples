/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

package BlackJack;
import java.util.Random;

/**
 * Deck of cards for BlackJack
 */
public class Deck
{
	/**
	 * Number of cards in the deck
	 */
	final public static int DECK_SIZE = 52;

	/**
	 * Invalid card for card pulled from deck
	 */
	final public static int INVALID_CARD = -1;

	/**
	 * Storage of cards
	 */
	private int[] _cards = null;

	/**
	 * Create a basic deck
	 */
	public Deck()
	{
		populate();
	}

	/**
	 * Pull a new card
	 * @return Card with value of 1 - 11;
	 */
	public int pullCard()
	{
		Random r = new Random();
		int card = INVALID_CARD;
		while(INVALID_CARD == card)
		{
			int pos = r.nextInt() % DECK_SIZE;
			while(0 > pos) pos = r.nextInt() % DECK_SIZE;
			card = _cards[pos];
		}
		r = null;
		return card;
	}

	/**
	 * Populate the deck
	 */
	protected void populate()
	{
		_cards = new int[DECK_SIZE];
		int card = 1;
		boolean stop = false;
		for(int i=1; i < DECK_SIZE + 1; ++i)
		{
			if(i % 4 == 0 && stop == false)
			{
				if(11 != card)
				{
					++card;
				}
				else
				{
					card = 10;
					stop = true;
				}
			}
			_cards[i-1] = card;
		}
	}
}
