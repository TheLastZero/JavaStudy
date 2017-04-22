package com.ljgj.Object;

import java.awt.image.BufferedImage;

public abstract class airBase {//敌方飞行物1
	private int x,y;//坐标
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int speed;//速度
	int width;
	int height;
	boolean Life;//生命
	
	BufferedImage[] bi=new BufferedImage[2];
	
	public abstract void move(int x,int y);
}