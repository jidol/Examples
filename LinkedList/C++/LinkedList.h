#include <stdio.h>
#include <string.h>
#include <utility>
#include <ListElement.h>

template <class T>
class LinkedList
{
   public:

      // Basic Constructor
      LinkedList();

      // Basic Destructor
      ~LinkedList();

      // Contains element
      bool contains(const T* value);

      // Add
      void add(T* value, int index=-1);

      // Remove
      void remove(T* value);

      // Remove
      void remove(int index);

      // Get
      // If index is invalid, null is returned
      T* get(int index);

      // Is valid
      inline bool isEmpty() { return (_myStorage == 0); }

   protected:

      // Internal get that returns the LinkElement
      ListElement<T>* getInternal(int index);

      // Main storage
      ListElement<T>* _myStorage;

      // Pointer to the last element
      ListElement<T>* _myLastElement;
};

template <class T>
LinkedList<T>::LinkedList():
_myStorage(0),
_myLastElement(0)
{
}

template <class T>
LinkedList<T>::~LinkedList()
{
   if(0 != _myStorage)
   {
      while(!isEmpty())
         remove(0);

      delete _myStorage;
      _myStorage = 0;
      _myLastElement = 0;
   }
}

template <class T>
void LinkedList<T>::add(T* value, int index)
{
   if(0 == _myStorage)
   {
      _myStorage = new ListElement<T>(value);
      _myLastElement = _myStorage;
   }
   else if(index == -1)
   {
      _myStorage = new ListElement<T>(value, _myStorage);
   }
   else
   {
      ListElement<T>* iter = getInternal(index);
      if(0 == iter)
      {
         iter = new ListElement<T>(value);
         _myLastElement->setNext(iter);
         _myLastElement = iter;
      } 
   }
}

template <class T>
T* LinkedList<T>::get(int index)
{
   ListElement<T>* iter = getInternal(index);

   if(0 != iter)
      return iter->element();
   else
      return 0;
}

template <class T>
ListElement<T>* LinkedList<T>::getInternal(int index)
{
   ListElement<T>* ptr = _myStorage;
   for(int i=0; i < index && ptr != 0; ++i)
   {
      ptr = ptr->next();
   }

   return ptr;
}

template <class T>
void LinkedList<T>::remove(T* value)
{
   ListElement<T>* iter = _myStorage;
   if(*(iter->element()) != *value)
   {
      while(0 != iter->next() && 
            *(iter->next()->element()) != *value)
        iter = iter->next();
      if(0 != iter && *(iter->next()->element()) == *value)
      {
         ListElement<T>* match = iter->next();
         iter->setNext(match->next());
         delete match;
      }
   }
   else
   {
      ListElement<T>* match = iter;
      _myStorage = iter->next();
      delete match;
   }
}

template <class T>
void LinkedList<T>::remove(int index)
{
   // Granted not very efficent, but simple
   remove(get(index));
}

template <class T>
bool LinkedList<T>::contains(const T* value)
{
   bool status = false;
   ListElement<T>* iter = _myStorage;
   while(0 != iter)
   {
      if(*(iter->element()) == *value)
      {
         status = true;
         break;
      }
      else
         iter = iter->next();
   }
   return status;
}
