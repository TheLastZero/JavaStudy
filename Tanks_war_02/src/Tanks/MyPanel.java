package Tanks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

/**
 * �����������̹�ˣ�̹���з���Ҳ����ɫ������λ��
 * @author С����-ST-PRO
 *
 */
public class MyPanel extends JPanel implements KeyListener,Runnable{//ʵ�ּ���,�߳̽ӿ�
	MyTank mt=null;//�ҵ�̹��
	/**
	 * ��Vector��������װenemyTank���˵�̹��,Vector�Ƕ��߳�
	 * ��Ϊ���˵�̹��Ҫ��ȫ���
	 * ����ʹ�÷��ͣ�����֮����÷�������ǿת
	 */
	Vector<enemyTank> ETank=new Vector<enemyTank>();//���˵�̹��
		
	Vector<bomb> bo=new Vector<bomb>();//�������������װ��ը��ͼƬ,�Ա����л�
	static int ETankSum=3;//�з�̹������
	
	//����һ��λ�ü�¼�ļ�������װ��Notes���ݼ�¼���̹��λ���ļ�
	Vector<position> wzjh=null;

	//��������̹�˱�ը��ͼƬ
	Image tp1=null;
	Image tp2=null;
	Image tp3=null;
	
	public MyPanel(String s){
		//����new���������ҵ�̹�˵�λ��
		mt=new MyTank(425,570);
		if(s.equals("NewGame")){//���������Ϸ�����new��������壬��������µĳ�ʼ��

			//��forѭ��new�����˵�̹��,Ȼ����Etankװ����,int�ǵ���̹�˵�����
			for(int i=0;i<ETankSum;i++){
				//(i)*181+5,0�ǵ���̹�˵ĺ�������
				enemyTank ET=new enemyTank((i)*400+20,20);
				
				//����һ��̹�ˣ�����һ���߳�,̹�˾ͻ��Լ�����
				Thread t=new Thread(ET);
				t.start();
				
				//�����з�̹�˵��ӵ��߳�
				ball zd=new ball(ET.x+15,ET.y-25,ET.direction);
				Thread t3=new Thread(zd);
				t3.start();
				ETank.add(ET);
			}
			//��������̹�˱�ը��ͼƬ
			tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp1.png"));
			tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp2.png"));
			tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp3.png"));

		}else if(s.equals("goOnGame")){//���ѡ����Ǽ�����Ϸ
			/**
			 * Notes.readNotes();
			 * ��ȡ��һ��ɱ�������ļ�¼�����õ���֮ǰ�Ƿ���txt�ļ��ڼ�¼���ݣ�
			 * ��Ϊ��������try...catch���������쳣����Ҳ����� 
			 */
			//��֮ǰ�����ļ�������װ��Notes���ݼ�¼���̹��λ���ļ�
			wzjh = Notes.readNotes();

			for(int i=0;i<wzjh.size();i++){
				position wz=wzjh.get(i);

				//����̹�˵ĺ�������,�����wz���ȡ
				enemyTank ET=new enemyTank(wz.x,wz.y);
				ET.setDirection(wz.direction);

				//����һ��̹�ˣ�����һ���߳�,̹�˾ͻ��Լ�����
				Thread t=new Thread(ET);
				t.start();
				//�����з�̹�˵��ӵ��߳�
				ball zd=new ball(ET.x+15,ET.y-25,ET.direction);
				Thread t3=new Thread(zd);
				t3.start();
				ETank.add(ET);
			}
			//��������̹�˱�ը��ͼƬ
			tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp1.png"));
			tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp2.png"));
			tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/tp3.png"));
		}

		//������Ƶ�ļ�,./�����Ŀ¼����������Ƶ�ļ�����c�̻���D�̶����Զ���
		music ms=new music("src/��Ϸԭ��-FC��̹�˴�ս��սǰBGM - ����.wav");
		ms.start();
	}         

	public void paint(Graphics g){
		super.paint(g);
		//���ƻ�����Ĭ��Ϊ��ɫ���ɫ����СΪ900,700
		g.fillRect(0, 0, 900, 700);
		//���û���̹�˵ĺ���drawTank

		//���ﻭ�Լ���̹��,ǰ�����Ǻ������꣬��������̹��ͷ�ķ��򣬵��ĸ�����ɫ����
		if(mt.EnemyTankLife){//�ж��Լ��������Ƿ�Ϊtrue
			this.drawTank(mt.getX(), mt.getY(), g,mt.direction, 0);
		}
		
		//����new����
		for(int i=0;i<ETank.size();i++){
			if(ETank.get(i).EnemyTankLife){
				this.drawTank(ETank.get(i).getX(),ETank.get(i).getY(), g,ETank.get(i).direction, 1);
				//����������ETank�������ȫ�����������ݸ�enemyTank���еĵз�̹�˼�����
				ETank.get(i).ETank(ETank);
			}else{
				ETank.remove(i);
			}	
		}

		/**
		 * ���з�̹�˵��ӵ�
		 */
		for(int j=0;j<ETank.size();j++){
			for(int i=0;i<ETank.get(j).Eball.size();i++){//��һ��ѭ���ǻ�ETank.get(j)̹�˵��ӵ�,���ұ�������ӵ��ļ���
				//����һ���ӵ���Ķ���������ETank(�з���̹��)����ΪEball��Vector��������ӵ�
				ball zd=ETank.get(j).Eball.get(i);

				if(zd!=null&&zd.life==true){
					/**
					 * �ӵ���������Ϊ�ղ�����������true��ʱ��ſ��Է���
					 * ����Ϊ0����˼���ǵ��ӵ������涨�Ļ�����С�����Լ���ʧ
					 */
					g.setColor(Color.white);
					//��Բ�����ӵ�
					g.fillOval(zd.x, zd.y,10, 10);
				}
				if(zd.life==false){
					/**
					 * aa�����Ǵ�����һ������װ�ӵ���Vector������
					 * �ӵ�����ǽ��ʱ����false�����falseʱ���Ǿ�ɾ��
					 * ����һ������������˿��ӵ�
					 */
					ETank.get(j).Eball.remove(zd);
				}
			}
		}

		/**
		 * ���ҵ�̹�˵��ӵ�
		 * mt.aa.size()���ӵ�������Ĵ�С��Ҳ�����ж���
		 */
		for(int i=0;i<mt.aa.size();i++){
			//����һ���ӵ���Ķ���������mt(�ҵ�̹��)����Ϊaa��Vector��������ӵ�
			ball zd=mt.aa.get(i);

			if(zd!=null&&zd.life==true){
				/**
				 * �ӵ���������Ϊ�ղ�����������true��ʱ��ſ��Է���
				 * ����Ϊ0����˼���ǵ��ӵ������涨�Ļ�����С�����Լ���ʧ
				 */
				g.setColor(Color.white);
				//��Բ�����ӵ�
				g.fillOval(zd.x, zd.y,10, 10);
			}
			if(zd.life==false){
				/**
				 * aa�����Ǵ�����һ������װ�ӵ���Vector������
				 * �ӵ�����ǽ��ʱ����false�����falseʱ���Ǿ�ɾ��
				 * ����һ������������˿��ӵ�
				 */
				mt.aa.remove(zd);
			}
		}

		for(int i=0;i<bo.size();i++){//�ҵ�̹�˻��ез�ʱ���з�̹�˵�λӦ��������ը����
			System.out.println("��ʼ��ը");
			bomb bz=bo.get(i);
			System.out.println("bz.liveTimeΪ"+bz.liveTime);
			if(bz.liveTime>6){
				//ǰ���������꣬�������Ǻ��ݳ���
				g.drawImage(tp1,bz.x,bz.y,60,60,this);
			}else if(bz.liveTime>3){
				g.drawImage(tp2,bz.x,bz.y,60,60,this);
			}else{
				g.drawImage(tp3,bz.x,bz.y,60,60,this);
			}
			System.out.println("������live����");
			bz.live();//������lifeTime���ٵķ���
			if(bz.liveTime==0){//�����ڵ�����ʱ����ȥ����ը
				bo.remove(bz);
			}
		}

		NoteData(g);//����ͳ�����ݵķ���
	}

	public void NoteData(Graphics g){//ͳ�����ݵķ���
		//������̹����Ϊ��־
		this.drawTank(200, 730, g,0,0);
		g.setColor(Color.BLACK);
		//���������ں�������ַ����������������ת�����ַ���
		g.drawString(Notes.getMTank()+" ", 260, 760);

		this.drawTank(300, 730, g,0,1);
		g.setColor(Color.black);
		g.drawString(Notes.getETsum()+" ",360,760);

		this.drawTank(920, 100, g,0,1 );
		g.setColor(Color.BLACK);
		g.drawString(Notes.getDieETSum()+" ", 980, 130);//������̹�˵����������ַ�������
		Font f=new Font("���Ĳ���",Font.BOLD,20);
		g.setFont(f);
		g.drawString("�������̹������",910, 50);
	}

	/**
	 * �ҵ�̹�˴������̹��ʱ
	 */
	public void hitETank1(){
		for(int i=0;i<mt.aa.size();i++){//�ҵ�̹��ÿȡ��һ���ӵ�
			ball zd=mt.aa.get(i);
			if(zd.life){
				for(int j=0;j<ETank.size();j++){//ÿ���ӵ���ÿ������̹�˽�������Ƚ�
					enemyTank ET=ETank.get(j);
					if(ET.EnemyTankLife){//�з�̹�˵�����ֵ�Ƿ�Ϊtrue
						if(this.hitTank(zd, ET)){//�з�̹���Ƿ񱻻���
							Notes.ETReduce();//���ĵз�̹�����������ٵķ���
							Notes.dieETSum();//�ı������������������
						}
					}
				}
			}
		}
	}
	/**
	 * ���˵�̹�˴����ʱ
	 */
	public void hitMTank1(){
		for(int i=0;i<ETank.size();i++){
			enemyTank ET=ETank.get(i);
			if(ET.EnemyTankLife){
				for(int j=0;j<ET.Eball.size();j++){//ÿ���ӵ���ÿ������̹�˽�������Ƚ�
					ball zd=ET.Eball.get(j);
					if(ET.EnemyTankLife){
						if(this.hitTank(zd, mt)){
							Notes.MTankReduce();//ʹ����̹�˵�������һ�ķ���
						}

					}
				}
			}
		}
	}

	public boolean hitTank(ball zd,Tank ET){
		/**
		 * ���еصз��ĺ���,���յ����ӵ����͵з�̹�˵�����ֵ
		 * ���ӵ������꣬��̹�˵����귶Χ�ڣ�������һ����ʧ
		 */
		boolean b2=false;
		switch(ET.direction){
		//0��2��дbreak�Ϳ���һֱ����ִ�У�����ֻҪд���źͺ��ŵ���������̹�˾ͺ���
		case 0:;
		case 3:
			if(zd.x>ET.getX()&&zd.x<ET.x+30&&zd.y>ET.y-10&&zd.y<ET.y+60){
				System.out.println("ִ��3�ڲ�False");
				zd.life=false;
				ET.EnemyTankLife=false;
				b2=true;
				//newһ����ը�Ķ���one��Ȼ����뵽BO�ı�ը��������
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
	 * ����̹�˵ĺ���
	 * ��x��y�����������
	 * ��һ��Graphics g���ʹ���,����ֱ�Ӵ����»��ʣ���Ϊ�»��ʺ�ԭ���Ļ���û�й�ϵ
	 * ��һ������direction����
	 * ��һ������type����
	 */
	public void drawTank(int x,int y,Graphics g,int direction,int type){
		//��switch����̹�˵����ͣ�0�����ҵ�̹�ˣ�1������˵�̹��
		switch(type){
		case 0:
			g.setColor(Color.yellow);;
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		//switch�����ַ���,����̹��ͷ���ŵķ���
		switch(direction){//��̹�˵�ʵ��
		case 0://̹��ͷ������
			g.fill3DRect(x, y, 10,60, false);
			g.fill3DRect(x+30, y, 10,60, false);
			g.fill3DRect(x+10, y+10, 20,40, false);
			g.fillOval(x+10,y+20,20,20);
			g.drawLine(x+20,y+30,x+20,y-10 );
			break;
		case 1://̹��ͷ�������
			g.fill3DRect(x, y, 60,10, false);
			g.fill3DRect(x, y+30, 60,10, false);
			g.fill3DRect(x+10, y+10, 40,20, false);
			g.fillOval(x+20,y+10,20,20);
			//ʹ�õ�ǰ��ɫ�������ĵ�����ϵ�����꣨x1,y1��,(x2,y2)֮�仭һ����
			g.drawLine(x+30,y+20,x-10,y+20);
			break;
		case 2://̹��ͷ�����ұ�
			g.fill3DRect(x, y, 60,10, false);
			g.fill3DRect(x, y+30, 60,10, false);
			g.fill3DRect(x+10, y+10, 40,20, false);
			g.fillOval(x+20,y+10,20,20);
			//ʹ�õ�ǰ��ɫ�������ĵ�����ϵ�����꣨x1,y1��,(x2,y2)֮�仭һ����
			g.drawLine(x+40,y+20,x+70,y+20);
			break;
		case 3://̹��ͷ��������
			g.fill3DRect(x, y, 10,60, false);
			g.fill3DRect(x+30, y, 10,60, false);
			g.fill3DRect(x+10, y+10, 20,40, false);
			g.fillOval(x+10,y+20,20,20);
			g.drawLine(x+20,y+70,x+20,y+30 );
			break;
		}
	}
	public void keyTyped(KeyEvent e){
		//���ַ�����ĺ����� ����ĳ����ʱ���ô˷�����
	}
	public void keyPressed(KeyEvent e){
		//���̰��µ�����	
		
		if(e.getKeyCode()==KeyEvent.VK_W ){
			//�����ƶ����ѷ������Ϊ��,�ڵ���up�������ƶ�̹��
			this.mt.setDirection(0);
			/**
			 * Ϊ�˱�֤̹����900*700�Ļ��������Ҫ�жϼ��̵İ���
			 * ��Ҫ�ж�̹�˵�ǰ��λ���Ƿ��ڻ����ڣ�
			 * �ڵĻ����ܼ����ƶ������򲻶��ƶ�̹�˵Ĵ���
			 */
			if(this.mt.y>10){
				this.mt.up();
			}
		}else if(e.getKeyCode()==KeyEvent.VK_S ){
			//�����ƶ�
			this.mt.setDirection(3);
			if(this.mt.y<630){
				this.mt.down();
			}
		}else if(e.getKeyCode()==KeyEvent.VK_A ){
			//�����ƶ�
			this.mt.setDirection(1);
			if(this.mt.x>5){
				this.mt.left();
			}	
		}else if(e.getKeyCode()==KeyEvent.VK_D ){
			this.mt.setDirection(2);
			if(this.mt.x<830){
				this.mt.right();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_J){
			//����ӵ�����������û��8�����ͼ������䣬��8���Ժ�Ͳ��ܷ���
			//����һ������������˿��ӵ�,���ϰ�Ļ궷�޾��������ӵ�����
			if(this.mt.aa.size()<8){
				this.mt.fire();
			}
		}
		//��������Paint,ˢ�º��ػ棬�Ϳ��Կ���̹�˵��ƶ�
		this.repaint();
	}
	public void keyReleased(KeyEvent e){
		//����̧���Ժ������
	}
	public void run(){//����Runnable�߳̽ӿڵ�run����
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){

			}
			/**
			 * �ö���ѭ����Ŀ���ǣ���ÿһ���ӵ���ÿ������̹�˱Ƚ�����
			 */
			hitETank1();
			hitMTank1();
			this.repaint();
		}
	}
}
