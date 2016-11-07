CC   = g++ -g
COMPILE  = $(CC) -c 
LDFLAGS = 
MAKEEXE   = $(CC)

SRC   = TestCase.cpp
OBJ   = $(patsubst %.cpp, %.o, $(SRC))
EXE   = test_case

all:   $(EXE)

$(EXE):   ${OBJ}
	$(MAKEEXE) $^ $(LDFLAGS) -o $@

%.o:   %.cpp
	$(COMPILE) $< -o $@

clean:
	rm -f *.o $(EXE) 

