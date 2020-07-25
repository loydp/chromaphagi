/*
#include "opencv4/opencv2/imgproc/imgproc.hpp"
#include "opencv4/opencv2/highgui/highgui.hpp"
*/
#include <opencv2/core.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <iostream>

/*
#include <stdlib.h>
#include <stdio.h>
*/

void flattenImg(cv::Mat img) {
   int columns = img.cols;
   int rows = img.rows;
   for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++) {
         img.at<cv::Vec3b>(j, i) = {255, 255, 255};
      }
   }
}

int main()
{
   std::string image_path = "src/test-100x56.jpg";
   cv::Mat img = cv::imread(image_path, cv::IMREAD_COLOR);

   if (img.empty()) 
   {
      std::cout << "Could not find image: " << image_path << std::endl;
      return 1;
   }

   imshow("Display window", img);

   cv::Vec3b pixel = img.at<cv::Vec3b>(10, 10);


   flattenImg(img);

   imshow("Display window", img);
   int k = cv::waitKey(0);



   if (k == 's')
   {
      cv::imwrite("starry_night.png", img);
   }

   std::cout << "testing" << std::endl;
   img.release();
}


 
