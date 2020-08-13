#include "Culture.h"

// TODO: remove this eventually
#include <iostream>

Culture::Culture()
{
   std::cout << "Culture created." << std::endl;
   std::cout << colony.empty() << std::endl;
}

int Culture::activate(Habitat &hab, Chromaphagi species)
{
   std::cout << "Culture:: activating." << std::endl;

   int objectCount = 0;

   int width = hab.getWidth();
   int height = hab.getHeight();
   std::cout << height << width << std::endl;
   colony.push(species);
   objectCount++;

   while (!colony.empty())
   {
      colony.front().mitosis();
      colony.pop();
   }

   return objectCount;
}

Culture::~Culture()
{
   std::cout << "Culture destroyed." << std::endl;
}