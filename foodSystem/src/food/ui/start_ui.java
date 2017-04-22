package food.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * ��������ϵͳ
 * ��Ҫ��ģʽmodel1������֮ǰ�������õ�˼��,����չ�ԱȽϲ�
 * ����������Ŀmodel2�õıȽ϶�,����չ�Էǳ�ǿ
 * Java�������κ�ǿ��Ľ��棬���Ǵ�����ԱȽϷ���
 * 
 * ���ϲ��ǽ���(ui)
 * �м���ģ��(model)
 * ���²������ݿ�(database)
 * 
 * JWindow,���������ǵĲ��ֱ���񴰿�һ��
 * @author С����-ST-PRO
 *
 */
//JWindow,���������ǵĲ��ֱ���񴰿�һ��
public class start_ui extends JWindow implements Runnable{
	/**
	 * ������:
	 * �Կ��ӻ���ʽ��ʾĳЩ������ȵ������
	 * ���������ɽ����У���������ʾ��������ɵİٷֱȡ�
	 * �˰ٷֱ�ͨ����һ�������Կ��ӻ���ʽ��ʾ���þ��ο�ʼ�ǿյģ�
	 * �������������𽥱���䡣���⣬����������ʾ�˰ٷֱȵ��ı���ʾ��ʽ��
	 */
	JProgressBar jpb;//��JWindow���еĿؼ�,������
	JLabel jl1;//��ǩ,������ͼƬ
	int width,height;//�ó��Ϳ�������أ������ó���λ��
	
	public static void main(String[] args) {
		start_ui su=new start_ui();
		//newһ���߳�
		Thread t=new Thread(su);
		t.start();
	}
	
	public start_ui(){//���췽��
		
		jl1=new JLabel(new ImageIcon("image/2.png"));//�������ͼƬ��ַ
		
		jpb=new JProgressBar();
		//JProgressBar���ж�ʮ���ֿ������õĵط�
		jpb.setStringPainted(true);//���ַ�����������
		jpb.setIndeterminate(false);
		jpb.setBorderPainted(false);
		jpb.setBackground(Color.PINK);//��������������ı�����ɫ
		
		this.add(jl1,BorderLayout.NORTH);//��ͼƬ���������
		this.add(jpb,BorderLayout.SOUTH);//�ѽ�����������ϲ�
		
		this.setSize(600,360);
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//��Ļ�Ŀ�ȳ��Զ�-200�������Ǵ��ڵĺ����꣬�߶ȳ��Զ�-150����������
		this.setLocation(width/2-350,height/2-300);
		this.setVisible(true);	
	}

	public void run() {
		//pv�����������װ�������İٷֱȵ�����
		int [] pv=new int[5];
		for(int i=0;i<pv.length;i++){
			pv[i]=(i+1)*20;
		}
		for(int i=0;i<pv.length;i++){
			try {
				Thread.sleep(1000);//˯��һ����
			} catch (InterruptedException e) {
				
			}
			/**
			 * �ѽ������ֳ��������ֵ������
			 * �����ֵΪ1������ 1������Ϊ��ֵΪ��ʮ��������50
			 */
			jpb.setValue(pv[i]);
		}
		new login();
		this.dispose();//�õ�ǰ����ر�
	}
}
