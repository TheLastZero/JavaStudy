package Tanks;

import java.util.Vector;

import Tanks.Tank;
import Tanks.ball;
import Tanks.enemyTank;

public class enemyTank extends Tank implements Runnable{
	//这里是敌人的坦克类，也做成线程类,实现Runnable接口
	int speed=2;//敌方坦克移动的速度

	int time=0;

	public enemyTank(int x,int y){
		super(x,y);
	}

	//声明一个集合类来装敌方坦克的子弹
	Vector<ball> Eball=new Vector<ball>();
	
	//声明一个集合类，来装主类里已经声明好的坦克集合类
	Vector<enemyTank> ETank=new Vector<enemyTank>();
		
	public void ETank(Vector<enemyTank> ETank){//从主类里接收坦克的集合类
		this.ETank=ETank;
	}
	
	public boolean avoid(){//为了避免敌方坦克重叠在一起而写的躲避各自的方法
		boolean b=true;
		switch(this.direction){//判断敌方坦克的方向
		case 0:
			for(int i=0;i<ETank.size();i++){
				//从敌人坦克的集合类里取出坦克,装载在下面的ET里
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					/**
					 * 如果敌人的坦克不等于自己,
					 * 因为当前敌方坦克需要和所有的敌方坦克进行坐标是否重叠的比较
					 * 如果遍历整个坦克集合类，这其中是包括自己的，
					 * 自己和自己比较坐标肯定是重合了的，
					 * 所以在这里要不等于当前坦克，
					 * 也就是不等于自己才继续比较和别的坦克的坐标重叠
					 */
					//当前坦克头对着上方时
					if(ET.direction==0||ET.direction==3){//如果另一个敌人的坦克头是对着上或者下面
						if(this.x>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
					if(ET.direction==1||ET.direction==2){//如果另一个敌人的坦克对着左边或者右边
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							
							return false;//表示重合了，所以不行，返回false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<ETank.size();i++){
				//从敌人坦克的集合类里取出坦克,装载在下面的ET里
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//如果另一个敌人的坦克头是对着上或者下面
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
					if(ET.direction==1||ET.direction==2){//如果另一个敌人的坦克对着左边或者右边
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							
							return false;//表示重合了，所以不行，返回false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<ETank.size();i++){
				//从敌人坦克的集合类里取出坦克,装载在下面的ET里
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//如果另一个敌人的坦克头是对着上或者下面
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
					if(ET.direction==1||ET.direction==2){//如果另一个敌人的坦克对着左边或者右边
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							
							return false;//表示重合了，所以不行，返回false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<ETank.size();i++){
				//从敌人坦克的集合类里取出坦克,装载在下面的ET里
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//如果另一个敌人的坦克头是对着上或者下面
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//看坦克左上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
					if(ET.direction==1||ET.direction==2){//如果另一个敌人的坦克对着左边或者右边
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y+60>=ET.y&&this.y<=ET.y){//看坦克左上方的点是否在另一个坦克内
							
							return false;//表示重合了，所以不行，返回false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y+60>=ET.y&&this.y<=ET.y){//看坦克右上方的点是否在另一个坦克内
							return false;//表示重合了，所以不行，返回false
						}
					}
				}
			}
			break;
		}
		return b;
	}
	
	public void run(){
		//写while循环是因为坦克子弹一直都在活动,直到死去才停止
		//敌方坦克的移动
		while(true){
			switch(this.direction){
			case 0:
				for(int i=0;i<30;i++){
					if(y>5 && avoid()){
						/**
						 * 如果y大于0的话才移动坦克，这样可以避免敌方坦克自动走到面板外面
						 * 调用avoid方法是为了避免敌方坦克重叠在一起
						 */
						y-=speed;
					}
					try{
						//敌方坦克每走一次就休眠50毫秒
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 1:
				for(int i=0;i<30;i++){
					if(x>0 && avoid()){//如果x大于0的话才移动坦克，这样可以避免敌方坦克自动走到面板外面
						x-=speed;
					}
					try{
						//敌方坦克每走一次就休眠50毫秒
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 2:
				for(int i=0;i<30;i++){
					/**
					 * 这里要避免坦克走出右边的画布
					 * 画布为900，,700
					 * 坦克自身也有厚度为60,所以这里x要小于900-60
					 */
					if(x<820 && avoid()){
						x+=speed;
					}		
					try{
						//敌方坦克每走一次就休眠50毫秒
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 3:
				for(int i=0;i<30;i++){
					/**
					 * 这里要避免坦克走出下边的画布
					 * 画布为900，,700
					 * 坦克自身也有厚度为60,所以这里y要小于700-60
					 */
					if(y<580 && avoid()){
						y+=speed;
					}
					try{
						//敌方坦克每走一次就休眠50毫秒
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			}
			//随机出现0到3之间的数字,传递给方向											/////////////////////////////////////////////////////
			this.direction=(int)(Math.random()*4);
			if(this.EnemyTankLife==false){//坦克没有生命时就跳出走动的循环
				break;
			}
			this.time++;//加上时间，子弹发射的就比较慢
			if(time%2==0){
				if(this.EnemyTankLife){//判断敌方坦克生命是否为真
					if(Eball.size()<5){//看敌方坦克的集合类里的子弹，是否小于5颗
						ball zd=null;

						switch(this.direction){
						case 0://坦克头对着上面子弹的方向
							zd=new ball(x+15,y-25,direction);//这个x，y是坦克的位置
							Eball.add(zd);//每发射一次子弹，都添加一颗子弹到名为aa的集合类里
							break;
						case 1://坦克头对着左边
							zd=new ball(x-28,y+15,direction);
							Eball.add(zd);
							break;
						case 2://坦克头对着右边
							zd=new ball(x+75,y+15,direction);
							Eball.add(zd);
							break;
						case 3://坦克头对着下面
							zd=new ball(x+15,y+75,direction);
							Eball.add(zd);
							break;
						}
						Thread t5=new Thread(zd);
						t5.start();
					}
				}
			}
		}
	}
}
