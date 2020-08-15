#ifndef CHROMAPHAGI_H
#define CHROMAPHAGI_H

#include "../lab/Habitat.h"

class Chromaphagi {

public:
   Chromaphagi();
   Chromaphagi(int x, int y);
/*
   Chromaphagi();
   Chromaphagi(int x, int y);
   virtual Chromaphagi & mitosis(Habitat &hab);
   virtual ~Chromaphagi();
*/
private:
   int x;
   int y;
};

#endif