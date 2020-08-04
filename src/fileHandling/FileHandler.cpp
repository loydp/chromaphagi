#include "FileHandler.h"
#include <iostream>

FileHandler::FileHandler(std::string filePath) 
{
   filePath.insert(0, "../");
   this->filePath = filePath;

   std::cout << "Filepath: " << filePath << std::endl;
}

FileHandler::~FileHandler()
{
   std::cout << "Filehandler dtor" << std::endl;
}