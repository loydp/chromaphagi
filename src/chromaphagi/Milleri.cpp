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

/**
 * Param Hab: a reference to the habitat/petri dish
 * Param edge: a reference to the queue holidng the contents of the habitat
 * Return: A boolean. True means this chromaphagi will be deleted.
 * */
bool Milleri::process(Habitat& hab, std::queue<Chromaphagi*>& edge)
{
   // make sure hab reflects that this cell has been processed
   if (hab.getCell(x, y, 3) != 1) 
   {
      hab.setCell(x, y, 3, 1);
   }
   
   // Red
   if (hab.getCell(x, y, 0) < 128) 
   {
      hab.setCell(x, y, 0, 0);
   }
   else
   {
      hab.setCell(x, y, 0, 255);
   }

   // Green
   if (hab.getCell(x, y, 1) < 128) 
   {
      hab.setCell(x, y, 1, 0);
   }
   else
   {
      hab.setCell(x, y, 1, 255);
   }

   // Blue
   if (hab.getCell(x, y, 2) < 128)
   {
      hab.setCell(x, y, 2, 0);
   }
   else
   {
      hab.setCell(x, y, 2, 255);
   }

   mitosis(hab, edge);
   return true;
}

bool Milleri::activate(Habitat& hab) 
{
      std::cout << "TESTING" << std::endl;
   hab.setCell(x, y, 3, 1);
      std::cout << "TESTING" << std::endl;
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