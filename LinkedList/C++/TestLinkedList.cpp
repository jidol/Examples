#include <LinkedList.h>
#include <iostream>

bool basicConstructionTest()
{
   LinkedList<int>* testInt = new LinkedList<int>(20);

   delete testInt;
   testInt = 0;
   std::cout << "Basic Construction Test completed" << std::endl;

   return true;
}

bool basicAdd(int count)
{
   LinkedList<int>* testInt = new LinkedList<int>(20);

   for(int i=0; i < count; ++i)
      *(*testInt)[i] = i;

   for(int i=0; i < count; ++i)
   {
      if(i != *(*testInt)[i])
         return false;
   }

   delete testInt;
   testInt = 0;

   std::cout << "Basic addition of items using array operator works as expected" << std::endl;
   return true;
}

int main()
{
   bool result = basicConstructionTest();
   result = basicAdd(20);

   std::cout << "Test result:  " << result << std::endl;
   return static_cast<int>(result);
}
