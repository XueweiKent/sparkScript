CC = g++

SRC = cpuPunisher.cpp

CC_FLAGS = -pthread -std=c++11

EXE = cpuPunisher

release:$(SRC)
	$(CC)    $(SRC) $(CC_FLAGS) -o $(EXE)

clean: $(SRC)
	rm -f $(EXE)
