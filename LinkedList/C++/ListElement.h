
template <class T>
class ListElement
{
   public:

      // Constructor
      ListElement(T* element, ListElement<T>* link=0);

      // Destructor
      virtual ~ListElement();

      // Get data
      T* element();

      // Set Element
      void element(T* element);

      // Get Next
      ListElement<T>* next();

      // Set Next
      void setNext(ListElement<T>* e);

   protected:

     // Data stored in this element
     T* _myElement;

     // Link to next element
     ListElement<T>* _myLink;
};

template <class T>
ListElement<T>::ListElement(T* element, ListElement<T>* link):
_myElement(element),
_myLink(link)
{

}

template <class T>
ListElement<T>::~ListElement()
{
   delete _myElement;
   _myElement = 0;
   _myLink = 0;
}

template <class T>
T* ListElement<T>::element()
{
   return _myElement;
}

template <class T>
void ListElement<T>::element(T* element)
{
   _myElement = element;
}

template <class T>
ListElement<T>* ListElement<T>::next()
{
   return _myLink;
}

template <class T>
void ListElement<T>::setNext(ListElement<T>* e)
{
   _myLink = e;
}
