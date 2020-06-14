CC=g++
CFLAGS= -std=c++11 -Wall -Werror -pedantic -ggdb

all: driver

driver: chromaphagi/Driver.cpp
	$(CC) $(CFLAGS) Driver.cpp -o driver

clean:
	rm chromaphagi/driver