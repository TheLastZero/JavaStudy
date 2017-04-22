package Tanks;

import java.util.Vector;

import Tanks.Tank;
import Tanks.ball;

public class MyTank extends Tank{

	//声明一个集合类来装子弹，并且声明一个子弹类的对象
	Vector<ball> aa =new Vector<ball>();
	ball zd=null;
	/**
	 * 我的坦克和敌人的坦克都有一些共同的属性方法，
	 * 把这些写在坦克类里，然后继承它
	 * 如果我还想对我的坦克进行更改，这里还可以进行覆盖
	 * 因为子弹是跟着坦克走的，所以子弹的功能大多都和坦克类有关
	 * @param x
	 * @param y
	 */
	public MyTank(int x,int y){
		super(x,y);
	}
	public void fire(){//发射子弹的方法
		switch(this.direction){
		case 0://坦克头对着上面子弹的方向
			zd=new ball(x+15,y-25,direction);//这个x，y是坦克的位置
			aa.add(zd);//每发射一次子弹，都添加一颗子弹到名为aa的集合类里
			break;
		case 1://坦克头对着左边
			zd=new ball(x-28,y+15,direction);
			aa.add(zd);
			break;
		case 2://坦克头对着右边
			zd=new ball(x+75,y+15,direction);
			aa.add(zd);
			break;
		case 3://坦克头对着下面
			zd=new ball(x+15,y+75,direction);
			aa.add(zd);
			break;
		}
		//new一个线程来发射子弹
		Thread t=new Thread(zd);
		t.start();
	}
	
	
	public void up(){
		y-=speed;
	}
	public void down(){
		y+=speed;
	}
	public void left(){
		x-=speed;
	}
	public void right(){
		x+=speed;
	}
}