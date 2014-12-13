package com.lordfelmet.GameLib.common;

import java.applet.Applet;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.TimerTask;

import com.lordfelmet.GameLib.workspace.ExampleGame;

public class GameFrame  extends Applet implements MouseListener,MouseMotionListener, KeyListener{
	public int width,height,frame;
	public Point mouse = new Point(0,0);
	
	public void init(){
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
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
		mouse.x=arg0.getX();
		mouse.y=arg0.getY();
	}
	
	public class AnimateTask extends TimerTask{
		//The timer task needs to know what applet to animate
		ExampleGame appletReference;
		public AnimateTask(ExampleGame appletReference){
			this.appletReference=appletReference;
		}
		
		public void run() {
			appletReference.repaint();
		}
		
	}
	

}
