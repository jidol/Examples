import java.util.Scanner;

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
