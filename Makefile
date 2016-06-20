all: BouncingBall

BouncingBall:
	@if ! [ -d bin/ ];then mkdir bin;fi
	@echo "compiling source files..."
	@javac -d bin src/*.java
	@echo "compilation complete."

run:
	@echo "running BouncingBall..."
	@java -cp bin/ Bouncing.BouncingBall

clean:
	@echo "cleaning up..."
	@rm -rf bin
