#ifndef CHROMAPHAGI_H
#define CHROMAPHAGI_H

#include "../lab/Habitat.h"
#include <queue>

class Chromaphagi {

public:
   Chromaphagi();
   Chromaphagi(int, int);

   virtual bool process(Habitat&, std::queue<Chromaphagi*>&);
   virtual bool activate(Habitat&);
/*
   Chromaphagi();
   Chromaphagi(int x, int y);
   virtual Chromaphagi & mitosis(Habitat &hab);
*/
   virtual ~Chromaphagi();

protected:
   int x;
   int y;
};

#endif