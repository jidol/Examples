package Example;

/**
 * Check to see if a String is a palindrome.
 */
public class StringPalindrome
{
	/**
	 * Check to see if the integers passed in are
	 * palindrome numbers based on their digits
	 * Example:  abba is a palindrome
	 * Exmaple:  abcd is not a palindrome
	 */
	public static void main(String[] args)
	{
		StringPalindrome checker = new StringPalindrome();
		for(String val:args)
			checker.check(val);
		checker = null;
	}

	/**
	 * Basic constructor 
	 */
        public StringPalindrome()
	{
	}

	/**
	 * Will check palindrome
	 * @param value  Value to check
	 */
	public void check(String value)
	{
		if(isPalindrome(value))
			System.out.println(value +" is a character based palindrome");
		else
			System.out.println(value +" is NOT a character based palindrome");
	}

	/**
	 * Check to see if the digits of a value is a palindrome
	 * @param value Value to check
	 * @return True if the digits form a palindrome otherwsie false
	 */
	private boolean isPalindrome(String value)
	{
		boolean result = false;

		// Find out how many digits we have and get the collection
		char[] parts = value.toCharArray();
		int numParts = parts.length;

		// Make sure we have something big enough to process
		if(1 < numParts)
		{
			for(int i=0, j=numParts-1; i >= 0 && j >= 0; ++i,--j)
			{
				if(parts[i] != parts[j])
				{
					result = false;
					break;
				} 
				else
					result = true;
			} 
		}
		// Since we know that 0 and 1 are valid palindromes and we 
		else if(0 <= numParts)
			result = true;

		return result;
	}
}
