#include <iostream>
#include "fileHandling/FileHandler.h"
#include "lab/Habitat.h"
#include "lab/Culture.h"
#include "chromaphagi/Milleri.h"

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

// TESTING STUFF
/*
   std::cout << "Sample: " << hab->getCell(99, 55, 0) << std::endl;
   std::cout << "Sample: " << hab->getCell(99, 55, 1) << std::endl;
   std::cout << "Sample: " << hab->getCell(99, 56, 2) << std::endl;
*/


   Milleri * species_ptr = new Milleri(10, 10);

   Culture culture;
   std::cout << "Culture count: " << culture.activate(*hab, species_ptr) << std::endl;

   fh.writeHabToMat(*hab);
   fh.displayMat();
   fh.cleanup(*hab);

/*
   img.release();
*/
}


 
