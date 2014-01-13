package BubbleSort;

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
					updateIndex(data, j, j+1);
	      			}
   			}
		}
	}

	/**
	 * Implemented in recursive method for Bubble Sort
	 * @param data Array of data to be sorted
	 * @param index Index to start sorting
	 */
	public void sortRecursive(T[] data, int index)
	{
		if(null != data)
		{
			int size = data.length;
			if(index < size)
			{
				for(int i=index; i < size; ++i)
				{
					int next = index + 1;
					if(index < data.length - 1)
						sortRecursive(data,next);
					updateIndex(data, index, next);
				}
			}
		}
	}

	/*
	 * Update the given two indexs to be in the correct order.  No action
	 * taken on bad inputs
	 * @param data Data to sort
	 * @param posOne First index which must be less than posTwo
	 * @param posTwo Second index which must be greater than posOne and less than length of data
	 */
	private void updateIndex(T[] data, int posOne, int posTwo)
	{
		if(null != data)
		{
			int size = data.length;
			if(posOne < posTwo && posTwo < size)
			{
				T valOne = data[posOne];
       				T valTwo = data[posTwo];
       				if( valOne.compareTo(valTwo) > 0 )
       				{
  					data[posOne] = valTwo;
        				data[posTwo] = valOne;
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
			if(null != v)
				System.out.println(v.toString());
		d = null;
		System.out.println("========");
		System.out.println("Recursive Way");
		d = data.toArray(new Integer[1]);
		bubble.sortRecursive(d, 0);
		for(Integer v:d)
			if(null != v)
				System.out.println(v.toString());
		d = null;
		data = null;
		
	}
}
