package TankW;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * 坦克大战
 */


/**
 * 这一块用来声明一个画板，并且初始化窗口
 * @author 小钢炮-ST-PRO1
 *
 */
public class Tank1 extends JFrame implements ActionListener{
	//实现接口,也就是对组件比如说按钮的监听

	MyPanel mp=null;

	Nitrometris gk=null;//定义一个,关卡面板

	JMenuBar cdl=null;//菜单面板，用来放菜单的
	JMenu cd01=null;//游戏菜单
	JMenuItem cdxl= null;//游戏菜单里的二级菜单条目,可以有多个,这个是新游戏
	JMenuItem cdx2=null;//游戏（G）的二级菜单退出游戏
	JMenuItem cdx3=null;//游戏（G）的二级菜单存盘退出
	JMenuItem cdx4=null;//游戏（G）的二级菜单继续游戏

	public static void main(String[] args) {
		Tank1 t1=new Tank1();
	}
	public Tank1(){
			
		cdl=new JMenuBar();
		cd01=new JMenu("游戏(G)");
		cd01.setMnemonic('G');//设置游戏的快捷键
		cdxl=new JMenuItem("新游戏（N）");//游戏菜单的二级菜单
		cdxl.setMnemonic('N');
		cdx2=new JMenuItem("退出游戏(E)");
		cdx2.setMnemonic('E');
		cdx3=new JMenuItem("存盘退出(C)");
		cdx3.setMnemonic('C');
		cdx4=new JMenuItem("继续游戏(S)");
		cdx4.setMnemonic('S');

		cdx4.addActionListener(this);
		cdx4.setActionCommand("goOnGame");//继续游戏组件
		cdx3.addActionListener(this);
		cdx3.setActionCommand("saveExit");//存盘退出
		cdx2.addActionListener(this);
		cdx2.setActionCommand("exit");//退出游戏
		cdxl.addActionListener(this);//开始监听,也就是对组件比如说按钮的监听
		cdxl.setActionCommand("NewGame");//这是一个类似HTML里的id，用来区分组件，按钮
		
		cd01.add(cdxl);
		cd01.add(cdx2);
		cd01.add(cdx3);
		cd01.add(cdx4);
		cdl.add(cd01);
		this.setJMenuBar(cdl);



		gk=new Nitrometris();//new一个关卡类的对象

		//new一个关卡面板的线程，并且开启，关卡字样就会有闪烁的效果
		Thread t1=new Thread(gk);
		t1.start();

		this.add(gk);//添加第一关的关卡面板

		//添加图片至左上角
		ImageIcon tp1=new ImageIcon("/2.png");
		this.setIconImage(tp1.getImage());
		this.setTitle("坦克大战");
		this.setSize(1100,900);
		this.setLocation(400, 50);
		this.setResizable(false);//不允许用户改变窗口的界面
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//实现ActionListener接口就必须实现它的方法	
		if(e.getActionCommand().equals("NewGame")){
			//如果等于新游戏（NewGame）就把游戏界面new出来
			mp=new MyPanel("NewGame");
			
			this.remove(gk);//new新面板的同时删除旧面板

			this.add(mp);
			//在面板mp中加入对键盘的监听
			this.addKeyListener(mp);

			//开启一个线程，没有这个子弹无法流畅射出
			Thread t=new Thread(mp);
			t.start();
			this.setVisible(true);
		}else if(e.getActionCommand().equals("goOnGame")){
			//如果点击继续游戏组件
			mp=new MyPanel("goOnGame");//new一个继续游戏的新面板出来，new出来的是上次保存的界面
			Thread t=new Thread(mp);
			t.start();
			
			
			this.remove(gk);//删除关卡面板
			this.add(mp);//添加当前面板
			this.addKeyListener(mp);//添加键盘监听
			this.setVisible(true);//显示窗口
			
		}else if(e.getActionCommand().equals("saveExit")){
			//如果点击存盘退出组件
			Notes jl=new Notes();//new一个记录的对象
			jl.ETank(mp.ETank);//将面板里的Vector敌方坦克类传递过去使用ETank方法
			jl.saveGame();
			System.exit(0);//退出系统
		}else if(e.getActionCommand().equals("exit")){
			//如果点击退出游戏
			
			Notes.saveNotes();//运行一次保存杀敌数量的方法来保存记录
			System.exit(0);//退出系统
		}
	}
}

/**
 * 关卡面板类，实现Runnable线程接口
 * 做成线程类以后，第一关的字样，可以不停的闪烁
 * @author 小钢炮-ST-PRO
 *
 */
class Nitrometris extends JPanel implements Runnable{

	int times=0;

	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0,900,700);

		if(times%2==0){//time位偶数时才进来写第一关，所以会出现闪烁的效果
			g.setColor(Color.yellow);
			Font MyFont=new Font("华文行楷",Font.BOLD,38);//斜体，字号
			//设置字体
			g.setFont(MyFont);
			g.drawString("第一关",400, 300);//后两个是画出来的位置
		}
	}

	public void run() {
		while(true){
			try{
				Thread.sleep(400);//让线程休眠一下,就是闪烁间隔的时间
			}catch(Exception e){

			}
			times++;
			this.repaint();//重绘
		}
	}

}




/**
 * 这个类用来画坦克，坦克有方向，也有颜色，还有位置
 * @author 小钢炮-ST-PRO
 *
 */
class MyPanel extends JPanel implements KeyListener,Runnable{//实现键盘,线程接口
	MyTank mt=null;//我的坦克
	/**
	 * 用Vector集合类来装enemyTank敌人的坦克,Vector是多线程
	 * 因为敌人的坦克要完全随机
	 * 这里使用泛型，方便之后调用方法不用强转
	 */
	Vector<enemyTank> ETank=new Vector<enemyTank>();//敌人的坦克
	
	Vector<bomb> bo=new Vector<bomb>();//这个集合类用来装爆炸的图片,以便于切换
	int ETankSum=3;//敌方坦克数量
	
	//声明一个位置记录的集合类来装，Notes数据记录里的坦克位置文件
	Vector<position> wzjh=null;
	
	//声明三张坦克爆炸的图片
	Image tp1=null;
	Image tp2=null;
	Image tp3=null;


	public MyPanel(String s){
		//这里new出来的是我的坦克的位置
		mt=new MyTank(425,570);
		if(s.equals("NewGame")){//如果是新游戏的组件new出来的面板，则进行以下的初始化
			
		//用for循环new出敌人的坦克,然后用Etank装起来,int是敌人坦克的数量
		for(int i=0;i<ETankSum;i++){
			//(i)*181+5,0是敌人坦克的横纵坐标
			enemyTank ET=new enemyTank((i)*400+20,20);		
			//画出一辆坦克，启动一遍线程,坦克就会自己动了
			Thread t=new Thread(ET);
			t.start();
			//开启敌方坦克的子弹线程
			ball zd=new ball(ET.x+15,ET.y-25,ET.direction);
			Thread t3=new Thread(zd);
			t3.start();

			ETank.add(ET);
		}
		//加载三张坦克爆炸的图片
		tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp1.png"));
		tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp2.png"));
		tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp3.png"));

		}else if(s.equals("goOnGame")){//如果选择的是继续游戏
			/**
			 * Notes.readNotes();
			 * 读取上一次杀敌数量的记录，不用担心之前是否有txt文件在记录数据，
			 * 因为我们用了try...catch，就算有异常程序也会继续 
			 */
			//用之前声明的集合类来装，Notes数据记录里的坦克位置文件
			wzjh = Notes.readNotes();
			
			for(int i=0;i<wzjh.size();i++){
				position wz=wzjh.get(i);
				
				//敌人坦克的横纵坐标,方向从wz里读取
				enemyTank ET=new enemyTank(wz.x,wz.y);
				ET.setDirection(wz.direction);
				
				//画出一辆坦克，启动一遍线程,坦克就会自己动了
				Thread t=new Thread(ET);
				t.start();
				//开启敌方坦克的子弹线程
				ball zd=new ball(ET.x+15,ET.y-25,ET.direction);
				Thread t3=new Thread(zd);
				t3.start();
				ETank.add(ET);
			}
			//加载三张坦克爆炸的图片
			tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp1.png"));
			tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp2.png"));
			tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp3.png"));
		}
		
		//加载音频文件,./代表根目录，无论我音频文件放在c盘还是D盘都可以读到
		music ms=new music("./src/游戏原声-FC《坦克大战》战前BGM - 铃声.wav");
		ms.start();
	}         
	
	public void NoteData(Graphics g){//统计数据的方法
		//画两个坦克作为标志
		this.drawTank(200, 730, g,0,0);
		g.setColor(Color.BLACK);
		//整形数据在后面加上字符串，会把整形数据转换成字符串
		g.drawString(Notes.getMTank()+" ", 260, 760);
		
		this.drawTank(300, 730, g,0,1);
		g.setColor(Color.black);
		g.drawString(Notes.getETsum()+" ",360,760);
		
		this.drawTank(920, 100, g,0,1 );
		g.setColor(Color.BLACK);
		g.drawString(Notes.getDieETSum()+" ", 980, 130);//画消灭坦克的总数量的字符串文字
		Font f=new Font("华文彩云",Font.BOLD,20);
		g.setFont(f);
		g.drawString("您消灭的坦克总数",910, 50);
	}
	
	public void paint(Graphics g){


		super.paint(g);
		//绘制画布，默认为黑色填充色，大小为900,700
		g.fillRect(0, 0, 900, 700);
		//调用绘制坦克的函数drawTank

		//这里画自己的坦克,前两个是横纵坐标，第三个是坦克头的方向，第四个是颜色类型
		if(mt.EnemyTankLife){//判断自己的生命是否为true
			this.drawTank(mt.getX(), mt.getY(), g,mt.direction, 0);
		}
		//这里new敌人
		for(int i=0;i<ETank.size();i++){
			if(ETank.get(i).EnemyTankLife){
				this.drawTank(ETank.get(i).getX(),ETank.get(i).getY(), g,ETank.get(i).direction, 1);
				ETank.get(i).ETank(ETank);//将这个类里的ETank集合里的全部东西，传递给enemyTank类中的敌方坦克集合类
			}else{
				ETank.remove(i);
			}	
		}

		/**
		 * 画敌方坦克的子弹
		 */
		for(int j=0;j<ETank.size();j++){
			for(int i=0;i<ETank.get(j).Eball.size();i++){//这一层循环是画ETank.get(j)坦克的子弹,并且遍历这个子弹的集合
				//声明一个子弹类的对象来接收ETank(敌方的坦克)的名为Eball的Vector集合类的子弹
				ball zd=ETank.get(j).Eball.get(i);

				if(zd!=null&&zd.life==true){
					/**
					 * 子弹的数量不为空并且生命等于true的时候才可以发射
					 * 生命为0的意思就是当子弹超出规定的画布大小，就自己消失
					 */
					g.setColor(Color.white);
					//用圆形做子弹
					g.fillOval(zd.x, zd.y,10, 10);
				}
				if(zd.life==false){
					/**
					 * aa是我们创建的一个用来装子弹的Vector集合类
					 * 子弹碰到墙的时候变成false，变成false时我们就删除
					 * 这样一次性我们最多打八颗子弹
					 */
					ETank.get(j).Eball.remove(zd);
				}
			}
		}

		/**
		 * 画我的坦克的子弹
		 * mt.aa.size()是子弹集合类的大小，也就是有多少
		 */
		for(int i=0;i<mt.aa.size();i++){
			//声明一个子弹类的对象来接收mt(我的坦克)的名为aa的Vector集合类的子弹
			ball zd=mt.aa.get(i);

			if(zd!=null&&zd.life==true){
				/**
				 * 子弹的数量不为空并且生命等于true的时候才可以发射
				 * 生命为0的意思就是当子弹超出规定的画布大小，就自己消失
				 */
				g.setColor(Color.white);
				//用圆形做子弹
				g.fillOval(zd.x, zd.y,10, 10);
			}
			if(zd.life==false){
				/**
				 * aa是我们创建的一个用来装子弹的Vector集合类
				 * 子弹碰到墙的时候变成false，变成false时我们就删除
				 * 这样一次性我们最多打八颗子弹
				 */
				mt.aa.remove(zd);
			}
		}

		for(int i=0;i<bo.size();i++){//我的坦克击中敌方时，敌方坦克单位应该启动爆炸方法
			System.out.println("开始爆炸");
			bomb bz=bo.get(i);
			System.out.println("bz.liveTime为"+bz.liveTime);
			if(bz.liveTime>6){
				//前两个是坐标，后两个是横纵长度
				g.drawImage(tp1,bz.x,bz.y,60,60,this);
			}else if(bz.liveTime>3){
				g.drawImage(tp2,bz.x,bz.y,60,60,this);
			}else{
				g.drawImage(tp3,bz.x,bz.y,60,60,this);
			}
			System.out.println("启动了live方法");
			bz.live();//启动让lifeTime减少的方法
			if(bz.liveTime==0){//生存期等于零时，就去掉爆炸
				bo.remove(bz);
			}
		}

		NoteData(g);//调用统计数据的方法
	}

	/**
	 * 我的坦克打击敌人坦克时
	 */
	public void hitETank1(){
		for(int i=0;i<mt.aa.size();i++){//我的坦克每取出一颗子弹
			ball zd=mt.aa.get(i);
			if(zd.life){
				for(int j=0;j<ETank.size();j++){//每颗子弹和每个敌人坦克进行坐标比较
					enemyTank ET=ETank.get(j);
					if(ET.EnemyTankLife){//敌方坦克的生命值是否为true
						if(this.hitTank(zd, ET)){//敌方坦克是否被击中
							Notes.ETReduce();//更改敌方坦克数量，减少的方法
							Notes.dieETSum();//改变消灭敌人总数的数量
						}
					}
				}
			}
		}
	}
	/**
	 * 敌人的坦克打击我时
	 */
	public void hitMTank1(){
		for(int i=0;i<ETank.size();i++){
			enemyTank ET=ETank.get(i);
			if(ET.EnemyTankLife){
				for(int j=0;j<ET.Eball.size();j++){//每颗子弹和每个敌人坦克进行坐标比较
					ball zd=ET.Eball.get(j);
					if(ET.EnemyTankLife){
						if(this.hitTank(zd, mt)){
							Notes.MTankReduce();//使己方坦克的数量减一的方法
						}
						
					}
				}
			}
		}
	}

	public boolean hitTank(ball zd,Tank ET){
		/**
		 * 击中地敌方的函数,接收的是子弹，和敌方坦克的生命值
		 * 当子弹的坐标，在坦克的坐标范围内，两个就一起消失
		 */
		boolean b2=false;
		switch(ET.direction){
		//0和2不写break就可以一直往下执行，这样只要写竖着和横着的两个方向坦克就好了
		case 0:;
		case 3:
			if(zd.x>ET.getX()&&zd.x<ET.x+30&&zd.y>ET.y-10&&zd.y<ET.y+60){
				System.out.println("执行3内部False");
				zd.life=false;
				ET.EnemyTankLife=false;
				b2=true;
				//new一个爆炸的对象one，然后加入到BO的爆炸集合类里
				bomb one =new bomb(ET.x, ET.y);
				bo.add(one);
				ETank.remove(this);
			}
			break;
		case 1:;
		case 2:
			if(zd.x>ET.x&&zd.x<ET.x+60&&zd.y>ET.y&&zd.y<ET.y+60){
				zd.life=false;
				ET.EnemyTankLife=false;
				b2=true;
				bomb one =new bomb(ET.x, ET.y);
				bo.add(one);
				ETank.remove(this);
			}
			break;
		}
		return b2;
	}

	/**
	 * 绘制坦克的函数
	 * 传x，y横纵坐标过来
	 * 传一个Graphics g画笔过来,不能直接创建新画笔，因为新画笔和原来的画笔没有关系
	 * 传一个方向direction过来
	 * 传一个类型type过来
	 */
	public void drawTank(int x,int y,Graphics g,int direction,int type){
		//用switch区分坦克的类型，0代表我的坦克，1代表敌人的坦克
		switch(type){
		case 0:
			g.setColor(Color.yellow);;
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		//switch来区分方向,就是坦克头对着的方向
		switch(direction){//画坦克的实体
		case 0://坦克头对着上
			g.fill3DRect(x, y, 10,60, false);
			g.fill3DRect(x+30, y, 10,60, false);
			g.fill3DRect(x+10, y+10, 20,40, false);
			g.fillOval(x+10,y+20,20,20);
			g.drawLine(x+20,y+30,x+20,y-10 );
			break;
		case 1://坦克头对着左边
			g.fill3DRect(x, y, 60,10, false);
			g.fill3DRect(x, y+30, 60,10, false);
			g.fill3DRect(x+10, y+10, 40,20, false);
			g.fillOval(x+20,y+10,20,20);
			//使用当前颜色在上下文的坐标系中坐标（x1,y1）,(x2,y2)之间画一条线
			g.drawLine(x+30,y+20,x-10,y+20);
			break;
		case 2://坦克头对着右边
			g.fill3DRect(x, y, 60,10, false);
			g.fill3DRect(x, y+30, 60,10, false);
			g.fill3DRect(x+10, y+10, 40,20, false);
			g.fillOval(x+20,y+10,20,20);
			//使用当前颜色在上下文的坐标系中坐标（x1,y1）,(x2,y2)之间画一条线
			g.drawLine(x+40,y+20,x+70,y+20);
			break;
		case 3://坦克头对着下面
			g.fill3DRect(x, y, 10,60, false);
			g.fill3DRect(x+30, y, 10,60, false);
			g.fill3DRect(x+10, y+10, 20,40, false);
			g.fillOval(x+10,y+20,20,20);
			g.drawLine(x+20,y+70,x+20,y+30 );
			break;
		}
	}
	public void keyTyped(KeyEvent e){
		//有字符输出的函数， 键入某个键时调用此方法。
	}
	public void keyPressed(KeyEvent e){
		//键盘按下的作用
		if(e.getKeyCode()==KeyEvent.VK_W){
			//向上移动，把方向调整为上,在调用up方法来移动坦克
			this.mt.setDirection(0);
			this.mt.up();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			//向下移动
			this.mt.setDirection(3);
			this.mt.down();
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			//向左移动
			this.mt.setDirection(1);
			this.mt.left();
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.mt.setDirection(2);
			this.mt.right();
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			//如果子弹发射的面板上没有8个，就继续发射，到8个以后就不能发射
			//这样一次性我们最多打八颗子弹,最老版的魂斗罗就是这种子弹机制
			if(this.mt.aa.size()<8){
				this.mt.fire();
			}
		}
		//重新启动Paint,刷新后重绘，就可以看到坦克的移动
		this.repaint();
	}
	public void keyReleased(KeyEvent e){
		//键盘抬起以后的作用
	}
	public void run(){//覆盖Runnable线程接口的run方法
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){

			}
			/**
			 * 用二层循环的目的是，让每一发子弹和每个敌人坦克比较坐标
			 */
			hitETank1();
			hitMTank1();
			this.repaint();
		}
	}
}