#include "Milleri.h"
#include "Chromaphagi.h"
#include "../lab/Habitat.h"

// Delete later:
#include <iostream>

Milleri::Milleri() : Chromaphagi()
{
   std::cout << "Milleri: Simple ctor called" << std::endl;
}

Milleri::Milleri(int x, int y) : Chromaphagi(x, y)
{
   std::cout << "Milleri: Ctor called" << std::endl;
}


bool Milleri::process(Habitat& hab, std::queue<Chromaphagi*>& edge)
{
   hab.setCell(x, y, 0, 255);
   hab.setCell(x, y, 1, 255);
   hab.setCell(x, y, 2, 255);
   mitosis(hab, edge);
   return true;
}

void Milleri::mitosis(Habitat &hab, std::queue<Chromaphagi*>& edge)
{
   if (hab.validLocation(x + 1, y))
   {
      std::cout << "Push new at " << (x + 1) << (y) << std::endl;
      Chromaphagi *newChroma = new Milleri(x + 1, y);
      edge.push(newChroma);
   }
}

Milleri::~Milleri()
{
   std::cout << "Milleri destructor called" << std::endl;
}