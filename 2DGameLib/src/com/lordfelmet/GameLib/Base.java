package com.lordfelmet.GameLib;

//Import the various java classes that we need (code written by other people)
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//Our class is called "GUIExample". It builds upon the built in java "Applet", which was written by other people.
public class Base extends Applet implements MouseListener,MouseMotionListener, KeyListener{
	
	/* YOU CAN CHANGE THESE VARIABLES:
	 * 
	 */
	
	int hits=0;
	int circleX=0;
	int circleY=0;
	int circleRadius=100;
	int circleSpeed=5;
	
	public void bufferedpaint(Graphics g){
				
		/*
		 * START EDITING THE CODE HERE :
		 * 
		 * VARIABLES WE GAVE YOU:
		 * 
		 * frame: increases by 30 every second
		 * width: the applet width
		 * height: the applet height
		 * mouseX: the x position of the user's mouse
		 * mouseY: the y position of the user's mouse
		 * 
		 * METHODS WE GAVE YOU:
		 * 
		 * pointTouchingCircle(int pointX, int pointY, int circleCenterX, int circleCenterY, int radius):
		 * 		tells if a point touches a circle 
		 * 
		 */
		
		//Draw the number of hits
		g.setColor(Color.BLACK);
		g.drawString("Hits: "+hits,50,50);
		
		//Check if the user�s mouse is touching the circle
		
		if(pointTouchingCircle(mouseX,mouseY,circleX+circleRadius,circleY+circleRadius,circleRadius)){
			hits++;
		}
		
		//Move the circle and have it wrap around the screen
		circleX+=circleSpeed;
		circleY+=circleSpeed;
		if(circleX>width)circleX=0;
		if(circleY>height)circleY=0;
			
		//Draw the circle and mouse
		g.setColor(Color.RED);
		g.fillOval(circleX,circleY,circleRadius,circleRadius);
		
		g.setColor(Color.GREEN);
		g.fillOval(mouseX,mouseY,10,10);
		
	    
	    /*
	     * STOP EDITING CODE
		 * 
		 * 
		 * 
		 * 
		 * YOU DON'T NEED TO EDIT CODE BELOW THIS LINE
		 * 
		 * It's beyond our scope, and we don't have time to talk about it. If you want to, feel free
		 * to ask us about what's going on.
		 *  
		 * 
		 * 
		 */
		
		
		
		frame++;
	}
	
	//Declare some variables
	int width,height,frame;
	int mouseX=0,mouseY=0;
	Graphics buffer;
	Image offscreen;
	
	//A timer for animation
	Timer animation=new Timer();
	
	//Set up the applet
	
	public void init(){
		updateSize();
		frame=0;
		//Start a timer to repaint the applet every 30 ms
		animation.schedule(new AnimateTask(this),0,30);
		//Add the listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		offscreen=createImage(width,height);
		buffer = offscreen.getGraphics();
	}

	public void paint(Graphics g){
		updateSize();
		buffer.clearRect(0, 0, width, height);
		bufferedpaint(buffer);
		g.drawImage(offscreen, 0, 0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public boolean pointTouchingCircle(int pointX, int pointY, int circleCenterX, int circleCenterY, int radius){
		return Math.sqrt(Math.pow(pointX-circleCenterX,2)+Math.pow(pointY-circleCenterY,2))<radius;
	}
	
	public void updateSize(){
		width=getSize().width;
		height=getSize().height;
	}
	
	
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseMoved(MouseEvent arg0) {
		mouseX=arg0.getX();
		mouseY=arg0.getY();
	}

	private class AnimateTask extends TimerTask{
		//The timer task needs to know what applet to animate
		Base appletReference;
		public AnimateTask(Base appletReference){
			this.appletReference=appletReference;
		}
		
		public void run() {
			appletReference.repaint();
		}
		
	}
	
}

