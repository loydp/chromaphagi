#include "Chromaphagi.h"
#include <iostream>

Chromaphagi::Chromaphagi()
{
   
}

Chromaphagi::Chromaphagi(int x, int y) {
   this->x = x;
   this->y = y;
   std::cout << "Chromaphagi no args ctor" << std::endl;
}