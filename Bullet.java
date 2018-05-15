package com.java.plane;

import java.awt.Color;
import java.awt.Graphics;

import com.java.util.Constant;

public class Bullet extends GameObject{
	int speed = 5;
	double degree;
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 5;
		height = 5;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(y>Constant.GAME_HEIGHT-height || y<30){
			degree = -degree;
		}
		if(x<0 || x>Constant.GAME_WIDTH-width){
			degree = Math.PI-degree;
		}
		
		g.setColor(c);
	}
}
