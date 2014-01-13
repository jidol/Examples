/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */
package LinkedList;

/**
 * Basic Single Linked List based on ListElement
 */
public class LinkedList<T>
{
      /**
       * Basic constructor
       */
      public LinkedList()
      {
         _myStorage = null;
         _myLastElement = null;
      }

      /**
       * Check to see if Linked List Contains value
       * @param value Value to find in list
       * @return True if contained otherwise false
       */
      public boolean contains(T value)
      {
	boolean status = false;
   	ListElement<T> iter = _myStorage;
   	while(null != iter)
   	{
      		if((iter.element()) == value)
      		{
         		status = true;
         		break;
      		}
      		else
         		iter = iter.next();
   	}

   	return status;

      }

      /**
       * Add value into the List
       * @param value Value to add to the list
       */
      public void add(T value)
      {
	  add(value,-1);
      }

      /**
       * Add value into the List
       * @param value Value to add to the list
       * @param index Index to insert the value
       */
      public void add(T value, int index)
      {
	   if(null == _myStorage)
	   {
      	      _myStorage = new ListElement<T>(value);
      	      _myLastElement = _myStorage;
   	   }
   	   else if(-1 == index)
   	   {
      		   _myStorage = new ListElement<T>(value, _myStorage);
   	   }
   	   else
   	   {
      		   ListElement<T> iter = getInternal(index);
      		   if(null == iter)
      		   {
         		   iter = new ListElement<T>(value);
         		   _myLastElement.setNext(iter);
         		   _myLastElement = iter;
      		   } 
   	   }

      }

      /**
       * Remove a given item
       * @param value Value to remove
       */
      public void remove(T value)
      {
 	   ListElement<T> iter = _myStorage;
   	   if(iter.element() != value)
   	   {
      	   	while(null != iter.next() && 
            	   iter.next().element() != value)
        	   iter = iter.next();
      	   	if(null != iter && iter.next().element() == value)
      	   	{
         	   ListElement<T> match = iter.next();
         	   iter.setNext(match.next());
      	   	}
   	   }
   	   else
   	   {
      	   	_myStorage = iter.next();
	   }
     }

      /**
       * Remove item at given index
       * @param index Index to remove
       */
      public void remove(int index)
      {
   	// Granted not very efficent, but simple
   	remove(get(index));
      }

      /**
       * Return the value at a given index
       * @param index Index to return
       * @return Value at index or null if invalid index
       */
      public T get(int index)
      {
	   ListElement<T> iter = getInternal(index);

   	   if(null != iter)
      		return iter.element();
   	   else
      		return null;
      }

      /**
       * Internal function get the ListElement object at
       * a given index
       *
       * @param index Index to return
       * @return ListElement object at the given index or null
       */
      protected ListElement<T> getInternal(int index)
      {
	 ListElement<T> ptr = _myStorage;
   	 for(int i=0; i < index && ptr != null; ++i)
   	 {
      	 	ptr = ptr.next();
   	 }
	
   	 return ptr;
      }

      /**
       * Strorage
       */
      protected ListElement<T> _myStorage;

      /**
       * Last element
       */
      protected ListElement<T> _myLastElement;
}
