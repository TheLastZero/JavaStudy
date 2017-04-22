package Tanks;

/**
 * 这里是关于坦克的原材料方向
 */

/**
 * 这里用来接收坦克出现的位置，也就是横纵坐标
 * 并且调整坦克的方向
 * @author 小钢炮-ST-PRO
 *
 */
public class Tank{
	//这里的x，y代表坦克的横纵坐标
	int x=0,y=0;
	//坦克的方向,0上，1左，2右，3下
	int direction=0;
	//坦克的移动速度
	int speed=10;
	//给敌人坦克加一个生命值
	boolean EnemyTankLife=true;


	//封装坦克的方向和速度
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//用get和set封装x，y，以后的变量基本上都要封装，使用函数比直接使用变量要安全
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
	Tank(int x,int y){//构造方法
		this.x=x;
		this.y=y;
	}
}
