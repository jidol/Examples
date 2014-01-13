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
 * Create Factorial for a given value
 * 
 */
public class Factorial 
{
	/**
	 * Generate Factorial for a given value
	 */
	public static void main(String[] args)
	{
		if(0 < args.length)
     		{
			try
			{
				int input = Integer.parseInt(args[0]);
				int val = Factorial.factorial(input);
				System.out.println(args[0] + "! = " + val);
				val = Factorial.recursiveFactorial(input);
				System.out.println("Recursive:  " + args[0] + "! = " + val);
			}
			catch(NumberFormatException ex)
			{
				System.out.println("Must enter numbers");
				System.out.println("Invalid:  args[0]");
			}
		}
	}

	/**
	 * Generate factoral
 	 * @param value Value to generate factoral
	 * @return factoral
	 */
	public static int factorial(int value)
	{
	   int result = value;
	   for(int i = value -1 ; i > 0; --i)
	   {

		result *= i;
	   }
	   return result;
	}

	/**
	 * Recursive function to generate factorial
	 * @param value Value to calculate factorial
	 * @return Factorial of value
	 */
	public static int recursiveFactorial(int value)
	{
		return 0 < value ? value * Factorial.recursiveFactorial(value - 1) : 1;
	}
}
