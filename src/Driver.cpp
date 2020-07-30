#include <opencv2/core.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <iostream>

void testOperation(cv::Mat img) {
   int columns = img.cols;
   int rows = img.rows;
   for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++) {
         if (img.at<cv::Vec3b>(j, i)[0] < 128)
            img.at<cv::Vec3b>(j, i) = {0, 0, 0};
      }
   }
}

int main()
{

   std::string image_path = "src/test-100x56.jpg";
   std::string image_path2 = "src/test-Large.jpg";

   // Now testing with large
   cv::Mat img = cv::imread(image_path2, cv::IMREAD_COLOR);
   if (img.empty()) 
   {
      std::cout << "Could not find image: " << image_path << std::endl;
      img.release();
      return 1;
   }

   // cv::Vec3b pixel = img.at<cv::Vec3b>(10, 10);

   testOperation(img);

   imshow("Display window", img);
   int k = cv::waitKey(0);

   if (k == 's')
   {
      cv::imwrite("starry_night.png", img);
   }

   std::cout << "Testing complete" << std::endl;
   img.release();
}


 
