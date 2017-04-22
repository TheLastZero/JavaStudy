package Studentss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gift extends JDialog implements ActionListener{
	/**
	 * JDialog�������ԴӴ���������������,
	 * �������Ĵ��ڣ�����Ҫ�ȶ��������ڲ����󣬲��ܻص�ԭ���ڲ���
	 * ActionListener�����ؼ�
	 */
	JLabel bq1,bq2,bq3;//��ǩ
	JLabel bq4,bq5,bq6;//��Ʒ1��2��3����Ϣ
	JLabel bq7,bq8,bq9;//��Ʒ1��2��3�����
	JTextField wbk1,wbk2,wbk3;//�ı���
	JButton an1,an2;//��ť

	public gift(Frame fck,String ckm,Boolean msck){//���췽��
		super(fck,ckm,msck);

		//new����Ʒ��ǩ
		bq4=new JLabel("ůů����һ�ף�1000���֣�");
		bq4.setBounds(30,100,180,100);
		bq4.setForeground(Color.red);
		this.add(bq4);

		bq5=new JLabel("����ϴ�·ۣ�500���֣�");
		bq5.setBounds(210,100,180,100);
		bq5.setForeground(Color.red);
		this.add(bq5);

		bq6=new JLabel("����ʮ���Σ�50000���֣�");
		bq6.setBounds(370,100,180,100);
		bq6.setForeground(Color.red);
		this.add(bq6);

		//new����Ʒ���
		bq7=new JLabel("(1)");
		bq7.setBounds(90,120,180,100);
		bq7.setForeground(Color.red);
		this.add(bq7);
		bq8=new JLabel("(2)");
		bq8.setBounds(270,120,180,100);
		bq8.setForeground(Color.red);
		this.add(bq8);
		bq9=new JLabel("(3)");
		bq9.setBounds(430,120,180,100);
		bq9.setForeground(Color.red);
		this.add(bq9);

		//new����ǩ
		bq1=new JLabel("          �һ��˱��:");
		bq1.setBounds(90,160,100,100);
		this.add(bq1);
		bq2=new JLabel("          �һ�������:");
		bq2.setBounds(90,195,100,100);
		this.add(bq2);
		bq3=new JLabel("          �һ���Ʒ���:");
		bq3.setBounds(90,230,120,100);
		this.add(bq3);

		//new����ǩ����ı������ó���Ϊ10
		wbk1=new JTextField(5);//new���ı��򳤶�Ϊ10
		wbk1.setBounds(220,195,150,30);
		this.add(wbk1);
		wbk2=new JTextField(5);
		wbk2.setBounds(220,230,150,30);
		this.add(wbk2);
		wbk3=new JTextField(5);
		wbk3.setBounds(220,265,150,30);
		this.add(wbk3);

		//new����ӣ�ȡ��������ť���������Ӽ���
		an1=new JButton("�һ�");
		an1.addActionListener(this);
		an1.setActionCommand("gift");
		an1.setBounds(220,320,60,30);
		this.add(an1);
		an2=new JButton("ȡ��");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//ȡ��
		an2.setBounds(290,320,60,30);
		this.add(an2);

		/**
		 * ��ӽ�Ʒ������ͼƬ
		 */
		BackImage2 b1=new BackImage2("image/3.jpg");
		b1.setBounds(30,30,150,100);
		this.add(b1);
		BackImage2 b2=new BackImage2("image/4.jpg");
		b2.setBounds(200,30,150,100);
		this.add(b2);
		BackImage2 b3=new BackImage2("image/2.jpg");
		b3.setBounds(370,30,150,100);
		this.add(b3);

		this.setLayout(null);//�ղ���	
		this.setSize(550,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//��������ڴ��ڴ�С
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("gift")){
			System.out.println("����˶һ���ť");
			exchange();
		}
		if(e.getActionCommand().equals("cancel")){
			this.dispose();//�رյ�ǰ����
		}
	}

	public void exchange(){//�һ�
		System.out.println("��ʼ�һ�����");
		int i=0;
		if(wbk3.getText().equals("1")){
			i=1000;
		}else if(wbk3.getText().equals("2")){
			i=500;
		}else if(wbk3.getText().equals("3")){
			i=50000;
		}else{
			JOptionPane.showMessageDialog(this,"��������ȷ����Ʒ�һ����");
			return;//���return��ʾ���ص��õĵط�
		}

		/**
		 * �����������ݿ�
		 */
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;

		try{//���ú����ݿ�
			//��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//ѡ�����ݿ⣬дSQL���˺�����
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			//дSQL���
			ps=ct.prepareStatement("select * from stuInfo");
			//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
			rs=ps.executeQuery();
			System.out.println("���ӳɹ�");
			boolean f5=true;
			while(rs.next()){
				//�ж��Ƿ������ѧ�����˶�ID������
				if(rs.getString(1).equals(wbk1.getText())&&rs.getString(2).equals(wbk2.getText())){
					System.out.println("ѧ�����ڣ�������һ��");
					
					String s1=rs.getString(4);//��ȡ����
					int it=Integer.parseInt(s1);
					if(it>i){
						System.out.println("ѧ�����ִ��ڶһ����֣�����һ�����");
						int it2=it-i;
						String s2=String.valueOf(it2);
						System.out.println(s2);
						//���»�����Ϣ
						ps=ct.prepareStatement("update stuInfo set stuScore=? where stuId=?");
						ps.setString(1,s2);
						ps.setString(2,wbk1.getText());
						int databaseNum6=ps.executeUpdate();
						System.out.println("���ָ��³ɹ�");
						
						JOptionPane.showMessageDialog(this,"�һ���Ʒ�ɹ�");
						f5=false;
						return;//���return��ʾ���ص��õĵط�
					}else{
						JOptionPane.showMessageDialog(this,"ѧ�����ֲ��㣬�޷��һ�");
						return;//���return��ʾ���ص��õĵط�
					}
				}else{
					
				}			
			}
			if(f5){
				JOptionPane.showMessageDialog(this,"ѧ����Ϣ������������д");
				return;//���return��ʾ���ص��õĵط�
			}
		}catch(Exception e){

		}
		finally{//����ر���Դ
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(ct!=null){
					ct.close();
				}
			}catch(Exception e){

			}
		}
	}
}

class BackImage2 extends JPanel{
	Image im;
	BackImage2(String s){
		try{
			im=ImageIO.read(new File(s));
		}catch(Exception e){

		}	
	}
	public void paint(Graphics g){
		g.drawImage(im,0,0,150,100,this);
	}
}
