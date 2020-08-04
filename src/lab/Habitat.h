#ifndef HABITAT_H
#define HABITAT_H

#include <vector>

class Habitat 
{
private:
   int depth;
   int column;
   int row;
   std::vector<std::vector<std::vector<int> > > matrix;

public:

   Habitat(int numRows, int numColumns);

   void setCell(int row, int column, int depth, int val);

   ~Habitat();
};

#endif