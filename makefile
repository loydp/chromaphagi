CC=g++
CFLAGS= -std=c++11 -Wall -Werror -pedantic -ggdb 
LIBS= `pkg-config --cflags --libs opencv4`

all: clean makeDriver

clean:
	rm driver

makeDriver: src/Driver.cpp
	$(CC) $(CFLAGS) $(LIBS) src/Driver.cpp -o driver