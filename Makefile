
JCFLAGS = -Xlint:all -Xdiags:verbose -d build -g -cp .:src
JC = javac
JFLAGS = -cp .:src:build
RM = rm -rf

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JCFLAGS) $*.java

CLASSES = \
	src/Main.java 

default: classes

classes: $(CLASSES:.java=.class)

main: classes
	java $(JFLAGS) Main < data/graph-100.alists

clean:
	$(RM) build