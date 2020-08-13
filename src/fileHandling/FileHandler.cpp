#include "FileHandler.h"
#include "../lab/Habitat.h"
#include <opencv2/imgcodecs.hpp>

#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>

// delete eventually:
#include <iostream>

FileHandler::FileHandler(std::string filePath) 
{
   this->filePath = filePath;

   std::cout << "FileHandler has filepath: " << filePath << std::endl;
}

Habitat * FileHandler::makeHabitat() 
{
   std::cout << "Making habitat using filepath: " << filePath << std::endl;
   img = cv::imread(filePath, cv::IMREAD_COLOR);
   if (img.empty())
   {
      std::cout << "ERROR: Could not find: " << filePath << std::endl;
      img.release();
   }

   Habitat * hab_ptr;
   hab_ptr = new Habitat(img.rows, img.cols);

   std::cout << "cols: " << img.cols << ". rows: " << img.rows << std::endl;
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

bool FileHandler::writeHabToMat(Habitat& hab)
{
   for (int i = 0; i < img.rows; i++)
   {
      for (int j = 0; j < img.cols; j++)
      {
         for (int k = 0; k < 3; k++) {
            img.at<cv::Vec3b>(i,j)[k] = hab.getCell(i, j, k);
         }
      }
   }
   return true;
}

// FIXME Currently has write functionality too.
void FileHandler::displayMat()
{
   imshow("Display window", img);
   int k = cv::waitKey(0);

   if (k == 's')
   {
      cv::imwrite("test_result.png", img);
   }
}

bool FileHandler::cleanup(Habitat & hab)
{
   img.release();
   delete &hab;
   return true;
}

FileHandler::~FileHandler()
{
   std::cout << "Filehandler dtor" << std::endl;
}