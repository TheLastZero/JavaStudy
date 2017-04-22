package TankW;

import java.io.*;
import java.util.Vector;


//导入音频文件的包
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


/**
 * 这里是关于坦克的原材料方向
 */

/**
 * 这里用来接收坦克出现的位置，也就是横纵坐标
 * 并且调整坦克的方向
 * @author 小钢炮-ST-PRO
 *
 */
class Tank{
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

class enemyTank extends Tank implements Runnable{
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

class MyTank extends Tank{

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

class ball implements Runnable{
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

class bomb{//坦克爆炸的类
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
    
class Notes{//记录敌我坦克数量的类
	private static int ETsum=10;//敌人坦克的数量
	private static int MTank=2;//我的坦克数量
	private static int dieETSum=0;//杀敌统计的变量
	private static FileWriter fw=null;//IO流的输入流
	private static BufferedWriter bw=null;//缓冲写
	private static FileReader fr=null;//IO流的输出流
	private static BufferedReader br=null;//缓冲读取
	
	//声明一个集合类，来装主类里已经声明好的坦克集合类
	Vector<enemyTank> ETank=new Vector<enemyTank>();
		
	public void ETank(Vector<enemyTank> ETank){//从主类里接收坦克的集合类
		this.ETank=ETank;
	}
	
	//给保存的坦克的位置做一个集合类,这样就可以保存很多坦克的坐标
	static Vector<position> wzjh=new Vector<position>();
	
	
	public static void saveNotes(){//保存杀敌记录到记事本里,下次还是存在的
		try{
			fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");//保存的地址
			bw=new BufferedWriter(fw);//转换流
			/**
			 * 回车是将光标移到当前行的行首；
			 * 换行是将光标移到当前行的下一行，但还是同一列，
			 * 不会回到行首。它们合起来可以将光标移到下一行的行首，
			 * 也就是回车并换行。
			 */
			bw.write(dieETSum+"\r\n");
		}catch(Exception e){}
		finally{
			try{
				bw.close();//关闭转换流
				fw.close();//关闭输入流
			}catch(Exception e){}
		}
	}
	
	
	public static Vector<position> readNotes(){//读取从前的记录
		try{
			fr=new FileReader("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
			br=new BufferedReader(fr);
			String s=br.readLine();
			dieETSum=Integer.parseInt(s);//将读取到的结果s转化成整形,再给dieETSum
			
			while((s=br.readLine())!=null){//一行一行的读取br里的内容，有就继续，没有就跳出
				/**
				 * 用字符做间隔来确定数组元素,
				 * 假设有a" "b" "c" "这样一行话
				 * 我就以" "空格这个字符的数量作为数组的下标来间隔分块，
				 * 这样就可以分别读取一行里面的a,b,c了
				 */
				String[] sz=s.split(" ");
				//用Integer.parseInt()将读取到的字符串类型的文本转化成integer类型
				position wz=new position(Integer.parseInt(sz[0]),Integer.parseInt(sz[1]),Integer.parseInt(sz[2]));
				wzjh.add(wz);//将读取到的坦克位置数据，放到位置集合类里
			}
		}catch(Exception e){
			
		}
		finally{
			try{
				br.close();//关闭转换流
				fr.close();//关闭输出流
			}catch(Exception e){
				
			}
		}
		return wzjh;
	}
	
	public void saveGame(){//存档游戏的方法
		try{
			fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
			bw=new BufferedWriter(fw);
			bw.write(dieETSum+"\r\n");
			for(int i=0;i<ETank.size();i++){
				enemyTank ET=ETank.get(i);
				if(ET.EnemyTankLife){//如果坦克还活着才记录它的坐标
					String position=ET.x+" "+ET.y+" "+ET.direction+" ";
					bw.write(position+"\r\n");
				}
			}
		}catch(Exception e){
			
		}
		finally{
			try{
				bw.close();
				fw.close();
			}catch(Exception e){
				
			}
		}
	}
	
	
	public static int getDieETSum() {
		return dieETSum;
	}
	public static void setDieETSum(int dieETSum) {
		Notes.dieETSum = dieETSum;
	}
	public static int getETsum() {
		return ETsum;
	}
	public static void setETsum(int eTsum) {
		ETsum = eTsum;
	}
	public static int getMTank() {
		return MTank;
	}
	public static void setMTank(int mTank) {
		MTank = mTank;
	}
	
	public static void ETReduce(){//敌人坦克减少的类
		ETsum--;
	}
	public static void MTankReduce(){//敌人坦克减少的类
		MTank--;
	}
	public static void dieETSum(){//杀敌统计的类
		dieETSum++;
	}
}

class position{//坦克的位置类
	int x;
	int y;
	int direction;
	public position(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}	
}

class music extends Thread{//播放声音的时候不能中断其他的动作，所以做成线程类
	private String FileName;//文件名
	public music(String ypwj){//音频文件
		FileName=ypwj;
	}
	public void run(){//线程类得重写的run方法
		
		File wjl=new File(FileName);//用文件流来接收文件名
		
		AudioInputStream musicInput=null;//音频输入流
		
		try{
			//把音频文件输入进来
			musicInput =AudioSystem.getAudioInputStream(wjl);
		}catch(Exception e){
			
		}
		
		//这里对音频文件进行格式处理,这是一个固定格式
		AudioFormat format=musicInput.getFormat();
		SourceDataLine aqsj=null;
		DataLine.Info info=new DataLine.Info(DataLine.class, format);
		
		try{
			//对文件进行一个安全性的格式化的包装
			aqsj=(SourceDataLine) AudioSystem.getLine(info);
			aqsj.open(format);
		}catch(Exception e){
			
		}
		aqsj.start();
		
		int zjtj=0;
		
		byte[] hczj=new byte[1024];//缓冲字节
		
		try{
			while(zjtj!=-1){//不等于-1表示文件读取完了
				zjtj=musicInput.read(hczj,0,hczj.length);
				if(zjtj>0){
					//下标零开始，最后一次hczj.length里有多少就读多少
					aqsj.write(hczj,0,zjtj);
				}
			}
		}catch(Exception e){
			
		}
		finally{
			aqsj.drain();//将残留部分处理干净
			aqsj.close();
		}
		
	}
}