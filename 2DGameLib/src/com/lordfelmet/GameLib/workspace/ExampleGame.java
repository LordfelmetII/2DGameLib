package com.lordfelmet.GameLib.workspace;

//Import the various java classes that we need (code written by other people)
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import com.lordfelmet.GameLib.common.GameFrame;



//Our class is called "GUIExample". It builds upon the built in java "Applet", which was written by other people.
public class ExampleGame extends GameFrame{
	
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
		
		if(pointTouchingCircle(mouse.x,mouse.y,circleX+circleRadius,circleY+circleRadius,circleRadius)){
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
		g.fillOval(mouse.x,mouse.y,10,10);
		
	    
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
	
	
	Graphics buffer;
	Image offscreen;
	
	//A timer for animation
	Timer animation=new Timer();
	
	//Set up the applet
	
	public void init(){
		super.init();
		updateSize();
		frame=0;
		//Start a timer to repaint the applet every 30 ms
		animation.schedule(new AnimateTask(this),0,30);
		offscreen=createImage(this.width,this.height);
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
	
	
	
	
}


