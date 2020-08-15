#ifndef MILLERI_H
#define MILLERI_H

#include "Chromaphagi.h"
#include "../lab/Habitat.h"

class Milleri : public Chromaphagi
{
public:
   Milleri();

   Milleri(int x, int y);

   Chromaphagi & mitosis(Habitat &hab);
   
   ~Milleri();
};

#endif