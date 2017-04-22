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
 * ����һ����Ϸ�������壬��Ҫ�̳�JFrame
 * @author С����-ST-PRO
 *
 */
public class PlaneFrame extends JFrame{
	PlanePanel jp;
	//�ҵ�Ŀ¼���ڵ�λ��
	//  ��\����ת�����Ҫ��ʾ�Ļ�Ҫ������
	public static String path=System.getProperty("user.dir")+"\\material\\";
	
	//׼��һ��������ȡ���е�ͼƬ  String=ͼƬ������  image=ͼƬ
	public static HashMap<String,BufferedImage> maps=new HashMap<>(); 
	
	//��̬��һ������������Դ
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
	 * ����һ������
	 * @return 
	 */
	public PlaneFrame(){
		//��ʾ���ڵķ���,Ϊ�˱��ⴰ��һ������ 
		setVisible(true);
		//��ʾ����
		this.setTitle("�ɻ���ս---zero");
		//���ô��ڵĴ�С
		this.setSize(700,800);
		//���ô��ھ���
		this.setLocationRelativeTo(null);
		//���ô��ڲ��ɶ�
		this.setResizable(false);
		//���ô��ڹرգ�����͹ر�
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jp =new PlanePanel();
		//��������������һ����壬�ڰ�����Ƕ��һ�鲣��
		this.setContentPane(jp);
		//������Ӽ���
		this.addKeyListener(new MykeyListener());
		
	}
	//����
	class MykeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//���������ķ���
			jp.keyPressed(e);
		}
	}
	public static void main(String[] args){
		new PlaneFrame();
		//System.out.println(maps);
	}
}
/**
 * ��壬�е�����HTML��Padding,д������ͼ������ͱ�����һ����padding�ľ���
 * @author С����-ST-PRO
 *
 */
class PlanePanel extends JPanel{
	//�����ӵ����������
	int buff=0;
	
	
	//���ñ���ͼƬ��λ��
	Point bgPoint = new Point(0,-800);
	
	//����һ���ӵ��ļ���
	List<Point> list =new ArrayList<>();
	
	//�ɻ���λ�ã�point��һ���㣨x,y��
	Point PlanePoint = new Point(300,600);
	
	public PlanePanel(){
		//�����߳�
		new Thread(new BgThread()).start();
	}
	
	/**
	 * ���ķ�����ͼ   Graphics����
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//���ȥ������Ĺ��췽����������ص�Ч��
		super.paint(g);
		//���û�ͼ�����ͣ��Լ���С
		BufferedImage image= new BufferedImage(700, 800, BufferedImage.TYPE_INT_RGB);
		//���һ������
		Graphics gs = image.getGraphics();
		
		//����ͼ
		gs.drawImage(PlaneFrame.maps.get("map.jpg"),bgPoint.x, bgPoint.y, this);
		gs.drawImage(PlaneFrame.maps.get("map.jpg"),bgPoint.x, bgPoint.y-1600, this);
		//���ɻ�
		gs.drawImage(PlaneFrame.maps.get("we2.png"), PlanePoint.x, PlanePoint.y, this);
		//���ӵ�
		for (int i = 0; i <list.size(); i++) {
			gs.drawImage(PlaneFrame.maps.get("zidan2.png"),list.get(i).x,list.get(i).y, this);
		}
		g.drawImage(image, 0, 0, this);
		
	}
	//�̣߳�����ͼƬ�ƶ�
	class BgThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//���ϵ�ȥ�ı�ͼƬ��λ���ƶ�
			while(true){
				if(bgPoint.y==800){
					bgPoint.y=-800;
				}
				bgPoint.y+=1;
				
				for (int i = 0; i < list.size(); i++) {
					list.get(i).y-=8;
				}
				try {
					//ÿ����ʮ����
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
				//ˢ��
				repaint();
			}
			
		}
		
	}
	
	//�����ӵ��ķ���
	public void fire(){
		//ÿ�ν�������������ʹ���һ���ӵ�
		if(buff==0){
			list.add(new Point(PlanePoint.x-30,PlanePoint.y-40));
			buff++;
		}else{
			list.add(new Point(PlanePoint.x+50,PlanePoint.y-40));
			buff--;
		}
		
		repaint();
	}
	
		//������������ȥ�ķ���
		public void keyPressed(KeyEvent e) {
			
			// TODO Auto-generated method stub
		//	super.keyPressed(e);
			
			//�ж��Ƿ�Ϊ�ո�
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				//�����ӵ��ķ���
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

			//ˢ��
			repaint();
		}
	}