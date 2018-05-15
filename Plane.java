package com.java.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.java.util.GameUtil;

public class Plane extends GameObject{
	int speed = 8;
	private boolean left,right,up,down;
	//如果一个left为true的话x减少，如果right为true的话y减少，如果两个为true的话,两个都减少，这样就实现了八个方向的控制
	private boolean live = true;
	public void draw(Graphics g){
		if(live){
			g.drawImage(img, (int)x, (int)y, null);
			move();
		
	}
	public void move(){
		if(left){
			x-=speed;
		}
		if(up){
			y-=speed;
		}
		if(right){
			x+=speed;
		}
		if(down){
			y+=speed;
		}
	}
	
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		}
	}
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		}
	}
	public Plane(String imgpath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	public Plane(){
		
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}
