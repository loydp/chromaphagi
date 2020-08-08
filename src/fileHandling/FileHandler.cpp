#include "FileHandler.h"
#include "../lab/Habitat.h"
#include <opencv2/imgcodecs.hpp>

#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>

// delete eventually:
#include <iostream>

FileHandler::FileHandler(std::string filePath) 
{
   filePath.insert(0, "../");
   this->filePath = filePath;

   std::cout << "FileHandler has filepath: " << filePath << std::endl;
}

Habitat * FileHandler::makeHabitat() 
{
   std::cout << "Making habitat" << std::endl;
   
   cv::Mat img = cv::imread(filePath, cv::IMREAD_COLOR);
   
   Habitat * hab_ptr;
   hab_ptr = new Habitat(img.rows, img.cols);

   for (int i = 0; i < img.rows; i++)
   {
      for (int j = 0; j < img.cols; j++)
      {
         // WARNING k is set to 3, not a dynamic depth
         for (int k = 0; k < 3; k++) {
            hab_ptr->setCell(i, j, k, img.at<cv::Vec3b>(i, j)[k]);
         }
      }
   }

   return hab_ptr;
}

FileHandler::~FileHandler()
{
   std::cout << "Filehandler dtor" << std::endl;
}