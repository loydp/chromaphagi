CC=g++
CFLAGS= -std=c++11 -Wall -Werror -pedantic -ggdb 
LIBS= `pkg-config --cflags --libs opencv4`

all: clean driver

clean:
	rm driver

driver: src/Driver.cpp
	$(CC) $(CFLAGS) $(LIBS) src/Driver.cpp -o driver