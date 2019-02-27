.PHONY: run

run: Main.java
	@make Main
	@java Main

Main: Main.java
	@javac *.java statuses/*.java skills/*.java

.PHONY: clean

clean:
	rm */*.class
