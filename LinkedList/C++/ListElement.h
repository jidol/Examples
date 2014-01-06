
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
      ListElement* next();

      // Set Next
      void next(ListElement* e);

   protected:

     // Data stored in this element
     T* _myElement;

     // Link to next element
     ListElement<T>* _myLink;
};

template <class T>
ListElement::ListElement(T* element, ListElement<T>* link):
_myElement(element),
_myLink(link)
{
}

template <class T>
ListElement::~ListElement()
{
   _myElement = 0;
   _myLink = 0;
}

template <class T>
T* ListElement::element()
{
   return _myElement;
}

template <class T>
void ListElement::element(T* element)
{
   _myElement = element;
}

template <class T>
ListElement* ListElement::next()
{
   return _myLink;
}

template <class T>
void ListElement::next(LinkElement* e)
{
   _myLink = e;
}
