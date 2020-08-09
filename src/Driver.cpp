#include <iostream>
#include "fileHandling/FileHandler.h"
#include "lab/Habitat.h"

//#include <opencv2/core.hpp>
/*#include <opencv2/core.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
*/

int main()
{
   std::string image_path = "src/test-100x56.jpg";
   // std::string image_path2 = "src/test-Large.jpg";
   std::cout << "Entered string is: " << image_path << std::endl;
 
   /*
   Makes a FileHandler that will return a reference to
   the habitat. The FileHandler can then delete itself
   When needed.
   */
   FileHandler fh(image_path);

   Habitat *hab = fh.makeHabitat();
   std::cout << hab << std::endl;
   std::cout << "Sample: " << hab->getCell(0, 0, 0) << std::endl;

/*


   FileHandler(image_path2) fh;

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
*/
}


 
