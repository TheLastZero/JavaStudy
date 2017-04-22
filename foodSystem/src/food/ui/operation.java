package food.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

public class operation extends JFrame{//����
	Image titleIcon,timebg;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
	ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
	
	JToolBar jtb;//������
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	JPanel jp1,jp2,jp3,jp4,jp5;
	JPanel jp3_1,jp3_2,jp3_3,jp3_4,jp3_5,jp3_6,jp3_7;
	
	Image jp1_bg;
	JLabel jp1_lab1,jp1_lab2,jp1_lab3,jp1_lab4,jp1_lab5,jp1_lab6,jp1_lab7,jp1_lab8;
	JLabel jp2_lab1,jp2_lab2;
	Image jp3_bg;
	JLabel jp3_l1,jp3_l2,jp3_l3,jp3_l4,jp3_l5,jp3_l6,jp3_l7;
	CardLayout cardjp2,cardjp3;
	JSplitPane jsp1;//���Ҳ�ֵ�
	JLabel timeNow;
	javax.swing.Timer t;
	
	public static void main(String[] args) {
		operation o=new operation();
	}
	
	public void initMenu(){
		jm1_icon1=new ImageIcon("image/Tools/����.PNG");
		jm1_icon2=new ImageIcon("image/Tools/��.PNG");
		jm1_icon3=new ImageIcon("image/Tools/����.PNG");
		jm1_icon4=new ImageIcon("image/Tools/����.PNG");
		jm1_icon5=new ImageIcon("image/Tools/ճ��.PNG");
		
		jm1=new JMenu("ϵͳ����");
		
		jmm1=new JMenuItem("�л��û�",jm1_icon1);
		
		jmm2=new JMenuItem("�л����տ����",jm1_icon1);
		
		jmm3=new JMenuItem("��¼����",jm1_icon1);
		
		jmm4=new JMenuItem("������",jm1_icon1);
		
		jmm5=new JMenuItem("�˳�",jm1_icon1);
		
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		jm2=new JMenu("���¹���");
		
		jm3=new JMenu("�˵�����");
		
		jm4=new JMenu("����ͳ��");
		
		jm5=new JMenu("�ɱ����ⷿ");
		
		jm6=new JMenu("����");
		
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		this.setJMenuBar(jmb);
	}
	
	public void initToolBar(){
		jtb=new JToolBar();
		//���ù������Ƿ���Ա��϶����ƶ�
		jtb.setFloatable(false);
		
		jb1=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb2=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb3=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb4=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb5=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb6=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb7=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb8=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb9=new JButton(new ImageIcon("image/Tools/����.PNG"));
		jb10=new JButton(new ImageIcon("image/Tools/����.PNG"));
		
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
		
		//�ѹ������ŵ����ڱ���
		this.add(jtb,BorderLayout.NORTH);
	}
	
	public void initAllPanel(){
		jp1=new JPanel(new BorderLayout());
		try{
			jp1_bg=ImageIO.read(new File("image/3.png"));
			
		}catch(Exception e){
			
		}
		
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
		
		jp1_lab1=new JLabel(new ImageIcon("image/Tools/����.PNG"));
		
		jp1_lab2=new JLabel("���¹���",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab2.setCursor(myCursor);
		jp1_lab2.setEnabled(false);
		
		jp1_lab3=new JLabel("��¼����",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab3.setCursor(myCursor);
		jp1_lab3.setEnabled(false);//����ʾ�����ָ������ʱ����ʾ
		
		jp1_lab4=new JLabel("���׼۸�",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab4.setCursor(myCursor);
		jp1_lab4.setEnabled(false);
		
		jp1_lab5=new JLabel("����ͳ��",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab5.setCursor(myCursor);
		jp1_lab5.setEnabled(false);
		
		jp1_lab6=new JLabel("�ɱ����ⷿ",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab6.setCursor(myCursor);
		jp1_lab6.setEnabled(false);
		
		jp1_lab7=new JLabel("ϵͳ����",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab7.setCursor(myCursor);
		jp1_lab7.setEnabled(false);
		
		jp1_lab8=new JLabel("��������",new ImageIcon("image/Tools/����.PNG"),0);
		jp1_lab8.setCursor(myCursor);
		jp1_lab8.setEnabled(false);
		
		jp4=new JPanel(new BorderLayout());
		this.cardjp2=new CardLayout();
		jp2=new JPanel(cardjp2);
		
		jp2_lab1=new JLabel(new ImageIcon("image/Tools/����.PNG"));
		
		jp2_lab2=new JLabel(new ImageIcon("image/Tools/����.PNG"));
		
		jp2.add(jp2_lab1,"0");
		jp2.add(jp2_lab2, "1");
		
		this.cardjp3=new CardLayout();
		jp3=new JPanel(cardjp3);
		try{
			jp3_bg=ImageIO.read(new File("image/Tools/��.PNG"));
		}catch(Exception e){
			
		}
		jp3_l1=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l2=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l3=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l4=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l5=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l6=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		jp3_l7=new JLabel(new ImageIcon("image/Tools/ճ��.PNG"));
		
		jp3_1=new JPanel();
		jp3_1.add(jp3_l1);
		jp3_2=new JPanel();
		jp3_2.add(jp3_l2);
		jp3_3=new JPanel();
		jp3_3.add(jp3_l3);
		jp3_4=new JPanel();
		jp3_4.add(jp3_l4);
		jp3_5=new JPanel();
		jp3_5.add(jp3_l5);
		jp3_6=new JPanel();
		jp3_6.add(jp3_l6);
		jp3_7=new JPanel();
		jp3_7.add(jp3_l7);
		
		jp3.add(jp3_1,"1");
		jp3.add(jp3_2,"2");
		jp3.add(jp3_3,"3");
		jp3.add(jp3_4,"4");
		jp3.add(jp3_5,"5");
		jp3.add(jp3_6,"6");
		jp3.add(jp3_7,"7");
		jp4.add(jp2,BorderLayout.WEST);
		jp4.add(jp3,BorderLayout.CENTER);
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		jsp1.setDividerLocation(150);
		jsp1.setDividerSize(0);
		this.add(jsp1,BorderLayout.CENTER);
		
	}
	
	public void initJp5(){
		jp5=new JPanel();
		jp5.setLayout(new BorderLayout());
		
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		
		try{
			timebg=ImageIO.read(new File("image/Tools/����.PNG"));
		}catch(Exception e){
			
		}
		this.add(jp5,BorderLayout.SOUTH);
	}
	public operation(){
		try{
			titleIcon=ImageIO.read(new File("image/Tools/����.PNG"));
		}catch(Exception e){}
		
		this.setIconImage(titleIcon);
		this.setTitle("�����ʲ�������ϵͳ");
		this.initMenu();
		this.initToolBar();
		this.initAllPanel();
		this.initJp5();
		this.setSize(800,700);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//��Ļ�Ŀ�ȳ��Զ�-200�������Ǵ��ڵĺ����꣬�߶ȳ��Զ�-150����������
		this.setLocation(width/2-350,height/2-300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}