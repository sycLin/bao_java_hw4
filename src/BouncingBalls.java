package Bouncing;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BouncingBalls {
	
	// fields

	// GUI related
	private JFrame frame;
	private MyCanvas canvas;

	// game logic related
	private Container container;
	private ArrayList<Ball> balls;

	// monitor window closing
	class WindowMonitor extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class MyCanvas extends JPanel implements MouseListener {
		int sizeX, sizeY;

		// constructor
		public MyCanvas(int width, int height) {
			sizeX = width - 60;
			sizeY = height - 60;
			setSize(sizeX, sizeY);
			setLocation(20, 20);
			setLayout(null);
			addMouseListener(this);
		}

		public int getSizeX() {
			return sizeX;
		}

		public int getSizeY() {
			return sizeY;
		}
		
		// mouse click listener
		@Override
		public void mouseClicked(MouseEvent e) {
			System.err.println("mouse clicked on " + e.getX() + ", " + e.getY());
			System.err.println("debug...");
			addBall(e.getX(), e.getY());
			System.err.println("balls.size() = " + balls.size());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// System.err.println("mouse exited on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// System.err.println("mouse entered on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// System.err.println("mouse released on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// System.err.println("mouse pressed on " + e.getX() + ", " + e.getY());
		}

		// draw canvas
		@Override
		public void paintComponent(Graphics g) {
			// paint itself
			super.paintComponent(g);
			// paint the container
			container.draw(g);
			// paint the ball
			for(int i=0; i<balls.size(); i++)
				balls.get(i).draw(g);
		}
	}

	public BouncingBalls(int width, int height) {
		// initialize the JFrame
		frame = new JFrame("Bouncing Balls");
		frame.addWindowListener(new WindowMonitor());
		frame.setSize(width, height);
		frame.setLayout(null);

		// initialize the canvas
		canvas = new MyCanvas(width, height); // given the frame (width, height) here

		// initialize the Container (as big as the canvas)
		container = new Container(0, 0, canvas.getSizeX(), canvas.getSizeY());
		
		// initialize the balls
		balls = new ArrayList<Ball>();

		// display frame
		frame.setVisible(true);
		frame.add(canvas);
		// frame.setFocusable(true);
		// frame.setFocusTraversalKeysEnabled(false);

		// start this game
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					update();
					canvas.repaint();
					// sleep for a while
					try {
						Thread.sleep(10);
					} catch(Exception ex) {}
				}
			}
		};
		thread.start();
	}

	private void update() {
		// move the balls
		for(int i=0; i<balls.size(); i++) {
			balls.get(i).move(container);
		}
	}

	private void addBall(int px, int py) {
		System.err.println("in addBall() function...");
		// determine the color (randomly)
		Random ran = new Random();
		Color a_color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		Ball a_ball = new Ball(container, px, py, a_color);
		balls.add(a_ball);
	}

	public static void main(String[] argv) {
		BouncingBalls bb = new BouncingBalls(1280, 720);
	}
}
