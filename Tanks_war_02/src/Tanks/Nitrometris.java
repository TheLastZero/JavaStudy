package Tanks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * �ؿ�����࣬ʵ��Runnable�߳̽ӿ�
 * �����߳����Ժ󣬵�һ�ص����������Բ�ͣ����˸
 * @author С����-ST-PRO
 *
 */


/**
 * ֮���Ա��γ�����Բ�ͣ��ѭ��
 * ����Ϊʵ�����߳̽ӿں�run�����ڱ��γ��������У�������paint
 * ��run��������һ��whileѭ����
 * ���������߳�˯��400���룬
 * ����this.repaint();���õ�ǰ�����paint����
 * 
 */

public class Nitrometris extends JPanel implements Runnable{

	int times=0;

	public void paint(Graphics g){
		super.paint(g);
		
		g.fillRect(0, 0,900,700);

		if(times%2==0){//timeλż��ʱ�Ž���д��һ�أ����Ի������˸��Ч��
			g.setColor(Color.yellow);
			Font MyFont=new Font("�����п�",Font.BOLD,38);//б�壬�ֺ�
			//��������
			g.setFont(MyFont);
			g.drawString("��һ��",400, 300);//�������ǻ�������λ��
		}
	}

	public void run() {
		while(true){
			try{
				Thread.sleep(400);//���߳�����һ��,������˸�����ʱ��
			}catch(Exception e){

			}
			times++;
			this.repaint();//�ػ�
		}
	}
}
