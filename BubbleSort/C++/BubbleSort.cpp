#include <iostream>
#include <math.h>
#include <cstdlib>

// Going to assume that T is sortable without
// enforcing a < operator in this example
template <class T>
T* bubbleSort(T* data, long count)
{
   for(int i=0; i < count; ++i)
   {
      // Loop over all the indexs except
      // the completed elements at the end
      for(int j=0; j < count - i; ++j)
      {
	 T* posOne = data + j;
         T valOne = *posOne;
         T valTwo = *(posOne + 1);
         if( valOne > valTwo )
         {
            *posOne = valTwo;
            *(posOne + 1) = valOne;
         }
      }
   }
}
int main(int argc, char* argv[])
{
   int defaultCount = 20;
   double pi = atan(1) * 4;

   if(argc > 0)
   {
      int possibleCount = atoi(argv[1]); 
      if(possibleCount > 0)
         defaultCount = possibleCount;
   }

   int* intData = new int[defaultCount];
   double* doubleData = new double[defaultCount];

   for(int i=0; i < defaultCount; ++i)
   {
      intData[i] = rand() % defaultCount; 
      doubleData[i] = intData[i] * pi;
   }

   bubbleSort(intData, defaultCount);
   bubbleSort(doubleData, defaultCount);

   for(int i = 0; i < defaultCount; ++i)
      std::cout << intData[i] << std::endl;

   for(int i = 0; i < defaultCount; ++i)
      std::cout << doubleData[i] << std::endl;

   delete[] intData;
   delete[] doubleData;
}
