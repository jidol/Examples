import java.util.Scanner;

public class OddEven extends Process
{
	public static void main(String[] args)
	{
		OddEven checker = new OddEven();
		checker.doCheck(args);

		System.out.println("=============");
		checker = new OddEven(true);
		checker.doCheck(args);

		checker = null;
	}

        

	/**
	 * When true a bit compare will be used
	 * to determine even/odd
	 */
        private boolean useBitCheck = false;

	/**
	 * Basic constructor that switches between
	 * using a bit shift check, which only works
	 * with integers, but this example will only
	 * use integers at this time.
	 * @param useBitCheck 
	 *   Defaults to false, when true bit shift used instead of modulous
	 */
        public OddEven(boolean useBitCheck)
	{
		this.useBitCheck = useBitCheck;
	}

	/**
	 * Basic constructor that defaults to modulus check
	 */
        public OddEven()
	{
		useBitCheck = false;
	}

	protected void check(int value)
	{
		if(isValueEven(value))
			System.out.println("Even:  " + value);
		else
			System.out.println(" Odd:  " + value);
	}

        /**
         * Check even odd
         * @param value Value to chekc
	 * @return True if even otherwise false
	 */
	protected boolean isValueEven(int value)
	{
		return useBitCheck == true ? 
			isBitEven(value) : isModEven(value);
	}

	/**
	 * Modulus check
	 * @param value
	 *    Value to check for odd and even
	 * @return True if even, otherwise false
	 */
	private boolean isModEven(int value)
	{
		return value % 2 == 0 ? true : false;
	}

	/**
	 * Bit check
	 * @param value
	 *    Value to check for odd and even
	 * @return True if even, otherwise false
	 */
	private boolean isBitEven(int value)
	{
		return (value & 1) == 0 ? true : false;
	}
}
