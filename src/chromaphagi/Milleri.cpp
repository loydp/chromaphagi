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

Chromaphagi & Milleri::mitosis(Habitat &hab)
{
   Milleri *retValue = new Milleri(0, 0);
   return *retValue;
}

Milleri::~Milleri()
{
   std::cout << "Milleri destructor called" << std::endl;
}