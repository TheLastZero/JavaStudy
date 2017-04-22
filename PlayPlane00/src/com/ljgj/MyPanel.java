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
	
	
	MyAir ma=new MyAir();//newһ���Լ��ķɻ�
	
	
	boolean f1=true;
	private int start=1;//1�ǿ�ʼ��2����Ϸ���棬3������뿪��Ϸ���ڣ�4��gameover����
	
	MyPanel(){
		try {
			bi=ImageIO.read(new File("image/start.png"));//��ʼ��ӭ����ͼ
			bi2=ImageIO.read(new File("image/background.png"));//��Ϸ����ͼ
			bi3=ImageIO.read(new File("image/pause.png"));//��Ϸ��ͣͼ
			bi4=ImageIO.read(new File("image/gameover.png"));//��Ϸgameover����ͼ
			bi5=ImageIO.read(new File("image/hero0.png"));//�Լ��ķɻ�1
			bi6=ImageIO.read(new File("image/hero1.png"));//�Լ��ķɻ�2
			bi7=ImageIO.read(new File("image/airplane.png"));//�з�С�ɻ�
		} catch (IOException e) {
			
		}
	}
	public void paint(Graphics g){//paint����
		if(start==1){//��Ϸ��ӭ����
			g.drawImage(bi,0,0,null);
		}else if(start==2){//��Ϸ��ˣʱ����
			g.drawImage(bi2,0,0,null);//������
			//���Լ��ķɻ�
			if(f1){
				g.drawImage(bi5,ma.getX()-50,ma.getY()-70,null);//���Լ��ķɻ�1
				
			}else{
				g.drawImage(bi6,ma.getX()-50,ma.getY()-70,null);//���Լ��ķɻ�2
				
			}
			
			//������������
			g.setColor(Color.red);
			Font MyFont=new Font("�����п�",Font.BOLD,20);//б�壬�ֺ�
			//��������
			g.setFont(MyFont);
			g.drawString("������"+getScore(),10,30);//�������ǻ�������λ��
			g.drawString("����ֵ��"+getLife(),10,60);//�������ǻ�������λ��
			
			/**
			 * ���л�
			 */
			drawAirPlane(g);
			
		}else if(start==3){//��Ϸ��ͣʱ����
			g.drawImage(bi3,0,0,null);
		}else if(start==4){//��Ϸ����ʱ����
			g.drawImage(bi4,0,0,null);
		}else{
			
		}
	}
	
	void drawAirPlane(Graphics g){
		int a=new Random().nextInt();//������
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("������ڱ���ק");
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("������ڱ��ƶ�");
		if(f1){
			f1=false;
		}else{
			f1=true;
		}
		ma.move(e.getX(), e.getY());
		System.out.println("��������Ϊ"+e.getX()+" "+e.getY());
		this.repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("������ڱ����");
		if(start==1){//���start����Ϸ��ӭ����
		start=2;
		}
		
		this.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("��걻����");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("��걻�ɿ�");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("����ƶ���������");
		if(start==3){//�����Ϸʱ���Ӵ��������ƶ���������
			start=2;
		}
		this.repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("����뿪����");
		if(start==2){//�����Ϸʱ����ƶ�����������
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
