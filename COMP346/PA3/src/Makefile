# Serguei A. Mokhov, mokhov@cs.concordia.ca
# Duc Nguyen -- student
# PA3

JAVAC=javac
JFLAGS=-g
JVM=java
EXE=DiningPhilosophers

ASMTDIRS := . common

# Lists of all *.java and *.class files
JAVAFILES := $(ASMTDIRS:%=%/*.java)
CLASSES := $(ASMTDIRS:%=%/*.class)

all: $(EXE).class
	@echo "The party for Philosophers has been built! Let's rock"

$(EXE).class: $(JAVAFILES)
	$(JAVAC) $(JFLAGS) $(EXE).java

run: all
	$(JVM) $(EXE)

regression: all
	@for arg in 3 4 5; do $(JVM) $(EXE) $$arg; done

clean:
	rm -f $(CLASSES) #* *~

# EOF
