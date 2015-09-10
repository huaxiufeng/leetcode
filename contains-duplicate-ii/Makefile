CC   = g++ -g
COMPILE  = $(CC) -c 
LDFLAGS = 
MAKEEXE   = $(CC)

SRC   = $(wildcard *.cpp)
OBJ   = $(patsubst %.cpp, %.o, $(SRC))
EXE   = test

all:   $(EXE)

$(EXE):   ${OBJ}
	$(MAKEEXE) $^ $(LDFLAGS) -o $@

%.o:   %.cpp
	$(COMPILE) $< -o $@

clean:
	rm -f *.o $(EXE) 

