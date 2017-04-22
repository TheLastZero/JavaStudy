package Studentss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class stuInfo extends JFrame implements ActionListener{
	/**
	 * JFrame��һ������װJPanel����������ActionListener�Ƕ԰�ť�ļ���
	 * @param args                                   
	 */
	JPanel mb1,mb2;
	JLabel bq1;//��ǩ
	JTextField wbk1;//�ı���
	JButton an1,an11,an2,an3,an4,an5;//�ĸ���ť
	JTable bg1;//���
	JScrollPane gd1;//������

	Vector field,notes;//�ֶκͼ�¼,�ļ�����

	/**
	 * �����������ݿ�
	 */
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;

	public static void main(String[] args) {
		stuInfo xs=new stuInfo();
	}

	stuInfo(){//���췽��
		mb1=new JPanel();//���1
		bq1=new JLabel("������ѧ������");//��ǩ1
		wbk1=new JTextField(15);//�ı���
		an1=new JButton("��ѯ");//��ѯ��ť
		an1.addActionListener(this);//���Ӷ԰�ť1�ļ���
		an1.setActionCommand("find");//����������css��ID

		an11=new JButton("��ʾ���н�����Ϣ");
		an11.addActionListener(this);
		an11.setActionCommand("all");
		//�����������������1
		mb1.add(bq1);	mb1.add(wbk1);	mb1.add(an1);	mb1.add(an11);

		mb2=new JPanel();//���2
		an2=new JButton("����");//��Ӱ�ť
		an2.addActionListener(this);
		an2.setActionCommand("borrow");
		an3=new JButton("����");//�޸İ�ť
		an3.addActionListener(this);
		an3.setActionCommand("return");
		an4=new JButton("���ֻ���Ʒ");//ɾ����ť
		an4.addActionListener(this);
		an4.setActionCommand("gift");
		an5=new JButton("�л����鼮��Ϣ");//ɾ����ť
		an5.addActionListener(this);
		an5.setActionCommand("bookInfo");
		mb2.add(an2);	mb2.add(an3);	
		mb2.add(an4);	mb2.add(an5);

		//new���ֶεĶ���ļ�����
		field=new Vector();
		//���ֶ������ʾ������ϵ�����
		field.add("�����˱��");
		field.add("����������");
		field.add("�ѽ��鼮����");
		field.add("��ǰ����");

		//new����¼�ļ�����
		notes=new Vector();

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

			while(rs.next()){
				//ÿ�ζ�ȡһ�У��е������ֶ�
				//newһ���е��ֶ����ţ������ӵ���Ϣ�ֶ�
				Vector line =new Vector();
				line.add(rs.getInt(1));//�õ�ID,1�����һ���ֶ�
				line.add(rs.getString(2));//�õ����֣������ڵ�2���ֶ�
				line.add(rs.getString(3));//�õ��Ա�
				line.add(rs.getInt(4));//�õ�����

				//��һ�������е���Ϣ��ȡ��Ȼ��ŵ���¼��
				notes.add(line);
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

		//����¼���ֶ���ӵ������
		bg1=new JTable(notes,field);//��д��¼,��д�ֶ�
		//ʹ�����Թ���
		gd1=new JScrollPane(bg1);

		this.add(gd1);//����������ӽ�
		this.add(mb1,"North");//��mb1������������
		this.add(mb2,"South");//��mb2���������ϲ�

		this.setTitle("�鼮��Ϣ����ϵͳ");
		this.setSize(700,600);
		this.setLocation(600, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * Ҫʵ��ActionListener�Ľӿڣ���Ҫʵ�����ĳ��󷽷�
	 * �Ե���ؼ��ļ���
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("find")){//���ҽ�������Ϣ
			//���ı�������ֵ�ֵ����name
			String name=this.wbk1.getText().trim();
			String sql="select * from stuInfo where stuName='"+name+"'";
			stu_find sf=new stu_find(sql);
			bg1.setModel(sf);//������ʾ������Ч��
			System.out.println("find");
		}
		if(e.getActionCommand().equals("all")){
			//���ı�������ֵ�ֵ����name
			String name=this.wbk1.getText().trim();
			String sql="select * from stuInfo";
			stu_find sf=new stu_find(sql);
			bg1.setModel(sf);//������ʾ������Ч��
			System.out.println("all");
		}
		if(e.getActionCommand().equals("return")){//����
			stu_return sf6=new stu_return(this,"�黹�鼮��Ϣ",true);
			
			book_find sf7=new book_find();
			bg1.setModel(sf7);
			System.out.println("return");
		}
		if(e.getActionCommand().equals("borrow")){//����
			//�������ڵı�����"���ѧ����Ϣ"��true��ʾ�ڴ˴���ʱ�޷��Ը��ര�ڲ���
			stu_borrow a=new stu_borrow(this,"��ӽ�����Ϣ",true);
			//Ϊ�˷������֮�󿴵�����ѧ����Ϣ��������newһ��
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
			System.out.println("borrow");
		}
		if(e.getActionCommand().equals("gift")){//���ֻ���Ʒ
			System.out.println("����˻��ֻ���Ʒ��ť");
			gift g=new gift(this,"�һ�����",true);
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
		}
		if(e.getActionCommand().equals("bookInfo")){//�鿴ѧ����Ϣ
			System.out.println("�鿴ѧ����Ϣ");
			//�رյ�ǰ����
			this.dispose();
			Students_Start xs=new Students_Start();
		}
	}
}
