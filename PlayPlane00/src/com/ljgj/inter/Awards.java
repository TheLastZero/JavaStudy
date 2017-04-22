package com.ljgj.inter;

public interface Awards {//奖励接口

	//火力加倍
	public static final int awardsType1=0;
	
	//生命加1
	public static final int awardsType2=0;
	
	//获得奖励道具
	public abstract int getAwards();
}
