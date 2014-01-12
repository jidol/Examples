import java.util.LinkedList;
import java.lang.Integer;
import java.io.StringReader;
import java.io.IOException;

public class ParseInt
{
   /**
    * Parse an integer value into its digits.
    * @param value Integer to parse
    * @return LinkedList of Integer objects that are the digits
    *         of the integer passed within.
    */
   public static LinkedList<Integer> parseIntoDigits(int value)
   {
	LinkedList<Integer> result = new LinkedList<Integer>();

        // Make sure to not throw any IO Exceptions
	try
	{
	        // Use IO package String Reader to read the string
		StringReader sReader = new StringReader(
			Integer.toString(value));

		int part = 0;
		char cPart = 0;
		//  -1 indicates nothign to read
		while(sReader.ready() && part != -1)
		{
			part = sReader.read();
			if(-1 != part)
			{
				// Int is really a Char
				cPart = (char)part;
				// Convert char back to String before
				// parsing into an Integer
				result.add(Integer.valueOf(""+cPart));
			}
		}

		// Clean Up Reader
		sReader.close();
		sReader = null;
	}
	catch(IOException ex)
	{
		//No Action 
	}

	return result;
   }

   /**
    * Get the digits from the value as an array.
    * @param value Value to be converted
    * @return Array of Intger digit values
    */
   public static Integer[] parseDigitArray(int value)
   {
	return ParseInt.parseIntoDigits(value).toArray(new Integer[1]);
   }
}
