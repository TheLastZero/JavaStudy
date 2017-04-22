package com.ljgj;

import javax.swing.JFrame;

public class Text extends JFrame{
	
	public Text(){
		MyPanel im1=new MyPanel();
		this.add(im1);
	
		this.addMouseListener(im1);//监听鼠标
		this.addMouseMotionListener(im1);//监听鼠标移动，拖拽
		
		this.setTitle("飞机大战");
		this.setSize(400,685);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);//窗口总是在最上方
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Text t=new Text();
	}
}
