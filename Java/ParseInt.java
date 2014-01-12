import java.util.LinkedList;
import java.lang.Integer;
import java.io.StringReader;
import java.io.IOException;

public class ParseInt
{
   public static LinkedList<Integer> parseIntToParts(int value)
   {
	LinkedList<Integer> result = new LinkedList<Integer>();
	try
	{
		StringReader sReader = new StringReader(
			Integer.toString(value));

		int part = 0;
		char cPart = 0;
		while(sReader.ready() && part != -1)
		{
			part = sReader.read();
			if(-1 != part)
			{
				cPart = (char)part;
				result.add(Integer.valueOf(""+cPart));
			}
		}

		sReader.close();
		sReader = null;
	}
	catch(IOException ex)
	{
		//No Action 
	}
	return result;
   }
}
