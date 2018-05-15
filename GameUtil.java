package com.java.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 游戏开发中常用的工具类（比如：加载图片等方法）
 * @author asus
 *
 */
public class GameUtil {
	
	private GameUtil(){}	//工具类通常会构造方法私有了
	
	public static Image getImage(String path){
		
		BufferedImage bi = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			bi = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
