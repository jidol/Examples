/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

package Example;

import java.lang.StringBuffer;

/**
 * Basic reverse of a string
 */
public class ReverseString
{
	/**
	 * Reverse String
	 */
	public static void main(String[] args)
	{
		for(String val:args)
		{
			if(null != val)
			{
				String rev = ReverseString.reverse(val);
				String loopRev = ReverseString.rev(val);
				if(null != rev)
		   			System.out.println("String " + val + " reversed: " + rev);
				if(false == rev.equals(loopRev))
					System.out.println("Error in reverse algorithms " + 
					"Recursive:  " + rev + " Loop:  " + loopRev);
			}
		}
	}

	/**
	 * Reverse the passed in string using Recursion
	 * @param val String to reverse
	 * @return Reversed string or null
	 */
	public static String reverse(String val)
	{
		String result = null;
		if(null != val)
		{
			StringBuffer buf = new StringBuffer();
			ReverseString.recursiveRev(buf, val.toCharArray(), 0);
			result = buf.toString();
			buf = null;
		}
		return result;
	}

	/**
	 * Iterative reverse string function
	 * @param val String to reverse
	 * @return Reversed string or null
	 */
	public static String rev(String val)
	{
		String result = null;
		if(null != val)
		{
			char[] data = val.toCharArray();
			if(null != data)
			{
				StringBuffer buf = new StringBuffer();
				for(int i=data.length -1; i >= 0; --i)
					buf.append(data[i]);
				result = buf.toString();
				buf = null;
			}
			data = null;

		}
		return result;
	}

	/**
	 * Recursive method to reverse an array of characters into
	 * a string buffer.
	 * @param buf The buffer to data into
	 * @param data The source array to reverse
	 * @param index Current index of loop
	 */
	public static void recursiveRev(StringBuffer buf, char[] data, int index)
	{
		if(null != buf && null != data && index < data.length)
		{
			buf.insert(0, data[index]);
			recursiveRev(buf,data,++index);
		}
	}
}
