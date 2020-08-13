#ifndef CULTURE_H
#define CULTURE_H

#include "Habitat.h"
#include <queue>
#include "../chromaphagi/Chromaphagi.h"

class Culture {
   private:
   std::queue<Chromaphagi> colony;

   public:

   Culture();

   int activate(Habitat &hab, Chromaphagi species);

   ~Culture();

};

#endif