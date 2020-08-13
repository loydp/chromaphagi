#ifndef HABITAT_H
#define HABITAT_H

#include <vector>

class Habitat 
{
private:
   int depth;
   int column;
   int row;

   // a 3d matrix
   std::vector<std::vector<std::vector<int> > > matrix;

public:

   // Habitat is initialized with the breadth and height
   // of the iamge. x then y.
   Habitat(int numRows, int numColumns);

   void setCell(int row, int column, int depth, int val);

   int getCell(int row, int column, int depth);

   int getWidth();
   int getHeight();

   ~Habitat();
};

#endif