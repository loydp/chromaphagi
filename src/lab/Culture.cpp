#include "Culture.h"

// TODO: remove this eventually
#include <iostream>

Culture::Culture()
{
   std::cout << "Culture created." << std::endl;
   std::cout << edge.empty() << std::endl;
}

/*
Starting with a single Chromaphagi, activates it and depending what it returns
either moves onto the next in the queue or pops the previous one off.
*/
void Culture::activate(Habitat &hab, Chromaphagi * species)
{
   std::cout << "Culture:: activating." << std::endl;

   //TODO: delete species?
   species->activate(hab);
   
   edge.push(species);

   bool pop_or_not;

   while (!edge.empty())
   {
      std::cout << "EDGE SIZE: " << edge.size() << std::endl;
      pop_or_not = edge.front()->process(hab, edge);
      if (pop_or_not == true)
      {
         delete edge.front();
         edge.pop();
      }

   }

}

Culture::~Culture()
{
   std::cout << "Culture destroyed." << std::endl;
}