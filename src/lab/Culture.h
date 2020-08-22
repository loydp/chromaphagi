#ifndef CULTURE_H
#define CULTURE_H

#include "../lab/Habitat.h"
#include <queue>
#include "../chromaphagi/Chromaphagi.h"

class Culture {
   private:
   std::queue<Chromaphagi*> edge;

   public:

   Culture();

   void activate(Habitat &hab, Chromaphagi *);

   ~Culture();

};

#endif