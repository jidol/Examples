import java.util.Scanner;

public class OddEven
{
	public static void main(String[] args)
	{
		for(String value:args)
		{
			Scanner s = new Scanner(value);

			while(s.hasNextInt())
			{
 				int compareValue = s.nextInt();
				if(compareValue % 2 == 0)
					System.out.println("Even:  " + compareValue);
				else
					System.out.println("Odd:  " + compareValue);
			}
			s = null;
		}
	}
}
