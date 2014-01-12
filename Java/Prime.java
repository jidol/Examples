import java.util.Scanner;

public class Prime extends OddEven
{
	public static void main(String[] args)
	{
		Prime checker = new Prime();

		checker.doCheck(args);

		checker = null;
	}

        public Prime()
	{
		super(true);
	}

	protected void check(int value)
	{
		if(isValueEven(value))
		{
			System.out.println("Value is even so cannot be prime:  " + value);
		}
		else if(isDivisibleByThree(value) ||
		 isDivisibleByThree(sumParts(value)))
		{
			System.out.println("Value is divisible by three so cannot be prime:  " + value);
		}
		else if(isDivisibleByFour(sumLastTwo(value)))
		{
			System.out.println("Last two numbers sum is divisible by 4 so cannot be prime:  " + value);
		}
		else
		{
			System.out.println("Value might be prime:  " + value);
		}
	}

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

	private int sumParts(int value)
	{
		int result = 0;
		for(Integer i: ParseInt.parseIntToParts(value))
			result += i.intValue();
		return result;
	}

	private boolean isDivisibleByThree(int value)
	{
		return value % 3 == 0 ? true : false;
	}

	private boolean isDivisibleByFour(int value)
	{
		return value % 4 == 0 ? true : false;
	}
}
