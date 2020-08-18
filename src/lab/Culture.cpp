#include "Culture.h"

// TODO: remove this eventually
#include <iostream>

Culture::Culture()
{
   std::cout << "Culture created." << std::endl;
   std::cout << edge.empty() << std::endl;
}

int Culture::activate(Habitat &hab, Chromaphagi species)
{
   std::cout << "Culture:: activating." << std::endl;

   int objectCount = 0;

   int width = hab.getWidth();
   int height = hab.getHeight();
   std::cout << height << width << std::endl;
 //  edge.push(species);
   objectCount++;

   // TODO

   while (!edge.empty())
   {
      edge.front().mitosis(hab);
      edge.pop();
   }

   return objectCount;
}

Culture::~Culture()
{
   std::cout << "Culture destroyed." << std::endl;
}