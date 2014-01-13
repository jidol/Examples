/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

package Example;
import java.math.BigInteger;

/**
 * Create X number of Fibonacci values
 * When X > 20 then done using iteration otherwise
 * recursion is used.
 * 
 */
public class Fibonacci 
{
	/**
	 * Generate X Fibonacci using recursion up to 20
         * larger requests use iteration
	 */
	public static void main(String[] args)
	{
		if(0 < args.length)
     		{
			try
			{
				int input = Integer.parseInt(args[0]);
				BigInteger result = null;

				// Don't use recursion on larger numbers
				if(20 <= input)
				{
					for(int i=1; i < input; ++i)
					{
						result = fibonacci(i);
						if(null != result)
							{
							System.out.println(" ============== ");
							System.out.println(i + 
								" Fibonacci number:  " + result);
						}
						result = null;
					}
				}
				else
				{
					System.out.println("Recursive call:");
					for(int i=1; i < input; ++i)
					{
						result = Fibonacci.recursiveFibonacci(i);
						if(null != result)
						{
							System.out.println(" ============== ");
							System.out.println(i + 
								" Fibonacci number:  " + result);
						}
						result = null; 
					}
				}
			}
			catch(NumberFormatException ex)
			{
				System.out.println("Must enter numbers");
				System.out.println("Invalid:  args[0]");
			}
		}
	}

	/**
	 * Recursive function to generate factorial
	 * @param value Value to calculate factorial
	 * @return Fibonacci of value
	 */
	public static BigInteger recursiveFibonacci(int value)
	{
		// Bad Case
		if(0 == value)
			return BigInteger.ZERO;

		// Completed recursion
		if(1 == value || 2 == value)
			return BigInteger.ONE;

		return Fibonacci.recursiveFibonacci(value - 1).add( 
			Fibonacci.recursiveFibonacci(value - 2));
	}

	/**
	 * Iterative function to generate factorial
	 * @param value Value to calculate factorial
	 * @return Fibonacci of value
	 */
	public static BigInteger fibonacci(int value)
	{
		BigInteger result = BigInteger.ONE;
		if(0 == value)
		{
			result = BigInteger.ZERO;
		}
		else if(1 != value &&  2 != value)
		{
			BigInteger partOne = result;
			BigInteger partTwo = result;
			for(int i=3; i <= value; ++i)
			{
				result = partOne.add(partTwo);
				partOne = partTwo;
				partTwo = result;
			}
		}
		return result;
	}
}
