package com.ljgj.Object;

import com.ljgj.inter.Score;

public class MyAir extends airBase implements Score{
	
	public void move(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public int getScore() {
		
		return 0;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

}
