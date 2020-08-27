#include "Chromaphagi.h"
#include <iostream>

Chromaphagi::Chromaphagi()
{
   
}


bool Chromaphagi::process(Habitat&, std::queue<Chromaphagi*>&) 
{
   std::cout << "Chrphg.process. x = " << x << " Y = " << y << std::endl;
   return true;
}

bool Chromaphagi::activate(Habitat&)
{
   std::cout << "Chrchphg.activate() has been erroneously activated" << std::endl;
   return true;
}


Chromaphagi::Chromaphagi(int x, int y) {
   this->x = x;
   this->y = y;
   std::cout << "Chromaphagi no args ctor" << std::endl;
}

Chromaphagi::~Chromaphagi() {
   std::cout << "Chr.Dtor" << std::endl;
}