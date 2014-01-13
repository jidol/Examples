/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */
package BlackJack;

/**
 * Player Object for BlackJack using a shared
 * Deck object and basic hitting logic and
 * score.
 */
public class Player
{
	/**
 	 * First card
	 */
	protected int _cardOne = Deck.INVALID_CARD;

	/**
 	 * Second card
	 */
	protected int _cardTwo = Deck.INVALID_CARD;

	/**
	 * Player number
 	 */
	protected int _number = -1;

	/**
	 * Deck being used
	 */
	protected Deck _source = null;

	/**
 	 * Constructor for Player object for Blackjack
	 * @param input Deck all players are using
	 * @param number Indentifing number for player
	 */
	public Player(Deck input, int number)
	{
		_source = input;
		_number = number;
		draw();
	}

	/**
	 * Draw new cards
	 */
	public void draw()
	{
		_cardOne = _source.pullCard();
		_cardTwo = _source.pullCard();
	}

	/**
	 * Get player number
	 * @return Player number
	 */
	public int number()
	{
		return _number;
	}

	/**
	 * Attempt hit if needed
	 */
	public void hit()
	{
		int cScore = score();
		if(21 != cScore && 18 <= cScore)
		{
			if(_cardOne < _cardTwo) 
				_cardOne = _source.pullCard();
			else
				_cardTwo = _source.pullCard();
		}
	}

	/**
	 * Get Score
	 * @return int value of score
	 */
	public int score()
	{
		return _cardOne + _cardTwo;
	}
}
