#include "Culture.h"

// TODO: remove this eventually
#include <iostream>

Culture::Culture()
{
   std::cout << "Culture created." << std::endl;
   std::cout << edge.empty() << std::endl;
}

int Culture::activate(Habitat &hab, Chromaphagi * species)
{
   std::cout << "Culture:: activating." << std::endl;

   int objectCount = 0;

   //TODO: delete species?
   edge.push(species);
   objectCount++;

   bool pop_or_not;

   /*
   Starting with a single Chromaphagi, activates it and depending what it returns
   either moves onto the next in the queue or pops the previous one off.
   */
   while (!edge.empty())
   {
      std::cout << "EDGE SIZE: " << edge.size() << std::endl;
      pop_or_not = edge.front()->process(hab, edge);
      objectCount++;
      if (pop_or_not == true)
      {
         delete edge.front();
         edge.pop();
         objectCount--;
         std::cout << "Object Count: " << objectCount << std::endl;
      }


//      edge.front().mitosis(hab);
//      edge.pop();
   }

   return objectCount;
}

Culture::~Culture()
{
   std::cout << "Culture destroyed." << std::endl;
}