/**
 * Copyright Jeff Idol 2013 - 2014
 * 
 * Released under GNU GENERAL PUBLIC LICENSE Version 2
 * See full license: https://github.com/jidol/Examples/blob/master/LICENSE
 *
 * All Source Available https://github.com/jidol/Examples
 */

#include <LinkedList.h>
#include <iostream>

bool basicConstructionTest()
{
   LinkedList<int>* testInt = new LinkedList<int>();

   delete testInt;
   testInt = 0;
   std::cout << "Basic Construction Test completed" << std::endl;

   return true;
}

bool basicAdd(int count)
{
   LinkedList<int>* testInt = new LinkedList<int>();

   for(int i=0; i < count; ++i)
   {
      int* ptr = new int;
      *ptr = i;
      testInt->add(ptr);
   }
   for(int i=0; i < count; ++i)
   {
      int checkIndex = count - 1 - i;
      int* val = testInt->get(checkIndex);
      if(i != *val)
         return false;
   }

   delete testInt;
   testInt = 0;

   std::cout << "Basic addition of items using array operator works as expected" << std::endl;
   return true;
}
bool checkContains(int count)
{
   LinkedList<int>* testInt = new LinkedList<int>();

   for(int i=0; i < count; ++i)
   {
      int* ptr = new int;
      *ptr = i;
      testInt->add(ptr);
   }

   for(int i=0; i < count; ++i)
   {
      if(false == testInt->contains(&i))
         return false;
   }

   delete testInt;
   testInt = 0;

   std::cout << "Contains works as expected" << std::endl;
   return true;
}


int main()
{
   bool result = basicConstructionTest();
   if(result)
      result = basicAdd(20);
   if(result)
      result = checkContains(30);

   std::cout << "Test result:  " << result << std::endl;
   return static_cast<int>(result);
}
