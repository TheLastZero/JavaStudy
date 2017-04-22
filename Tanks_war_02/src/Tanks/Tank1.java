package Tanks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Tanks.Nitrometris;
import Tanks.Notes;
import Tanks.Tank1;

/**
 * 这一块用来声明一个画板，并且初始化窗口
 * @author 小钢炮-ST-PRO
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

		//ActionListener是监听组件的意思,组件可以有按钮
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