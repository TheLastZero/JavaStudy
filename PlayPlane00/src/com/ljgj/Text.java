package com.ljgj;

import javax.swing.JFrame;

public class Text extends JFrame{
	
	public Text(){
		MyPanel im1=new MyPanel();
		this.add(im1);
	
		this.addMouseListener(im1);//�������
		this.addMouseMotionListener(im1);//��������ƶ�����ק
		
		this.setTitle("�ɻ���ս");
		this.setSize(400,685);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);//�������������Ϸ�
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Text t=new Text();
	}
}
