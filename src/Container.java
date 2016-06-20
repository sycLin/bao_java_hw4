package Bouncing;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Container {
	// fields
	public static final int DEFAULT_SIZE_X = 640;
	public static final int DEFAULT_SIZE_Y = 480;
	public static final int DEFAULT_POSITION_X = 0;
	public static final int DEFAULT_POSITION_Y = 0;
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	public static final Color DEFAULT_BORDER_COLOR = Color.BLACK;

	private int min_x; // the position of upper-left corner (min_x, min_y)
	private int min_y;
	private int max_x; // the position of lower-right corner (max_x, max_y)
	private int max_y;
	private Color background_color;
	private Color border_color;

	// methods
	// constructors
	public Container() {
		min_x = DEFAULT_POSITION_X;
		min_y = DEFAULT_POSITION_Y;
		max_x = DEFAULT_POSITION_X + DEFAULT_SIZE_X;
		max_y = DEFAULT_POSITION_Y + DEFAULT_SIZE_Y;
		background_color = DEFAULT_BACKGROUND_COLOR;
		border_color = DEFAULT_BORDER_COLOR;
	}
	public Container(int px, int py) {
		// given position x, y and size in x, y
		min_x = px;
		min_y = py;
		max_x = px + DEFAULT_SIZE_X;
		max_y = py + DEFAULT_SIZE_Y;
		background_color = DEFAULT_BACKGROUND_COLOR;
		border_color = DEFAULT_BORDER_COLOR;
	}
	public Container(int px, int py, int sx, int sy) {
		// given position x, y and size in x, y
		min_x = px;
		min_y = py;
		max_x = px + sx;
		max_y = py + sy;
		background_color = DEFAULT_BACKGROUND_COLOR;
		border_color = DEFAULT_BORDER_COLOR;
	}

	public void draw(Graphics g) {
		// draw the inner area
		g.setColor(background_color);
		g.fillRect(min_x, min_y, max_x - min_x - 1, max_y - min_y - 1);
		// draw the 4 borders
		g.setColor(border_color);
		g.drawRect(min_x, min_y, max_x - min_x - 1, max_y - min_y - 1);
	}

	public int getMinX() {
		return this.min_x;
	}
	public int getMinY() {
		return this.min_y;
	}
	public int getMaxX() {
		return this.max_x;
	}
	public int getMaxY() {
		return this.max_y;
	}
}

