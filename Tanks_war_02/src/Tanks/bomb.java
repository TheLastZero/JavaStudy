package Tanks;


public class bomb{//坦克爆炸的类
	int x,y;
	int liveTime=9;//生存期
	boolean life=true;
	public bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void live(){
		if(liveTime>0){
			liveTime--;
		}else {
			this.life=false;
		}
	}
}
