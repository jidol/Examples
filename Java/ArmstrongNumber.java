import java.util.LinkedList;

public class ArmstrongNumber extends Process
{
	/**
	 * Check to see if the integers passed in are
	 * Sum of the digits cubes equal the original number
	 */
	public static void main(String[] args)
	{
		ArmstrongNumber checker = new ArmstrongNumber();
		checker.doCheck(args);

		checker = null;
	}

	/**
	 * Basic constructor
	 */
        public ArmstrongNumber()
	{
	}

	/**
	 * Implement abstract function from base class.  Will check for armstrong numbers
	 * @param value  Value to check
	 */
	protected void check(int value)
	{
		if(100 < value && 999 >= value)
		{
			LinkedList<Integer> digits = ParseInt.parseIntoDigits(value);
			if(value == armstrong(digits))
				System.out.println("Value is an armstrong number:  " + value);
			else
				System.out.println("Value is NOT an armstrong number:  " + value);
		}
		else
		{
			System.out.println("Value is out of range for an Armstrong number, must be 3 digits");
		}
	}

	/**
	 * Take the 3 integers and get their cube and sum the values.
	 * @param data Three integer values
	 * @return Three integer values cubed and summed, -1 if invalid
	 */
	private int armstrong(LinkedList<Integer> data)
	{
		int result = -1;

		// Validate data
		if(null != data && data.size() == 3)
		{
			result = 0;
			for(Integer 		element:data)
				result += Math.pow(element.intValue(),3);
		}
		return result;
	}
}