package Snake;

import java.util.Random;

//因为果子不能随着蛇的移动而重新加载，所以要作为一个单独的线程
public class red implements Runnable{

	int x=0,y=0;//坐标
	
	int sum=0;//这是第几个红色果子
	
	boolean life=true;//果子的生命
	
	red(){//初始化果子的位置
		this.x=new Random().nextInt(780)+1;
		this.y=new Random().nextInt(660)+1;
		sum++;
	}

	void Random(){//蛇每吃到一个果子就调用一次，让果子下次出现的地方随机
		this.x=new Random().nextInt(780)+1;
		this.y=new Random().nextInt(660)+1;
		sum++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
