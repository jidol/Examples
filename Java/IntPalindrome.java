public class IntPalindrome extends Process
{
	/**
	 * Check to see if the integers passed in are
	 * palindrome numbers based on their digits
	 * Example:  1221 is a palindrome 
	 * Exmaple:  1234 is not a palindrome
	 */
	public static void main(String[] args)
	{
		IntPalindrome checker = new IntPalindrome();
		checker.doCheck(args);
		checker = null;
	}

	/**
	 * Basic constructor 
	 */
        public IntPalindrome()
	{
	}

	/**
	 * Implment abstract function from base class.  Will check palindrome
	 * @param value  Value to check
	 */
	protected void check(int value)
	{
		if(isPalindrome(value))
			System.out.println(value +" is a digit based palindrome");
		else
			System.out.println(value +" is NOT a digit based palindrome");
	}

	/**
	 * Check to see if the digits of a value is a palindrome
	 * @param value Value to check
	 * @return True if the digits form a palindrome otherwsie false
	 */
	private boolean isPalindrome(int value)
	{
		boolean result = false;

		// Find out how many digits we have and get the collection
		Integer[] digits = ParseInt.parseDigitArray(value);
		int numDigits = digits.length;

		// Make sure we have something big enough to process
		if(1 < numDigits)
		{
			for(int i=0, j=numDigits-1; i >= 0 && j >= 0; ++i,--j)
			{
				if(false == digits[i].equals(digits[j]))
				{
					result = false;
					break;
				} 
				else
					result = true;
			} 
		}
		// Since we know that 0 and 1 are valid palindromes and we 
		// only have positive numbers then 0 and 1 are palindromes
		else if(0 <= numDigits)
			result = true;

		return result;
	}
}
