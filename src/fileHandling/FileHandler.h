#ifndef FILEHANDLER_H
#define FILEHANDLER_H

#include <string>
#include "../lab/Habitat.h"
#include <opencv2/core.hpp>

class FileHandler 
{
private:
std::string filePath;
cv::Mat img;

public:
   
   FileHandler(std::string filePath);

   Habitat * makeHabitat();

   bool writeHabToMat(Habitat& hab);

   void displayMat();

   bool cleanup(Habitat &hab);

   ~FileHandler();
};

#endif