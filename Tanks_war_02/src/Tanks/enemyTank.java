package Tanks;

import java.util.Vector;

import Tanks.Tank;
import Tanks.ball;
import Tanks.enemyTank;

public class enemyTank extends Tank implements Runnable{
	//�����ǵ��˵�̹���࣬Ҳ�����߳���,ʵ��Runnable�ӿ�
	int speed=2;//�з�̹���ƶ����ٶ�

	int time=0;

	public enemyTank(int x,int y){
		super(x,y);
	}

	//����һ����������װ�з�̹�˵��ӵ�
	Vector<ball> Eball=new Vector<ball>();
	
	//����һ�������࣬��װ�������Ѿ������õ�̹�˼�����
	Vector<enemyTank> ETank=new Vector<enemyTank>();
		
	public void ETank(Vector<enemyTank> ETank){//�����������̹�˵ļ�����
		this.ETank=ETank;
	}
	
	public boolean avoid(){//Ϊ�˱���з�̹���ص���һ���д�Ķ�ܸ��Եķ���
		boolean b=true;
		switch(this.direction){//�жϵз�̹�˵ķ���
		case 0:
			for(int i=0;i<ETank.size();i++){
				//�ӵ���̹�˵ļ�������ȡ��̹��,װ���������ET��
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					/**
					 * ������˵�̹�˲������Լ�,
					 * ��Ϊ��ǰ�з�̹����Ҫ�����еĵз�̹�˽��������Ƿ��ص��ıȽ�
					 * �����������̹�˼����࣬�������ǰ����Լ��ģ�
					 * �Լ����Լ��Ƚ�����϶����غ��˵ģ�
					 * ����������Ҫ�����ڵ�ǰ̹�ˣ�
					 * Ҳ���ǲ������Լ��ż����ȽϺͱ��̹�˵������ص�
					 */
					//��ǰ̹��ͷ�����Ϸ�ʱ
					if(ET.direction==0||ET.direction==3){//�����һ�����˵�̹��ͷ�Ƕ����ϻ�������
						if(this.x>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
					if(ET.direction==1||ET.direction==2){//�����һ�����˵�̹�˶�����߻����ұ�
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							
							return false;//��ʾ�غ��ˣ����Բ��У�����false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<ETank.size();i++){
				//�ӵ���̹�˵ļ�������ȡ��̹��,װ���������ET��
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//�����һ�����˵�̹��ͷ�Ƕ����ϻ�������
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
					if(ET.direction==1||ET.direction==2){//�����һ�����˵�̹�˶�����߻����ұ�
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							
							return false;//��ʾ�غ��ˣ����Բ��У�����false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<ETank.size();i++){
				//�ӵ���̹�˵ļ�������ȡ��̹��,װ���������ET��
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//�����һ�����˵�̹��ͷ�Ƕ����ϻ�������
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
					if(ET.direction==1||ET.direction==2){//�����һ�����˵�̹�˶�����߻����ұ�
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							
							return false;//��ʾ�غ��ˣ����Բ��У�����false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<ETank.size();i++){
				//�ӵ���̹�˵ļ�������ȡ��̹��,װ���������ET��
				enemyTank ET=ETank.get(i);
				if(ET!=this){
					if(ET.direction==0||ET.direction==3){//�����һ�����˵�̹��ͷ�Ƕ����ϻ�������
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
						if(this.x+60>=ET.x&&this.x<=ET.x&&this.y+60>=ET.y&&this.y<=ET.y+60){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
					if(ET.direction==1||ET.direction==2){//�����һ�����˵�̹�˶�����߻����ұ�
						if(this.x>=ET.x&&this.x<=ET.x+60&&this.y+60>=ET.y&&this.y<=ET.y){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							
							return false;//��ʾ�غ��ˣ����Բ��У�����false
							
						}
						if(this.x+60>=ET.x&&this.x<=ET.x+60&&this.y+60>=ET.y&&this.y<=ET.y){//��̹�����Ϸ��ĵ��Ƿ�����һ��̹����
							return false;//��ʾ�غ��ˣ����Բ��У�����false
						}
					}
				}
			}
			break;
		}
		return b;
	}
	
	public void run(){
		//дwhileѭ������Ϊ̹���ӵ�һֱ���ڻ,ֱ����ȥ��ֹͣ
		//�з�̹�˵��ƶ�
		while(true){
			switch(this.direction){
			case 0:
				for(int i=0;i<30;i++){
					if(y>5 && avoid()){
						/**
						 * ���y����0�Ļ����ƶ�̹�ˣ��������Ա���з�̹���Զ��ߵ��������
						 * ����avoid������Ϊ�˱���з�̹���ص���һ��
						 */
						y-=speed;
					}
					try{
						//�з�̹��ÿ��һ�ξ�����50����
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 1:
				for(int i=0;i<30;i++){
					if(x>0 && avoid()){//���x����0�Ļ����ƶ�̹�ˣ��������Ա���з�̹���Զ��ߵ��������
						x-=speed;
					}
					try{
						//�з�̹��ÿ��һ�ξ�����50����
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 2:
				for(int i=0;i<30;i++){
					/**
					 * ����Ҫ����̹���߳��ұߵĻ���
					 * ����Ϊ900��,700
					 * ̹������Ҳ�к��Ϊ60,��������xҪС��900-60
					 */
					if(x<820 && avoid()){
						x+=speed;
					}		
					try{
						//�з�̹��ÿ��һ�ξ�����50����
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 3:
				for(int i=0;i<30;i++){
					/**
					 * ����Ҫ����̹���߳��±ߵĻ���
					 * ����Ϊ900��,700
					 * ̹������Ҳ�к��Ϊ60,��������yҪС��700-60
					 */
					if(y<580 && avoid()){
						y+=speed;
					}
					try{
						//�з�̹��ÿ��һ�ξ�����50����
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			}
			//�������0��3֮�������,���ݸ�����											/////////////////////////////////////////////////////
			this.direction=(int)(Math.random()*4);
			if(this.EnemyTankLife==false){//̹��û������ʱ�������߶���ѭ��
				break;
			}
			this.time++;//����ʱ�䣬�ӵ�����ľͱȽ���
			if(time%2==0){
				if(this.EnemyTankLife){//�жϵз�̹�������Ƿ�Ϊ��
					if(Eball.size()<5){//���з�̹�˵ļ���������ӵ����Ƿ�С��5��
						ball zd=null;

						switch(this.direction){
						case 0://̹��ͷ���������ӵ��ķ���
							zd=new ball(x+15,y-25,direction);//���x��y��̹�˵�λ��
							Eball.add(zd);//ÿ����һ���ӵ��������һ���ӵ�����Ϊaa�ļ�������
							break;
						case 1://̹��ͷ�������
							zd=new ball(x-28,y+15,direction);
							Eball.add(zd);
							break;
						case 2://̹��ͷ�����ұ�
							zd=new ball(x+75,y+15,direction);
							Eball.add(zd);
							break;
						case 3://̹��ͷ��������
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
