
all:
	javac laberinto.java

run: all
	java laberinto

.PHONY: clean

clean:
	rm -f *.class
