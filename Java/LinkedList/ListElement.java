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
 * Simple Single Linked List Item
 */
class ListElement<T>
{
      /**
       * Constructor
       * @param element Item to store
       * @param link Link to next element, which could be null
       */
      public ListElement(T element, ListElement<T> link)
      {
	_myElement = element;
	_myLink = link;
      }

     /**
       * Constructor
       * @param element Item to store
       */
      public ListElement(T element)
      {
	_myElement = element;
	_myLink = null;
      }


      /**
       * Set the link to the next element
       * @return Element stored in this object
       */
      public T element()
      {
	return _myElement;
      }

      /**
       * Set the element stored
       * @param element Data to store
       */
      public void element(T element)
      {
	_myElement = element;
      }

      /**
       * Get the link element
       * @return Link to next element
       */
      public ListElement<T> next()
      {
	return _myLink;
      }

      /**
       * Set the link to the next element
       * @param e Link to next element
       */
      public void setNext(ListElement<T> e)
      {
	_myLink = e;
      }

     /**
      * Data element being stored
      */
     protected T _myElement;

     /**
      * Link to next element which may be null
      */
     protected ListElement<T> _myLink;
}
