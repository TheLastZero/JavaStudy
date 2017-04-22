package com.ljgj;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.ljgj.Object.MyAir;
import com.ljgj.inter.Awards;
import com.ljgj.inter.Score;

public class MyPanel extends JPanel implements MouseListener,MouseMotionListener,Awards,Score{
	
	private int Score=0;
	private int Life=0; 
	
	BufferedImage bi;
	BufferedImage bi2;
	BufferedImage bi3;
	BufferedImage bi4;
	BufferedImage bi5;
	BufferedImage bi6;
	BufferedImage bi7;
	
	
	MyAir ma=new MyAir();//new一个自己的飞机
	
	
	boolean f1=true;
	private int start=1;//1是开始，2是游戏界面，3是鼠标离开游戏窗口，4是gameover界面
	
	MyPanel(){
		try {
			bi=ImageIO.read(new File("image/start.png"));//开始欢迎界面图
			bi2=ImageIO.read(new File("image/background.png"));//游戏背景图
			bi3=ImageIO.read(new File("image/pause.png"));//游戏暂停图
			bi4=ImageIO.read(new File("image/gameover.png"));//游戏gameover界面图
			bi5=ImageIO.read(new File("image/hero0.png"));//自己的飞机1
			bi6=ImageIO.read(new File("image/hero1.png"));//自己的飞机2
			bi7=ImageIO.read(new File("image/airplane.png"));//敌方小飞机
		} catch (IOException e) {
			
		}
	}
	public void paint(Graphics g){//paint方法
		if(start==1){//游戏欢迎界面
			g.drawImage(bi,0,0,null);
		}else if(start==2){//游戏玩耍时界面
			g.drawImage(bi2,0,0,null);//画背景
			//画自己的飞机
			if(f1){
				g.drawImage(bi5,ma.getX()-50,ma.getY()-70,null);//画自己的飞机1
				
			}else{
				g.drawImage(bi6,ma.getX()-50,ma.getY()-70,null);//画自己的飞机2
				
			}
			
			//画分数和生命
			g.setColor(Color.red);
			Font MyFont=new Font("华文行楷",Font.BOLD,20);//斜体，字号
			//设置字体
			g.setFont(MyFont);
			g.drawString("分数："+getScore(),10,30);//后两个是画出来的位置
			g.drawString("生命值："+getLife(),10,60);//后两个是画出来的位置
			
			/**
			 * 画敌机
			 */
			drawAirPlane(g);
			
		}else if(start==3){//游戏暂停时界面
			g.drawImage(bi3,0,0,null);
		}else if(start==4){//游戏结束时界面
			g.drawImage(bi4,0,0,null);
		}else{
			
		}
	}
	
	void drawAirPlane(Graphics g){
		int a=new Random().nextInt();//横坐标
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("鼠标正在被拖拽");
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("鼠标正在被移动");
		if(f1){
			f1=false;
		}else{
			f1=true;
		}
		ma.move(e.getX(), e.getY());
		System.out.println("鼠标的坐标为"+e.getX()+" "+e.getY());
		this.repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("鼠标正在被点击");
		if(start==1){//如果start是游戏欢迎界面
		start=2;
		}
		
		this.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("鼠标被按下");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("鼠标被松开");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("鼠标移动到界面中");
		if(start==3){//如果游戏时鼠标从窗口外面移动到窗口中
			start=2;
		}
		this.repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("鼠标离开窗口");
		if(start==2){//如果游戏时鼠标移动到窗口外面
			start=3;
		}
		this.repaint();
	}
	@Override
	public int getAwards() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return Score;
	}
	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return Life;
	}
}
