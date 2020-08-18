#include "Habitat.h"
#include <vector>

// For testing
#include <iostream>
#include <sstream>

Habitat::Habitat(int numRows, int numColumns)
{
   std::cout << "Hab ctor called" << std::endl;
   depth = 3;
   row = numRows;
   column = numColumns;
   matrix.resize(depth, std::vector<std::vector<int> >(column, std::vector<int>(row, 0)));
}

bool Habitat::validLocation(int width, int height)
{
   if (width < column && width >= 0 && height < row && height >= 0)
   {
		return true;
   }

	return false;
}

// depth column row value
void Habitat::setCell(int row, int col, int depth, int val) 
{
   matrix[depth][col][row] = val;
}

int Habitat::getCell(int row, int col, int depth)
{
   return matrix[depth][col][row];
}

int Habitat::getWidth() {return column;}
int Habitat::getHeight() {return row;}

Habitat::~Habitat()
{
   std::cout << "Hab destructor called" << std::endl;
}