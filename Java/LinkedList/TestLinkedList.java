/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */
package LinkedList;
import java.util.LinkedList;
import java.lang.Integer;

public class TestLinkedList
{

	/**
	 * Basic Construction test
	 */
	public static boolean basicConstructionTest()
	{
   		LinkedList<Integer> testInt = new LinkedList<Integer>();
	
   		testInt = null;
   		System.out.println("Basic Construction Test completed");
	
   		return true;
	}
	
	/**
 	 * Test adding items
	 * @param count Number of itesm to add
	 * @return True if test successes otherwise false
	 */
	public static boolean basicAdd(int count)
	{
   		LinkedList<Integer> testInt = new LinkedList<Integer>();
	
   		for(int i=0; i < count; ++i)
   		{
      			Integer ptr = new Integer(i);
      			testInt.add(ptr);
   		}
   		for(int i=0; i < count; ++i)
   		{
      			int checkIndex = i;
      			Integer val = testInt.get(checkIndex);
      			if(false == Integer.valueOf(i).equals(val))
         			return false;
   		}
	
   		testInt = null;
	
   		System.out.println("Basic addition of items using array operator works as expected"); 
   		return true;
	}
	
	/**
 	 * Check that contains works
	 * @param count Number of items to test
	 * @return True if success otherwise false
	 */
	public static boolean checkContains(int count)
	{
   		LinkedList<Integer> testInt = new LinkedList<Integer>();
	
   		for(int i=0; i < count; ++i)
   		{
      			Integer ptr = new Integer(i);
      			testInt.add(ptr);
   		}
	
   		for(int i=0; i < count; ++i)
   		{
      			if(false == testInt.contains(new Integer(i)))
         			return false;
   		}
	
   		testInt = null;
	
   		System.out.println("Contains works as expected");
   		return true;
	}
	
	
	/**
 	 * Driver for tests
	 */
	public static void main(String[] args)
	{
		System.out.println("Test Construction");
   		boolean result = TestLinkedList.basicConstructionTest();
   		if(result)
		{
			System.out.println("Test Add");
      			result = TestLinkedList.basicAdd(20);
		}
   		if(result)
		{
			System.out.println("Test contains");
      			result = TestLinkedList.checkContains(30);
		}
	
   		System.out.println("Test result:  " + result);
	}
}
