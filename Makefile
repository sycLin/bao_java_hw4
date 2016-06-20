all: BouncingBall

BouncingBall:
	@if ! [ -d bin/ ];then mkdir bin;fi
	@echo "compiling source files..."
	@javac -d bin src/*.java
	@echo "compilation complete."

run1:
	@echo "running BouncingBall..."
	@java -cp bin/ Bouncing.BouncingBall

run2:
	@echo "running BouncingBalls..."
	@java -cp bin/ Bouncing.BouncingBalls

clean:
	@echo "cleaning up..."
	@rm -rf bin
