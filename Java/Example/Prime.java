/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

package Example;

/**
 * Basic prime number identifiction. Will not confirm
 * the value is a prime, only that it is likely a prime.
 */
public class Prime extends OddEven
{
	/**
	 * Check if the values passed in are prime
	 */
	public static void main(String[] args)
	{
		Prime checker = new Prime();

		checker.doCheck(args);

		checker = null;
	}

	/**
	 * Basic constructor passing on true to OddEven to use bit check
	 */
        public Prime()
	{
		super(true);
	}

	/**
	 * Override base class to do the check we need.
	 * In this case we are doing an override as the base class does implement
	 * the Process abstract version.
	 */
	protected void check(int value)
	{
		// Check basic is even
		if(isValueEven(value))
		{
			System.out.println("Value is even so cannot be prime:  " + value);
		}
		// Check basic divide by 3 or sum of parts is divisible by 3
		else if(isDivisibleByThree(value) ||
		 isDivisibleByThree(sumParts(value)))
		{
			System.out.println("Value is divisible by three so cannot be prime:  " + value);
		}
		// Check if sum of last two characters are divisible by 4
		else if(isDivisibleByFour(sumLastTwo(value)))
		{
			System.out.println("Last two numbers sum is divisible by 4 so cannot be prime:  " + value);
		}
		// This was not an exhaustive test, but will detect most basic values
		else
		{
			System.out.println("Value might be prime:  " + value);
		}
	}

	/**
	 * Return the sum of the last two numbers in this value
	 * Example 1234, add 3 and 4 and return 7
	 * @param value Integer to add
	 * @return Sum of the last two digits
	 */
	private int sumLastTwo(int value)
	{
		int result = 0;
		String full = Integer.toString(value);
		String area = full;
		if(full.length() >= 3)
			area = full.substring(full.length() - 3);
		result = sumParts(Integer.parseInt(area));
		return result;
	}

	/**
	 * Return the sum of the digits that make up the value
	 * @param value Integer to add up the digits
	 * @return Sum of the digits in the value
	 */
	private int sumParts(int value)
	{
		int result = 0;
		for(Integer i: ParseInt.parseIntoDigits(value))
			result += i.intValue();
		return result;
	}

	/**
	 * Check to see if the value is divisible by three.
	 * @param value Integer to check
	 * @return True if it is divisible by three
	 */
	private boolean isDivisibleByThree(int value)
	{
		return value % 3 == 0 ? true : false;
	}

	/**
	 * Check to see if the value is divisible by four.
	 * @param value Integer to check
	 * @return True if it is divisible by four
	 */
	private boolean isDivisibleByFour(int value)
	{
		return value % 4 == 0 ? true : false;
	}
}
