package TankW;

import java.io.*;
import java.util.Vector;


//������Ƶ�ļ��İ�
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


/**
 * �����ǹ���̹�˵�ԭ���Ϸ���
 */

/**
 * ������������̹�˳��ֵ�λ�ã�Ҳ���Ǻ�������
 * ���ҵ���̹�˵ķ���
 * @author С����-ST-PRO
 *
 */
class Tank{
	//�����x��y����̹�˵ĺ�������
	int x=0,y=0;
	//̹�˵ķ���,0�ϣ�1��2�ң�3��
	int direction=0;
	//̹�˵��ƶ��ٶ�
	int speed=10;
	//������̹�˼�һ������ֵ
	boolean EnemyTankLife=true;


	//��װ̹�˵ķ�����ٶ�
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//��get��set��װx��y���Ժ�ı��������϶�Ҫ��װ��ʹ�ú�����ֱ��ʹ�ñ���Ҫ��ȫ
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	Tank(int x,int y){//���췽��
		this.x=x;
		this.y=y;
	}
}

class enemyTank extends Tank implements Runnable{
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

class MyTank extends Tank{

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

class ball implements Runnable{
	//�ӵ���,���ӵ�����һ���߳��࣬��Ϊ���˵��ӵ��ǿ������⶯��
	int x,y;
	int direction;
	int speed=10;
	boolean life=true;//Ϊfalseʱ�Ͳ��ٻ��ӵ�
	public ball(int x,int y,int direction){//���췽��
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	public void run(){
		/**
		 * run�����Ǹ��ǵĸ��෽��
		 * �����߳�ʱ��˭���õ�start����������ͻ�ȥ�Զ�����run����
		 * start�ڵ��õ�ʱ��ᵥ����һ���߳�ȥ���ã�������ֱ�ӵ���
		 */
		while(true){
			try{
				/**
				 * �������ӵ�һֱ���䣬Ҫ����һ��ͣ�٣�Ҳ����˯��һ��ʱ��
				 * �����߳��������ѭ���ﶼҪ�и�˯�ߣ���Ȼ��������ױ���
				 */
				Thread.sleep(50);
			}catch(Exception e){

			}
			switch(direction){//����̹��ͷ�ķ����ж��ӵ�����ķ���
			case 0://̹��ͷ����
				y-=speed;
				break;
			case 1://̹��ͷ����
				x-=speed;
				break;
			case 2://̹��ͷ����
				x+=speed;
				break;
			case 3://̹��ͷ����
				y+=speed;
				break;
			}
			if(x<0||x>900||y<0||y>700){
				life=false;
				break;
			}
		}
	}
}

class bomb{//̹�˱�ը����
	int x,y;
	int liveTime=9;//������
	boolean life=true;
	public bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void live(){
		if(liveTime>0){
			liveTime--;
		}else {
			this.life=false;
		}
	}
}
    
class Notes{//��¼����̹����������
	private static int ETsum=10;//����̹�˵�����
	private static int MTank=2;//�ҵ�̹������
	private static int dieETSum=0;//ɱ��ͳ�Ƶı���
	private static FileWriter fw=null;//IO����������
	private static BufferedWriter bw=null;//����д
	private static FileReader fr=null;//IO���������
	private static BufferedReader br=null;//�����ȡ
	
	//����һ�������࣬��װ�������Ѿ������õ�̹�˼�����
	Vector<enemyTank> ETank=new Vector<enemyTank>();
		
	public void ETank(Vector<enemyTank> ETank){//�����������̹�˵ļ�����
		this.ETank=ETank;
	}
	
	//�������̹�˵�λ����һ��������,�����Ϳ��Ա���ܶ�̹�˵�����
	static Vector<position> wzjh=new Vector<position>();
	
	
	public static void saveNotes(){//����ɱ�м�¼�����±���,�´λ��Ǵ��ڵ�
		try{
			fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");//����ĵ�ַ
			bw=new BufferedWriter(fw);//ת����
			/**
			 * �س��ǽ�����Ƶ���ǰ�е����ף�
			 * �����ǽ�����Ƶ���ǰ�е���һ�У�������ͬһ�У�
			 * ����ص����ס����Ǻ��������Խ�����Ƶ���һ�е����ף�
			 * Ҳ���ǻس������С�
			 */
			bw.write(dieETSum+"\r\n");
		}catch(Exception e){}
		finally{
			try{
				bw.close();//�ر�ת����
				fw.close();//�ر�������
			}catch(Exception e){}
		}
	}
	
	
	public static Vector<position> readNotes(){//��ȡ��ǰ�ļ�¼
		try{
			fr=new FileReader("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
			br=new BufferedReader(fr);
			String s=br.readLine();
			dieETSum=Integer.parseInt(s);//����ȡ���Ľ��sת��������,�ٸ�dieETSum
			
			while((s=br.readLine())!=null){//һ��һ�еĶ�ȡbr������ݣ��оͼ�����û�о�����
				/**
				 * ���ַ��������ȷ������Ԫ��,
				 * ������a" "b" "c" "����һ�л�
				 * �Ҿ���" "�ո�����ַ���������Ϊ������±�������ֿ飬
				 * �����Ϳ��Էֱ��ȡһ�������a,b,c��
				 */
				String[] sz=s.split(" ");
				//��Integer.parseInt()����ȡ�����ַ������͵��ı�ת����integer����
				position wz=new position(Integer.parseInt(sz[0]),Integer.parseInt(sz[1]),Integer.parseInt(sz[2]));
				wzjh.add(wz);//����ȡ����̹��λ�����ݣ��ŵ�λ�ü�������
			}
		}catch(Exception e){
			
		}
		finally{
			try{
				br.close();//�ر�ת����
				fr.close();//�ر������
			}catch(Exception e){
				
			}
		}
		return wzjh;
	}
	
	public void saveGame(){//�浵��Ϸ�ķ���
		try{
			fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
			bw=new BufferedWriter(fw);
			bw.write(dieETSum+"\r\n");
			for(int i=0;i<ETank.size();i++){
				enemyTank ET=ETank.get(i);
				if(ET.EnemyTankLife){//���̹�˻����Ųż�¼��������
					String position=ET.x+" "+ET.y+" "+ET.direction+" ";
					bw.write(position+"\r\n");
				}
			}
		}catch(Exception e){
			
		}
		finally{
			try{
				bw.close();
				fw.close();
			}catch(Exception e){
				
			}
		}
	}
	
	
	public static int getDieETSum() {
		return dieETSum;
	}
	public static void setDieETSum(int dieETSum) {
		Notes.dieETSum = dieETSum;
	}
	public static int getETsum() {
		return ETsum;
	}
	public static void setETsum(int eTsum) {
		ETsum = eTsum;
	}
	public static int getMTank() {
		return MTank;
	}
	public static void setMTank(int mTank) {
		MTank = mTank;
	}
	
	public static void ETReduce(){//����̹�˼��ٵ���
		ETsum--;
	}
	public static void MTankReduce(){//����̹�˼��ٵ���
		MTank--;
	}
	public static void dieETSum(){//ɱ��ͳ�Ƶ���
		dieETSum++;
	}
}

class position{//̹�˵�λ����
	int x;
	int y;
	int direction;
	public position(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}	
}

class music extends Thread{//����������ʱ�����ж������Ķ��������������߳���
	private String FileName;//�ļ���
	public music(String ypwj){//��Ƶ�ļ�
		FileName=ypwj;
	}
	public void run(){//�߳������д��run����
		
		File wjl=new File(FileName);//���ļ����������ļ���
		
		AudioInputStream musicInput=null;//��Ƶ������
		
		try{
			//����Ƶ�ļ��������
			musicInput =AudioSystem.getAudioInputStream(wjl);
		}catch(Exception e){
			
		}
		
		//�������Ƶ�ļ����и�ʽ����,����һ���̶���ʽ
		AudioFormat format=musicInput.getFormat();
		SourceDataLine aqsj=null;
		DataLine.Info info=new DataLine.Info(DataLine.class, format);
		
		try{
			//���ļ�����һ����ȫ�Եĸ�ʽ���İ�װ
			aqsj=(SourceDataLine) AudioSystem.getLine(info);
			aqsj.open(format);
		}catch(Exception e){
			
		}
		aqsj.start();
		
		int zjtj=0;
		
		byte[] hczj=new byte[1024];//�����ֽ�
		
		try{
			while(zjtj!=-1){//������-1��ʾ�ļ���ȡ����
				zjtj=musicInput.read(hczj,0,hczj.length);
				if(zjtj>0){
					//�±��㿪ʼ�����һ��hczj.length���ж��پͶ�����
					aqsj.write(hczj,0,zjtj);
				}
			}
		}catch(Exception e){
			
		}
		finally{
			aqsj.drain();//���������ִ���ɾ�
			aqsj.close();
		}
		
	}
}