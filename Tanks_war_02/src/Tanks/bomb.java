package Tanks;


public class bomb{//̹�˱�ը����
	int x,y;
	int liveTime=9;//������
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
