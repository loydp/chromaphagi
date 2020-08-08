#ifndef FILEHANDLER_H
#define FILEHANDLER_H

#include <string>
#include "../lab/Habitat.h"
class FileHandler 
{
private:
std::string filePath;

public:
   
   FileHandler(std::string filePath);

   Habitat * makeHabitat();

   ~FileHandler();
};

#endif