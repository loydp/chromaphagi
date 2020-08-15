CC=g++
CFLAGS= -std=c++11 -Wall -Werror -pedantic -ggdb 
LIBS= `pkg-config --cflags --libs opencv4`

all: makeDriver

clean:
	rm driver

makeDriver: #src/Driver.cpp 
	$(CC) $(CFLAGS) $(LIBS) src/Driver.cpp src/fileHandling/FileHandler.cpp src/lab/Habitat.cpp src/lab/Culture.cpp src/chromaphagi/Chromaphagi.cpp src/chromaphagi/Milleri.cpp -o driver