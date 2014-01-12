import java.util.Scanner;

public class Process
{
        public Process()
	{
	}

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

	protected void check(int value)
	{
		// No Action
	}
}
