package com.java.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.java.util.Constant;
import com.java.util.GameUtil;
import com.java.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	
	Date startTime;
	Date endTime;
	int period;
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane = new Plane("images/plane.png",50,50);
	
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	Explode explode;
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			boolean peng = b.getRect().intersects(plane.getRect());
			if(peng){
				plane.setLive(false);//�ɻ�����
				if(explode==null){
					endTime = new Date();
					explode = new Explode(plane.x,plane.y);
				}
				explode.draw(g);
				break;
			}
			/*�����Ͻ���ʾ��ʱ��
			if(!peng){
				endTime = new Date();
				period = (int)((endTime.getTime()-startTime.getTime())/1000);
				printInfo(g, 20, "Time:"+period+"s", 
						Constant.GAME_WIDTH-150, 50, Color.white);
			}
			*/
		}
		if(!plane.isLive()){
			period = (int)((endTime.getTime()-startTime.getTime())/1000);
			printInfo(g, 20, "Time:"+period+"s",
					Constant.GAME_WIDTH/3,Constant.GAME_HEIGHT/2+60,
					Color.white);
			switch(period/10){
			case 0:
			case 1:
				printInfo(g, 50, "GRADE C",
						Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,
						Color.white);
				break;
			case 2:
				printInfo(g, 50, "GRADE B",
						Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,
						Color.white);
				break;
			case 3:
				printInfo(g, 50, "GRADE A",
						Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,
						Color.white);
				break;
			case 4:
				printInfo(g, 50, "GRADE S",
						Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,
						Color.red);
				break;
			default:
			printInfo(g, 50, "GRADE SS",
					Constant.GAME_WIDTH/4,Constant.GAME_HEIGHT/2,
					Color.red);
				break;
			}
		}
	}
	
	public void printInfo(Graphics g,int size,String str,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("����",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
		
	}
	public void launchFrame(){
		super.launchFrame();
		//���ɴ��ڵ�ͬʱ����һ���ӵ�
		for (int i = 0; i < 30; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		
		//���Ӽ��̵ļ�����
		addKeyListener(new KeyMonitor());
		//�������ļ�����
		
		
		startTime = new Date();
	}
	//�����ڲ��࣬���Է���ʹ���ⲿ�����ͨ����
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
}
