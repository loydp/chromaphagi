#include "Habitat.h"
#include <vector>

// For testing
#include <iostream>

Habitat::Habitat(int numRows, int numColumns)
{
   std::cout << "Hab ctor called" << std::endl;
   depth = 3;
   row = numRows;
   column = numColumns;
   matrix.resize(depth, std::vector<std::vector<int> >(column, std::vector<int>(row, 0)));
}

// depth column row value
void Habitat::setCell(int x, int y, int z, int val) 
{
   matrix[x][y][z] = val;
}

Habitat::~Habitat()
{
   std::cout << "Hab destructor called" << std::endl;
}