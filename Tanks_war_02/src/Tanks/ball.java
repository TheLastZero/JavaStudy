package Tanks;


public class ball implements Runnable{
	//子弹类,将子弹做成一个线程类，因为敌人的子弹是可以随意动的
	int x,y;
	int direction;
	int speed=10;
	boolean life=true;//为false时就不再画子弹
	public ball(int x,int y,int direction){//构造方法
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	public void run(){
		/**
		 * run方法是覆盖的父类方法
		 * 创建线程时，谁调用的start方法，程序就会去自动调用run方法
		 * start在调用的时候会单开启一个线程去掉用，而不是直接调用
		 */
		while(true){
			try{
				/**
				 * 不能让子弹一直发射，要给它一点停顿，也就是睡眠一点时间
				 * 凡是线程下面的死循环里都要有个睡眠，不然程序很容易崩溃
				 */
				Thread.sleep(50);
			}catch(Exception e){

			}
			switch(direction){//根据坦克头的方向，判断子弹射出的方向
			case 0://坦克头向上
				y-=speed;
				break;
			case 1://坦克头向左
				x-=speed;
				break;
			case 2://坦克头向右
				x+=speed;
				break;
			case 3://坦克头向下
				y+=speed;
				break;
			}
			if(x<0||x>900||y<0||y>700){
				life=false;
				break;
			}
		}
	}
}
