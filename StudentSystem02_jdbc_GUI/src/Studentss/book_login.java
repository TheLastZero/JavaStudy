package Studentss;

import java.awt.Color;
import java.awt.Graphics;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class book_login extends JDialog implements ActionListener{
	
	JLabel jl1,jl2;//�û���������������ǩ
	JButton jb1,jb2,jb3;//��¼��ȡ����ע��������ť
	JTextField wbk1;//�û��������룬�����ı���
	JPasswordField wbk2;

	book_login(){
		jl1=new JLabel("�û���:",JLabel.LEFT);
		jl1.setBounds(140,180,100,100);
		this.add(jl1);
		wbk1=new JTextField();
		wbk1.setBounds(190,215,150,30);
		this.add(wbk1);

		jl2=new JLabel("��    ��:",JLabel.LEFT);
		jl2.setBounds(140,220,100,100);
		this.add(jl2);
		wbk2=new JPasswordField(15);
		wbk2.setBounds(190,255,150,30);
		this.add(wbk2);

		//new����¼��ť�����Ҽ����¼�
		jb1=new JButton("��¼");
		jb1.setBounds(130,300,60,30);
		jb1.addActionListener(this);
		jb1.setActionCommand("login");;
		this.add(jb1);

		//new��ȡ����ť�����Ҽ����¼�
		jb2=new JButton("ȡ��");
		jb2.setBounds(210,300,60,30);
		jb2.addActionListener(this);
		jb2.setActionCommand("cancel");;
		this.add(jb2);

		//new��ע�ᰴť�����Ҽ����¼�
		jb3=new JButton("ע��");
		jb3.setBounds(290,300,60,30);
		jb3.addActionListener(this);
		jb3.setActionCommand("sign");;
		this.add(jb3);

		this.add(jb2);
		this.add(jb3);

		BackImage b=new BackImage();
		b.setBounds(0,0,500,250);
		this.add(b);
		
		this.setLayout(null);//�ղ���		
		this.setTitle("�鼮ϵͳ��¼");
		this.setSize(500,350);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);//Ϊtrueʱ������ʾ�߿�
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			System.out.println("��¼��ť");
			checkLogin();
		}
		if(e.getActionCommand().equals("cancel")){
			System.out.println("ȡ��");
			System.exit(-1);
		}
		if(e.getActionCommand().equals("sign")){
			System.out.println("ע��");
			sign();
		}
	}

	void checkLogin(){//����û��������Ƿ�ƥ��
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
			ps=ct.prepareStatement("select  * from stuAdmin");
			//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
			rs=ps.executeQuery();
			
			System.out.println("���ӳɹ�");

			String nowName=wbk1.getText();//�ı����е��û���
			String nowPassword=wbk2.getText();//�ı����е��û���
			System.out.println("��ȡ�ı�������û�������"+nowName+"  " +nowPassword);

			boolean f1=true;//�����ж��û��������Ƿ����
			
			while(rs.next()){
				System.out.println("��ʼ�˶��û�������");
				//ÿ�ζ�ȡһ�У��е������ֶ�
				String stuName=rs.getString(1);//�õ����ݿ��е��û���
				String stuPassword=rs.getString(2);//�õ����ݿ��е�����
				System.out.println(stuName+"  "+stuPassword);
				if(stuName.equals(nowName) && stuPassword.equals(nowPassword)){
					Students_Start xs=new Students_Start();
					this.setVisible(false);
					f1=false;//����гɹ���½���Ͱ�f1��Ϊfalse���Ͳ�������û���������仰
					break;
				}else{
					
				}
			}
			if(f1){
				JOptionPane.showMessageDialog(this,"�û��������������");
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
	void sign(){//ע�᷽��
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
			ps=ct.prepareStatement("select  * from stuAdmin");
			//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
			rs=ps.executeQuery();

			System.out.println("���ӳɹ�");

			String nowName=wbk1.getText();//�ı����е��û���
			String nowPassword=wbk2.getText();//�ı����е��û���
			System.out.println("��ȡ�ı�������û�������"+nowName+"  " +nowPassword);

			boolean f2=true;
			
			while(rs.next()){
				System.out.println("��ʼ�˶��û�������ֹ��ӵ��ظ����û���");
				//ÿ�ζ�ȡһ�У��е������ֶ�
				String stuName=rs.getString(1);//�õ����ݿ��е��û���
				String stuPassword=rs.getString(2);//�õ����ݿ��е�����
				System.out.println(stuName+"  "+stuPassword);
				if(stuName.equals(nowName)){
					JOptionPane.showMessageDialog(this,"���û����Ѿ���ʹ��");
					f2=false;//�������ͬ�û�����ֹͣ����
					return;//���return��ʾ���ص��õĵط�
				}else{	
				}
			}
			if(f2){
				System.out.println("��ʼ�����û�");
				String s=("insert into stuAdmin values(?,?)");
				ps=ct.prepareStatement(s);
				ps.setString(1,nowName);
				ps.setString(2,nowPassword);
				ps.execute();
				JOptionPane.showMessageDialog(this,"�����û����ɹ�");
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

class BackImage extends JPanel{
	Image im;
	public BackImage(){
		try{
			im=ImageIO.read(new File("image/2.jpg"));
		}catch(Exception e){

		}	
	}
		public void paint(Graphics g){
			g.drawImage(im,0,0,500,200,this);
	}
}






