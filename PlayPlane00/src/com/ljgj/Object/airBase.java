package com.ljgj.Object;

import java.awt.image.BufferedImage;

public abstract class airBase {//�з�������1
	private int x,y;//����
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

	int speed;//�ٶ�
	int width;
	int height;
	boolean Life;//����
	
	BufferedImage[] bi=new BufferedImage[2];
	
	public abstract void move(int x,int y);
}