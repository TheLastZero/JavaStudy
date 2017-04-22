package com.plane.java;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.security.auth.kerberos.KerberosKey;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 创建一个游戏的主窗体，需要继承JFrame
 * @author 小钢炮-ST-PRO
 *
 */
public class PlaneFrame extends JFrame{
	PlanePanel jp;
	//找到目录所在的位置
	//  “\”是转义符，要显示的话要打两次
	public static String path=System.getProperty("user.dir")+"\\material\\";
	
	//准备一个容器获取所有的图片  String=图片的名字  image=图片
	public static HashMap<String,BufferedImage> maps=new HashMap<>(); 
	
	//静态块一般用来加载资源
	static{
		File[] files=new File(path).listFiles();
		for (int i = 0; i < files.length; i++) {
			//System.out.println(files[i]);
			try {
				maps.put(files[i].getName(), ImageIO.read(files[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 构造一个方法
	 * @return 
	 */
	public PlaneFrame(){
		//显示窗口的方法,为了避免窗口一闪而过 
		setVisible(true);
		//显示标题
		this.setTitle("飞机大战---zero");
		//设置窗口的大小
		this.setSize(700,800);
		//设置窗口居中
		this.setLocationRelativeTo(null);
		//设置窗口不可动
		this.setResizable(false);
		//设置窗口关闭，程序就关闭
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jp =new PlanePanel();
		//往这个容器里添加一个面板，黑板里面嵌套一块玻璃
		this.setContentPane(jp);
		//容器添加监听
		this.addKeyListener(new MykeyListener());
		
	}
	//监听
	class MykeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//调用面板里的方法
			jp.keyPressed(e);
		}
	}
	public static void main(String[] args){
		new PlaneFrame();
		//System.out.println(maps);
	}
}
/**
 * 面板，有点类似HTML的Padding,写东西贴图的区域和边沿有一定的padding的距离
 * @author 小钢炮-ST-PRO
 *
 */
class PlanePanel extends JPanel{
	//控制子弹发射的左右
	int buff=0;
	
	
	//设置背景图片的位置
	Point bgPoint = new Point(0,-800);
	
	//设置一个子弹的集合
	List<Point> list =new ArrayList<>();
	
	//飞机的位置，point是一个点（x,y）
	Point PlanePoint = new Point(300,600);
	
	public PlanePanel(){
		//启动线程
		new Thread(new BgThread()).start();
	}
	
	/**
	 * 核心方法画图   Graphics画笔
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//如果去掉父类的构造方法，会产生重叠效果
		super.paint(g);
		//设置画图的类型，以及大小
		BufferedImage image= new BufferedImage(700, 800, BufferedImage.TYPE_INT_RGB);
		//获得一个画笔
		Graphics gs = image.getGraphics();
		
		//画地图
		gs.drawImage(PlaneFrame.maps.get("map.jpg"),bgPoint.x, bgPoint.y, this);
		gs.drawImage(PlaneFrame.maps.get("map.jpg"),bgPoint.x, bgPoint.y-1600, this);
		//画飞机
		gs.drawImage(PlaneFrame.maps.get("we2.png"), PlanePoint.x, PlanePoint.y, this);
		//画子弹
		for (int i = 0; i <list.size(); i++) {
			gs.drawImage(PlaneFrame.maps.get("zidan2.png"),list.get(i).x,list.get(i).y, this);
		}
		g.drawImage(image, 0, 0, this);
		
	}
	//线程，控制图片移动
	class BgThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//不断的去改变图片的位置移动
			while(true){
				if(bgPoint.y==800){
					bgPoint.y=-800;
				}
				bgPoint.y+=1;
				
				for (int i = 0; i < list.size(); i++) {
					list.get(i).y-=8;
				}
				try {
					//每隔三十毫秒
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
				//刷新
				repaint();
			}
			
		}
		
	}
	
	//发射子弹的方法
	public void fire(){
		//每次进入这个方法，就创建一粒子弹
		if(buff==0){
			list.add(new Point(PlanePoint.x-30,PlanePoint.y-40));
			buff++;
		}else{
			list.add(new Point(PlanePoint.x+50,PlanePoint.y-40));
			buff--;
		}
		
		repaint();
	}
	
		//监听按键按下去的方法
		public void keyPressed(KeyEvent e) {
			
			// TODO Auto-generated method stub
		//	super.keyPressed(e);
			
			//判断是否为空格
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				//发射子弹的方法
				fire();
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP){
				PlanePoint.y-=10;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				PlanePoint.x+=10;
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				PlanePoint.x-=10;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				PlanePoint.y+=10;
			}

			//刷新
			repaint();
		}
	}