package Tanks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Tanks.Nitrometris;
import Tanks.Notes;
import Tanks.Tank1;

/**
 * ��һ����������һ�����壬���ҳ�ʼ������
 * @author С����-ST-PRO
 *
 */
public class Tank1 extends JFrame implements ActionListener{
	//ʵ�ֽӿ�,Ҳ���Ƕ��������˵��ť�ļ���

	MyPanel mp=null;

	Nitrometris gk=null;//����һ��,�ؿ����

	JMenuBar cdl=null;//�˵���壬�����Ų˵���
	JMenu cd01=null;//��Ϸ�˵�
	JMenuItem cdxl= null;//��Ϸ�˵���Ķ����˵���Ŀ,�����ж��,���������Ϸ
	JMenuItem cdx2=null;//��Ϸ��G���Ķ����˵��˳���Ϸ
	JMenuItem cdx3=null;//��Ϸ��G���Ķ����˵������˳�
	JMenuItem cdx4=null;//��Ϸ��G���Ķ����˵�������Ϸ

	public static void main(String[] args) {
		Tank1 t1=new Tank1();
	}
	public Tank1(){
			
		cdl=new JMenuBar();
		cd01=new JMenu("��Ϸ(G)");
		cd01.setMnemonic('G');//������Ϸ�Ŀ�ݼ�
		cdxl=new JMenuItem("����Ϸ��N��");//��Ϸ�˵��Ķ����˵�
		cdxl.setMnemonic('N');
		cdx2=new JMenuItem("�˳���Ϸ(E)");
		cdx2.setMnemonic('E');
		cdx3=new JMenuItem("�����˳�(C)");
		cdx3.setMnemonic('C');
		cdx4=new JMenuItem("������Ϸ(S)");
		cdx4.setMnemonic('S');

		//ActionListener�Ǽ����������˼,��������а�ť
		cdx4.addActionListener(this);
		cdx4.setActionCommand("goOnGame");//������Ϸ���
		cdx3.addActionListener(this);
		cdx3.setActionCommand("saveExit");//�����˳�
		cdx2.addActionListener(this);
		cdx2.setActionCommand("exit");//�˳���Ϸ
		cdxl.addActionListener(this);//��ʼ����,Ҳ���Ƕ��������˵��ť�ļ���
		cdxl.setActionCommand("NewGame");//����һ������HTML���id�����������������ť
		
		cd01.add(cdxl);
		cd01.add(cdx2);
		cd01.add(cdx3);
		cd01.add(cdx4);
		cdl.add(cd01);
		this.setJMenuBar(cdl);

		gk=new Nitrometris();//newһ���ؿ���Ķ���

		//newһ���ؿ������̣߳����ҿ������ؿ������ͻ�����˸��Ч��
		Thread t1=new Thread(gk);
		t1.start();

		this.add(gk);//��ӵ�һ�صĹؿ����

		//���ͼƬ�����Ͻ�
		ImageIcon tp1=new ImageIcon("/2.png");
		this.setIconImage(tp1.getImage());
		this.setTitle("̹�˴�ս");
		this.setSize(1100,900);
		this.setLocation(400, 50);
		this.setResizable(false);//�������û��ı䴰�ڵĽ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//ʵ��ActionListener�ӿھͱ���ʵ�����ķ���	
		if(e.getActionCommand().equals("NewGame")){
			//�����������Ϸ��NewGame���Ͱ���Ϸ����new����
			mp=new MyPanel("NewGame");
			
			this.remove(gk);//new������ͬʱɾ�������
 
			this.add(mp);
			//�����mp�м���Լ��̵ļ���
			this.addKeyListener(mp);

			//����һ���̣߳�û������ӵ��޷��������
			Thread t=new Thread(mp);
			t.start();
			this.setVisible(true);
		}else if(e.getActionCommand().equals("goOnGame")){
			//������������Ϸ���
			mp=new MyPanel("goOnGame");//newһ��������Ϸ������������new���������ϴα���Ľ���
			Thread t=new Thread(mp);
			t.start();
			
			
			this.remove(gk);//ɾ���ؿ����
			this.add(mp);//��ӵ�ǰ���
			this.addKeyListener(mp);//��Ӽ��̼���
			this.setVisible(true);//��ʾ����
			
		}else if(e.getActionCommand().equals("saveExit")){
			//�����������˳����
			Notes jl=new Notes();//newһ����¼�Ķ���
			jl.ETank(mp.ETank);//��������Vector�з�̹���ഫ�ݹ�ȥʹ��ETank����
			jl.saveGame();
			System.exit(0);//�˳�ϵͳ
		}else if(e.getActionCommand().equals("exit")){
			//�������˳���Ϸ
		
			Notes.saveNotes();//����һ�α���ɱ�������ķ����������¼
			System.exit(0);//�˳�ϵͳ
		}
	}
}