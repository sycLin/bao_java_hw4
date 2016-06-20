package Bouncing;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Ball {
	// fields
	public static final int DEFAULT_RADIUS = 20;
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.BLUE;

	private int radius;
	private int positionX; // center of the circle (positionX, positionY)
	private int positionY;
	private int speedX;
	private int speedY;
	private Color background_color;

	// methods

	// constructors
	public Ball(Container container) {
		Random ran = new Random();
		radius = DEFAULT_RADIUS;
		positionX = ran.nextInt(container.getMaxX());
		positionY = ran.nextInt(container.getMaxY());
		speedX = ran.nextInt(10) + 1; // +1 because it has to move somehow
		speedY = ran.nextInt(10) + 1;
		background_color = DEFAULT_BACKGROUND_COLOR;
	}
	public Ball(Container container, int pX, int pY) {
		Random ran = new Random();
		radius = DEFAULT_RADIUS;
		positionX = pX;
		positionY = pY;
		speedX = ran.nextInt(10) + 10; // +10: make sure > 0 and +1 is too slow.
		speedY = ran.nextInt(10) + 10;
		background_color = DEFAULT_BACKGROUND_COLOR;
	}
	public Ball(Container container, int pX, int pY, Color bg_color) {
		Random ran = new Random();
		radius = DEFAULT_RADIUS;
		positionX = pX;
		positionY = pY;
		speedX = ran.nextInt(10) + 1; // +1 because it has to move somehow
		speedY = ran.nextInt(10) + 1;
		background_color = bg_color;
	}

	public int getRadius() {
		return radius;
	}

	public double getSpeed() {
		return Math.sqrt(speedX * speedX + speedY * speedY);
	}

	public int[] getSpeedVector() {
		int[] vec = {speedX, speedY};
		return vec;
	}

	public void draw(Graphics g) {
		g.setColor(background_color);
		// g.fillOval(upperLeftX, upperLeftY, totalWidth, totalHeight);
		g.fillOval((int)(positionX - radius), (int)(positionY - radius), (int)(2 * radius), (int)(2 * radius));
	}

	public void move(Container container) {
		// move
		positionX += speedX;
		positionY += speedY;
		// check if collision with any of the 4 boundaries of container
		int maxX = container.getMaxX(); // the 4 boundaries of container
		int minX = container.getMinX();
		int maxY = container.getMaxY();
		int minY = container.getMinY();
		// check horizontal
		if(positionX > (maxX - radius)) {
			speedX = -speedX;
			positionX = (maxX - radius);
		} else if(positionX < (minX + radius)) {
			speedX = -speedX;
			positionX = (minX + radius);
		}
		// check vertical
		if(positionY > (maxY - radius)) {
			speedY = -speedY;
			positionY = (maxY - radius);
		} else if(positionY < (minY + radius)) {
			speedY = -speedY;
			positionY = (minY + radius);
		}
	}
}