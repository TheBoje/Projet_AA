
JCFLAGS = -Xlint:all -Xdiags:verbose -d build -g -cp src
JC = javac
JFLAGS = -cp build
RM = rm -rf

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JCFLAGS) $*.java

CLASSES = \
	src/graph/Color.java \
	src/graph/CyclicGraphException.java \
	src/graph/Node.java \
	src/graph/Graph.java \
	src/Main.java 

default: mk classes

classes: $(CLASSES:.java=.class)

mk:
	mkdir -p build

# usage : make main ARGS=1
main: mk classes
	java $(JFLAGS) Main $(ARGS)

gen: mk classes
	java -cp .:lib -jar lib/randomdag.jar 15 0.3 | java $(JFLAGS) Main

red: classes
	java $(JFLAGS) Main

clean:
	$(RM) build