#ifndef CHROMAPHAGI_H
#define CHROMAPHAGI_H

#include "../lab/Habitat.h"
#include "../lab/Culture.h"

class Chromaphagi {

public:
   Chromaphagi();
   Chromaphagi(int x, int y);
   Chromaphagi & mitosis(Habitat &hab, edge);
//   virtual Chromaphagi & mitosis(Habitat &hab);
//   virtual ~Chromaphagi();

/*
   virtual Chromaphagi & mitosis(Habitat &hab);
   virtual ~Chromaphagi();
*/

private:
   int x;
   int y;
};

#endif