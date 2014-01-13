/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

package Example;

import java.util.Scanner;

/** 
 * Abstract class to extract integer values
 * from an array of strings.
 */
public abstract class Process
{
	/**
	 * Basic check of all integers within the arguments
	 * @param args
	 *   Array of strings to check
	 */
	public void doCheck(String[] args)
	{
		for(String value:args)
		{
			Scanner s = new Scanner(value);

			while(s.hasNextInt())
			{
 				int compareValue = s.nextInt();
				check(compareValue);
			}
			s = null;
		}
	}

	/**
	 * Function to be overriden by child classes
	 * @param value Value to check
	 */
	abstract void check(int value);
}
