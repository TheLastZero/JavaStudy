package Students;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

/**
 *  ��JDBC�������ݿ��Java��һ���򵥵�ѧ������ϵͳ,ʵսƪ
 * @author С����-ST-PRO
 *
 */
public class Students_Start extends JFrame implements ActionListener{
	/**
	 * JFrame��һ������װJPanel����������ActionListener�Ƕ԰�ť�ļ���
	 * @param args                                   
	 */
	JPanel mb1,mb2;
	JLabel bq1;//��ǩ
	JTextField wbk1;//�ı���
	JButton an1,an11,an2,an3,an4;//�ĸ���ť
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
		Students_Start xs=new Students_Start();
	}

	Students_Start(){//���췽��
		mb1=new JPanel();//���1
		bq1=new JLabel("����������");//��ǩ1
		wbk1=new JTextField(15);//�ı���
		an1=new JButton("��ѯ");//��ѯ��ť
		an1.addActionListener(this);//���Ӷ԰�ť1�ļ���
		an1.setActionCommand("find");//����������css��ID

		an11=new JButton("��ʾ����ѧ����Ϣ");
		an11.addActionListener(this);
		an11.setActionCommand("all");
		//�����������������1
		mb1.add(bq1);	mb1.add(wbk1);	mb1.add(an1);	mb1.add(an11);

		mb2=new JPanel();//���2
		an2=new JButton("���");//��Ӱ�ť
		an2.addActionListener(this);
		an2.setActionCommand("add");
		an3=new JButton("�޸�");//�޸İ�ť
		an3.addActionListener(this);
		an3.setActionCommand("modify");
		an4=new JButton("ɾ��");//ɾ����ť
		an4.addActionListener(this);
		an4.setActionCommand("delete");
		mb2.add(an2);	mb2.add(an3);	mb2.add(an4);

		//new���ֶεĶ���ļ�����
		field=new Vector();
		//���ֶ������ʾ������ϵ�����
		field.add("ѧ��");
		field.add("����");
		field.add("�Ա�");
		field.add("����");

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

		this.setTitle("ѧ����Ϣ����ϵͳ");
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
		if(e.getActionCommand().equals("find")){//����
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
		if(e.getActionCommand().equals("modify")){//�޸�
			//ii��ʾ���ѡ�е���һ��
			int ii=this.bg1.getSelectedRow();
			System.out.println(ii);
			if(ii==-1){//���iiû�б�ѡ�У��͵���һ���Ի���
				JOptionPane.showMessageDialog(this,"��ѡ��Ҫ�޸ĵ���");
				return;//���return��ʾ���ص��õĵط�
			}
			stu_modify sf6=new stu_modify(this,"�޸�ѧ����Ϣ",true,ii);
			
			stu_find sf7=new stu_find();
			bg1.setModel(sf7);
			
			System.out.println("modify");
		}
		if(e.getActionCommand().equals("add")){//���

			//�������ڵı�����"���ѧ����Ϣ"��true��ʾ�ڴ˴���ʱ�޷��Ը��ര�ڲ���
			stu_add a=new stu_add(this,"���ѧ����Ϣ",true);
			//Ϊ�˷������֮�󿴵�����ѧ����Ϣ��������newһ��
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
			
			System.out.println("add");
		}
		if(e.getActionCommand().equals("delete")){//ɾ��

			//ii��ʾ���ѡ�е���һ��
			int ii=this.bg1.getSelectedRow();
			System.out.println(ii);
			if(ii==-1){//���iiû�б�ѡ�У��͵���һ���Ի���
				JOptionPane.showMessageDialog(this,"��ѡ��Ҫɾ������");
				return;//���return��ʾ���ص��õĵط�
			}

			stu_find sf3=new stu_find();
			/**
			 * ����һ��Object��ֵ��ǿת��int����,
			 * ii�����У�0�����һ��
			 * �����ѡ�е���ii��,
			 * ��ô�����صľ���ii�У�0�еı��ڵ���Ϣ����ѧ�����е�һ����ѧ����ID
			 * ��������Object���͵ģ�������Ҫת����int������String����
			 * ��Ҫ������֮ǰ�ı�����ֶ�����ʲô���ͽ��յ�
			 */
			int st=(int)sf3.getValueAt(ii,0);
			System.out.println(st);
			
			try{
				/**
				 * �����������ݿ�
				 */
				PreparedStatement ps=null;
				Connection ct=null;
				ResultSet rs=null;
				//���ú����ݿ�
				//��������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//ѡ�����ݿ⣬дSQL���˺�����
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

				//дSQL���
				String s=("delete stuInfo where stuId=?");
				ps=ct.prepareStatement(s);
				//�����1������ǵ�1���ʺţ�������ʺŶ�Ӧ������ֶ�
				ps.setInt(1, st);
				
				int databaseNum=ps.executeUpdate();
				System.out.println("ɾ���ɹ�");

			}catch(Exception e4){

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
				}catch(Exception e2){

				}
			}	
			stu_find sf5=new stu_find();
			bg1.setModel(sf5);
			System.out.println("delete");
		}
	}
}
