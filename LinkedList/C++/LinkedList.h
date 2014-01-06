#include <stdio.h>
#include <string.h>
#include <utility>
#include <ListElement.h>

template <class T>
class LinkedList
{
   public:

      // Basic Constructor
      LinkedList(int defaultSize=10);

      // Basic Destructor
      ~LinkedList();

      // Array Access
      T* operator[](const int value);

      // Contains element
      bool contains(const T* value);

      // Pop top element
      T* pop();

      // Push element
      void push(T* value);

      // Get size
      inline long size() { return _mySize; };

   protected:

      // Is valid
      inline bool isValid() { return (_myStorage != 0); }

      ListElement* _myStorage;

      // Size
      long _mySize;

      // Insert Location
      long _myNextInsertLocation;
};

template <class T>
LinkedList<T>::LinkedList(int defaultSize):
_myStorage(0),
_mySize(defaultSize),
_myNextInsertLocation(0)
{
   _myStorage = createElement();
   populate(_myStorage, _mySize);
}

template <class T>
LinkedList<T>::~LinkedList()
{
   if(0 != _myStorage)
   {
      delete _myStorage;
      _myStorage = 0;
      _mySize = -1;
      _myNextInsertLocation = -1;
   }
}

template <class T>
T* LinkedList<T>::operator[] (const int value)
{
   T* result = 0;
   LinkElemnt* iter = _myStorage;

   if(0 != iter)
   {
      for(int i = 0; i < value; ++i)
      {
         if(0 != iter)
            iter = iter->next();
      }
      result = iter->elment();
   }
   return result; 
}
