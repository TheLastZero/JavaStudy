package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventPostProcessor;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JPanel;

public class Mpanel extends JPanel implements KeyListener,Runnable{//对键盘的监听要加在new面板的地方
	//面板为1时，就是游戏的内容进入游戏，为2时，就是GameOver的界面
	static int mp=1;
	
	int speed=10;
	
	//用来装蛇头小方块和，蛇的身子的小方块的集合类
	Vector<MySnake> Msnake=new Vector<MySnake>();
	
	//用来装所有蛇头经过的所有路径，作为让蛇身走的路
	LinkedList<MySnake> MsWay=new LinkedList<MySnake>();
	
	//先new一只蛇头小方块
	MySnake MS=new MySnake(1,1);
	
	//红色的果子
	red r=null;
	
	Mpanel(){//构造方法	
		//把蛇头方块添加进蛇的集合类里
		Msnake.add(MS);
		
		//new一个红色的果子作为单独的线程
		r=new red();
		
	}
	
	public void paint(Graphics e){
		
		if(mp==1){
		e.setColor(Color.black);
		e.fillRect(0, 0, 800,700);
		
		if(eatF()==false){//判断蛇头是否吃到了东西
			//每吃到一个方块小蛇就增加一个小方块
			//将new出来的蛇的方块放到蛇的集合类里，记录每一个方块的位置
			MySnake a=new MySnake(MS.x,MS.y);
			Msnake.add(a);
		}
		
		//画出自己的小蛇
		//蛇头
		drawMySnake(MS.x,MS.y,e);
		
		//蛇身的位置
		for(int j=1;j<Msnake.size();j++){
			/**
			 * Msnake.size()表示蛇目前有几个方块组成
			 * 每一个方块的位置都是蛇最后走过的位置
			 */
				drawMySnake(MsWay.get(MsWay.size()-j-1).x,MsWay.get(MsWay.size()-j-1).y,e);	
		}
		
		//如果果子的生命为true，就画一个红色的果子
		if(r.life){
			this.drawRed(e);
		}
		
	}else if(mp==2){//mp==2的时候显示退出游戏
		e.setColor(Color.red);
		e.fillRect(0, 0, 800,700);
		
		e.setColor(Color.BLACK);
		Font f=new Font("华文彩云",Font.BOLD,100);
		e.setFont(f);
		e.drawString("GameOver",150,300);
		Font f2=new Font("宋体",Font.BOLD,30);
		e.setFont(f2);
		e.drawString("按下回车重新开始游戏",240,350);
	}
	}
	
	void drawMySnake(int x,int y,Graphics e){
		e.setColor(Color.blue);
		//自己小蛇的位置，大小
		e.fillRect(x,y,20,20);
	}
	
	void drawRed(Graphics e){
		//new一个红色的果子作为单独的线程
		Thread n=new Thread(r);
		n.start();
		e.setColor(Color.red);
		e.fillOval(r.x, r.y,20,20);
	}
	
	boolean eatF(){//判断蛇是否吃到果子的方法
		//如果蛇头的位置在果子的坐标内，就让果子消失，蛇的长度增加一个方块
		if(MS.x>r.x&&MS.x<r.x+20&&MS.y>r.y&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x+20>r.x&&MS.y>r.y&&MS.x<r.x+20&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x>r.x&&MS.x<r.x+20&&MS.y+20>r.y&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x+20>r.x&&MS.y+20>r.y&&MS.x<r.x+20&&MS.y<r.y+20){
			redFile();
			return false;
		}
		return true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//按下键盘改变蛇头移动的方向
		if(e.getKeyCode()==KeyEvent.VK_W && MS.y>0 && MS.direction!=2){//如果当前是方向是上，蛇就不能向后移动
			MS.direction=0;
		}else if(e.getKeyCode()==KeyEvent.VK_S && MS.y<680 && MS.direction!=0){
			MS.direction=2;
		}else if(e.getKeyCode()==KeyEvent.VK_A && MS.x>0 && MS.direction!=1){
			MS.direction=3;
		}else if(e.getKeyCode()==KeyEvent.VK_D && MS.x<780 && MS.direction!=3){
			MS.direction=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			//按下回车重新开始游戏
			System.out.println("重新开始");
			//重置蛇的位置和长度,还有方向,还有速度
			MS.x=1;
			MS.y=1;
			MS.direction=1;
			speed=10;
			Msnake.removeAll(Msnake);
			Msnake.add(MS);
			System.out.println(Msnake.size());
			mp=1;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_P){
			speed+=5;
		}else if(e.getKeyCode()==KeyEvent.VK_O){
			if(speed!=10){
				speed-=5;
			}
		}
		this.repaint();
	}
	
	void movid(){//蛇头移动的方法
		r.life=eatF();
		//将蛇走的所有的路都用对象保存坐标，加入到集合类里
		MySnake m=new MySnake(MS.x,MS.y);
		
		MsWay.add(m);
		//判断蛇是否碰到墙或者自己，碰到的话就死亡,进入GameOver界面
		died();
		
		if(MS.direction==0 && MS.y>0){//上
			MS.y-=speed;
		}else if(MS.direction==2 && MS.y<680){
			MS.y+=speed;
		}else if(MS.direction==3 && MS.x>0){
			MS.x-=speed;
		}else if(MS.direction==1 && MS.x<780){
			MS.x+=speed;
		}
	}
	
	
	void redFile(){//如果果子new在了蛇的身体上
		
		boolean f1=true;
		
		while(f1){
		r.Random();
		System.out.println("new好随机数");
		for(int j=0;j<Msnake.size();j++){
			if(r.x+10>MsWay.get(MsWay.size()-j-1).x&&r.x+10<MsWay.get(MsWay.size()-j-1).x+20
					&&r.y+10>MsWay.get(MsWay.size()-j-1).y&&r.y+10<MsWay.get(MsWay.size()-j-1).y+20){
				//如果果子在这个范围内，就重new，否则就跳出
				System.out.println("在蛇的身体里");
				f1=true;
			}else{
				if(j==Msnake.size()-1){
					f1=false;
					
				}
			}	
		}
		}
	}
	void died(){
		//判断蛇是否碰到墙或者自己，碰到的话就死亡,进入GameOver界面
		if(MS.x<=0||MS.x>=781||MS.y<=0||MS.y>=681){//这里判断是否会碰到墙
			mp=2;
		}
		
		//如果蛇头的上方碰到自己的身体，就死掉
		for(int i=1;i<Msnake.size();i++){//判断蛇是否会碰到自己的身体,i从1开始是因为1是蛇头自己
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y>MsWay.get(MsWay.size()-j-1).y&&MS.y<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//如果蛇头的左边碰到自己的身体，就死掉
		for(int i=1;i<Msnake.size();i++){//判断蛇是否会碰到自己的身体,i从1开始是因为1是蛇头自己
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x>MsWay.get(MsWay.size()-j-1).x&&MS.x<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//如果蛇头的右边碰到自己的身体，就死掉
		for(int i=1;i<Msnake.size();i++){//判断蛇是否会碰到自己的身体,i从1开始是因为1是蛇头自己
			if(MS.x+20>MsWay.get(MsWay.size()-i-1).x&&MS.x+20<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//如果蛇头的下边碰到自己的身体，就死掉
		for(int i=1;i<Msnake.size();i++){//判断蛇是否会碰到自己的身体,i从1开始是因为1是蛇头自己
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y+20>MsWay.get(MsWay.size()-i-1).y&&MS.y+20<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(50);
				this.movid();
			}catch(Exception e){
				
			}
			this.repaint();
		}
	}
}