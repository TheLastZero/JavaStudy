package Tanks;

import java.util.Vector;

import Tanks.Tank;
import Tanks.ball;

public class MyTank extends Tank{

	//����һ����������װ�ӵ�����������һ���ӵ���Ķ���
	Vector<ball> aa =new Vector<ball>();
	ball zd=null;
	/**
	 * �ҵ�̹�˺͵��˵�̹�˶���һЩ��ͬ�����Է�����
	 * ����Щд��̹�����Ȼ��̳���
	 * ����һ�����ҵ�̹�˽��и��ģ����ﻹ���Խ��и���
	 * ��Ϊ�ӵ��Ǹ���̹���ߵģ������ӵ��Ĺ��ܴ�඼��̹�����й�
	 * @param x
	 * @param y
	 */
	public MyTank(int x,int y){
		super(x,y);
	}
	public void fire(){//�����ӵ��ķ���
		switch(this.direction){
		case 0://̹��ͷ���������ӵ��ķ���
			zd=new ball(x+15,y-25,direction);//���x��y��̹�˵�λ��
			aa.add(zd);//ÿ����һ���ӵ��������һ���ӵ�����Ϊaa�ļ�������
			break;
		case 1://̹��ͷ�������
			zd=new ball(x-28,y+15,direction);
			aa.add(zd);
			break;
		case 2://̹��ͷ�����ұ�
			zd=new ball(x+75,y+15,direction);
			aa.add(zd);
			break;
		case 3://̹��ͷ��������
			zd=new ball(x+15,y+75,direction);
			aa.add(zd);
			break;
		}
		//newһ���߳��������ӵ�
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