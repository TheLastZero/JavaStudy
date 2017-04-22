package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventPostProcessor;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JPanel;

public class Mpanel extends JPanel implements KeyListener,Runnable{//�Լ��̵ļ���Ҫ����new���ĵط�
	//���Ϊ1ʱ��������Ϸ�����ݽ�����Ϸ��Ϊ2ʱ������GameOver�Ľ���
	static int mp=1;
	
	int speed=10;
	
	//����װ��ͷС����ͣ��ߵ����ӵ�С����ļ�����
	Vector<MySnake> Msnake=new Vector<MySnake>();
	
	//����װ������ͷ����������·������Ϊ�������ߵ�·
	LinkedList<MySnake> MsWay=new LinkedList<MySnake>();
	
	//��newһֻ��ͷС����
	MySnake MS=new MySnake(1,1);
	
	//��ɫ�Ĺ���
	red r=null;
	
	Mpanel(){//���췽��	
		//����ͷ������ӽ��ߵļ�������
		Msnake.add(MS);
		
		//newһ����ɫ�Ĺ�����Ϊ�������߳�
		r=new red();
		
	}
	
	public void paint(Graphics e){
		
		if(mp==1){
		e.setColor(Color.black);
		e.fillRect(0, 0, 800,700);
		
		if(eatF()==false){//�ж���ͷ�Ƿ�Ե��˶���
			//ÿ�Ե�һ������С�߾�����һ��С����
			//��new�������ߵķ���ŵ��ߵļ��������¼ÿһ�������λ��
			MySnake a=new MySnake(MS.x,MS.y);
			Msnake.add(a);
		}
		
		//�����Լ���С��
		//��ͷ
		drawMySnake(MS.x,MS.y,e);
		
		//�����λ��
		for(int j=1;j<Msnake.size();j++){
			/**
			 * Msnake.size()��ʾ��Ŀǰ�м����������
			 * ÿһ�������λ�ö���������߹���λ��
			 */
				drawMySnake(MsWay.get(MsWay.size()-j-1).x,MsWay.get(MsWay.size()-j-1).y,e);	
		}
		
		//������ӵ�����Ϊtrue���ͻ�һ����ɫ�Ĺ���
		if(r.life){
			this.drawRed(e);
		}
		
	}else if(mp==2){//mp==2��ʱ����ʾ�˳���Ϸ
		e.setColor(Color.red);
		e.fillRect(0, 0, 800,700);
		
		e.setColor(Color.BLACK);
		Font f=new Font("���Ĳ���",Font.BOLD,100);
		e.setFont(f);
		e.drawString("GameOver",150,300);
		Font f2=new Font("����",Font.BOLD,30);
		e.setFont(f2);
		e.drawString("���»س����¿�ʼ��Ϸ",240,350);
	}
	}
	
	void drawMySnake(int x,int y,Graphics e){
		e.setColor(Color.blue);
		//�Լ�С�ߵ�λ�ã���С
		e.fillRect(x,y,20,20);
	}
	
	void drawRed(Graphics e){
		//newһ����ɫ�Ĺ�����Ϊ�������߳�
		Thread n=new Thread(r);
		n.start();
		e.setColor(Color.red);
		e.fillOval(r.x, r.y,20,20);
	}
	
	boolean eatF(){//�ж����Ƿ�Ե����ӵķ���
		//�����ͷ��λ���ڹ��ӵ������ڣ����ù�����ʧ���ߵĳ�������һ������
		if(MS.x>r.x&&MS.x<r.x+20&&MS.y>r.y&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x+20>r.x&&MS.y>r.y&&MS.x<r.x+20&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x>r.x&&MS.x<r.x+20&&MS.y+20>r.y&&MS.y<r.y+20){
			redFile();
			return false;
		}
		if(MS.x+20>r.x&&MS.y+20>r.y&&MS.x<r.x+20&&MS.y<r.y+20){
			redFile();
			return false;
		}
		return true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//���¼��̸ı���ͷ�ƶ��ķ���
		if(e.getKeyCode()==KeyEvent.VK_W && MS.y>0 && MS.direction!=2){//�����ǰ�Ƿ������ϣ��߾Ͳ�������ƶ�
			MS.direction=0;
		}else if(e.getKeyCode()==KeyEvent.VK_S && MS.y<680 && MS.direction!=0){
			MS.direction=2;
		}else if(e.getKeyCode()==KeyEvent.VK_A && MS.x>0 && MS.direction!=1){
			MS.direction=3;
		}else if(e.getKeyCode()==KeyEvent.VK_D && MS.x<780 && MS.direction!=3){
			MS.direction=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			//���»س����¿�ʼ��Ϸ
			System.out.println("���¿�ʼ");
			//�����ߵ�λ�úͳ���,���з���,�����ٶ�
			MS.x=1;
			MS.y=1;
			MS.direction=1;
			speed=10;
			Msnake.removeAll(Msnake);
			Msnake.add(MS);
			System.out.println(Msnake.size());
			mp=1;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_P){
			speed+=5;
		}else if(e.getKeyCode()==KeyEvent.VK_O){
			if(speed!=10){
				speed-=5;
			}
		}
		this.repaint();
	}
	
	void movid(){//��ͷ�ƶ��ķ���
		r.life=eatF();
		//�����ߵ����е�·���ö��󱣴����꣬���뵽��������
		MySnake m=new MySnake(MS.x,MS.y);
		
		MsWay.add(m);
		//�ж����Ƿ�����ǽ�����Լ��������Ļ�������,����GameOver����
		died();
		
		if(MS.direction==0 && MS.y>0){//��
			MS.y-=speed;
		}else if(MS.direction==2 && MS.y<680){
			MS.y+=speed;
		}else if(MS.direction==3 && MS.x>0){
			MS.x-=speed;
		}else if(MS.direction==1 && MS.x<780){
			MS.x+=speed;
		}
	}
	
	
	void redFile(){//�������new�����ߵ�������
		
		boolean f1=true;
		
		while(f1){
		r.Random();
		System.out.println("new�������");
		for(int j=0;j<Msnake.size();j++){
			if(r.x+10>MsWay.get(MsWay.size()-j-1).x&&r.x+10<MsWay.get(MsWay.size()-j-1).x+20
					&&r.y+10>MsWay.get(MsWay.size()-j-1).y&&r.y+10<MsWay.get(MsWay.size()-j-1).y+20){
				//��������������Χ�ڣ�����new�����������
				System.out.println("���ߵ�������");
				f1=true;
			}else{
				if(j==Msnake.size()-1){
					f1=false;
					
				}
			}	
		}
		}
	}
	void died(){
		//�ж����Ƿ�����ǽ�����Լ��������Ļ�������,����GameOver����
		if(MS.x<=0||MS.x>=781||MS.y<=0||MS.y>=681){//�����ж��Ƿ������ǽ
			mp=2;
		}
		
		//�����ͷ���Ϸ������Լ������壬������
		for(int i=1;i<Msnake.size();i++){//�ж����Ƿ�������Լ�������,i��1��ʼ����Ϊ1����ͷ�Լ�
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y>MsWay.get(MsWay.size()-j-1).y&&MS.y<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//�����ͷ����������Լ������壬������
		for(int i=1;i<Msnake.size();i++){//�ж����Ƿ�������Լ�������,i��1��ʼ����Ϊ1����ͷ�Լ�
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x>MsWay.get(MsWay.size()-j-1).x&&MS.x<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//�����ͷ���ұ������Լ������壬������
		for(int i=1;i<Msnake.size();i++){//�ж����Ƿ�������Լ�������,i��1��ʼ����Ϊ1����ͷ�Լ�
			if(MS.x+20>MsWay.get(MsWay.size()-i-1).x&&MS.x+20<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y>MsWay.get(MsWay.size()-i-1).y&&MS.y<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
		//�����ͷ���±������Լ������壬������
		for(int i=1;i<Msnake.size();i++){//�ж����Ƿ�������Լ�������,i��1��ʼ����Ϊ1����ͷ�Լ�
			if(MS.x>MsWay.get(MsWay.size()-i-1).x&&MS.x<MsWay.get(MsWay.size()-i-1).x+20&&
				MS.y+20>MsWay.get(MsWay.size()-i-1).y&&MS.y+20<MsWay.get(MsWay.size()-i-1).y+20){
				for(int j=1;j<Msnake.size();j++){
					if(MS.x+20>MsWay.get(MsWay.size()-j-1).x&&MS.x+20<MsWay.get(MsWay.size()-j-1).x+20&&
							MS.y+20>MsWay.get(MsWay.size()-j-1).y&&MS.y+20<MsWay.get(MsWay.size()-j-1).y+20){
						mp=2;
					}
				}
			}	
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(50);
				this.movid();
			}catch(Exception e){
				
			}
			this.repaint();
		}
	}
}