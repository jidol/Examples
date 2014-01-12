import java.lang.Comparable;
import java.util.LinkedList;

public class BubbleSort<T extends Comparable<T>>
{

	/**
	 * Bubble sort array of Compareable items
	 * @param data Data to sort inline
	 */
	public void sort(T[] data)
	{
		if(null != data)
		{
			int count = data.length - 1;
   			for(int i=0; i < count; ++i)
   			{
      				// Loop over all the indexs except
      				// the completed elements at the end
      				for(int j=0; j < count - i; ++j)
      				{
	 				T posOne = data[j];
         				T valOne = posOne;
         				T valTwo = data[j+1];
         				if( valOne.compareTo(valTwo) > 0 )
         				{
            					data[j] = valTwo;
            					data[j+1] = valOne;
         				}
      				}
   			}
		}
	}

	/**
	 * Basic test using integers passed in as arguments
	 */
	public static void main(String[] args)
	{
		// Example using integers
		BubbleSort<Integer> bubble = new BubbleSort<Integer>();

		LinkedList<Integer> data = new LinkedList<Integer>();
		for(String val:args)
		{
			try
			{
				data.add(Integer.valueOf(val));
			}
			catch(Exception ex)
			{
			   //Ignore failures
			}
		} 

		Integer[] d = data.toArray(new Integer[1]);
		bubble.sort(d);
		for(Integer v:d)
			System.out.println(v.toString());
		d = null;
		data = null;
		
	}
}
