package Studentss;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;
/**
 * ���ѧ����Ϣ
 * @author С����-ST-PRO
 *
 */
public class book_add extends JDialog implements ActionListener{
	/**
	 * JDialog�������ԴӴ���������������,
	 * �������Ĵ��ڣ�����Ҫ�ȶ��������ڲ����󣬲��ܻص�ԭ���ڲ���
	 * ActionListener�����ؼ�
	 */
	JLabel bq1,bq2,bq3,bq4;//��ǩ
	JTextField wbk1,wbk2,wbk3,wbk4;//�ı���
	JButton an1,an2;//��ť
	JPanel mb1,mb2,mb3,mb4;//�ĸ����

	public book_add(Frame fck,String ckm,Boolean msck){//���췽��
		super(fck,ckm,msck);
		//new����ǩ
		bq1=new JLabel("          ���");
		bq2=new JLabel("          ����");
		bq3=new JLabel("          �۸�");
		bq4=new JLabel("          ����");

		//new����ǩ����ı������ó���Ϊ10
		wbk1=new JTextField(5);//new���ı��򳤶�Ϊ10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);
		wbk4=new JTextField(5);

		//new����ӣ�ȡ��������ť���������Ӽ���
		an1=new JButton("���");
		an1.addActionListener(this);
		an1.setActionCommand("add2");;
		an2=new JButton("ȡ��");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//ȡ��

		//new���ĸ����
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		mb4=new JPanel();

		//�����񲼾ֹ�����������һ��
		mb1.setLayout(new GridLayout(4,1));
		mb2.setLayout(new GridLayout(4,1));

		//���1�������4����ǩ
		mb1.add(bq1);	mb1.add(bq2);
		mb1.add(bq3);	mb1.add(bq4);

		//���2��������ı���
		mb2.add(wbk1);	mb2.add(wbk2);
		mb2.add(wbk3);	mb2.add(wbk4);

		//�����3��ӣ��ύ��ȡ��������ť
		mb3.add(an1);	mb3.add(an2);


		this.add(mb1,BorderLayout.WEST);
		this.add(mb2);//Ĭ��Ϊ�߽粼�ֹ��������в�
		this.add(mb3,BorderLayout.SOUTH);
		this.add(mb4,BorderLayout.EAST);

		this.setSize(400,200);
		this.setLocation(750, 400);
		this.setResizable(false);//��������ڴ��ڴ�С
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		//�̳�JDialog��������ʵ�ֵķ���,�԰�ť�ؼ��ļ������Լ�ʵ��
		if(e.getActionCommand().equals("add2")){
			Vector field,notes;//�ֶκͼ�¼,�ļ�����
			/**
			 * �����������ݿ�
			 */
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;

			//new���ֶεĶ���ļ�����
			field=new Vector();
			//���ֶ������ʾ������ϵ�����
			field.add("���");
			field.add("����");
			field.add("�۸�");
			field.add("����");

			//new����¼�ļ�����
			notes=new Vector();

			try{//���ú����ݿ�
				//��������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//ѡ�����ݿ⣬дSQL���˺�����
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

				//дSQL���
				String s=("insert into bookInfo values(?,?,?,?)");
				ps=ct.prepareStatement(s);
				
				/**
				 * ��ȡ�ı����е��ַ����ŵ�ps��Ӧ��1234�ֶ���
				 * setString����һ��Ҫ�����ݿ�ı���ֶε�����һ��
				 * ���������
				 */
				System.out.println("��ʼ���");
				//�����1234������ǵ�1234���ʺţ�������ʺŴ���������ݿ�����ֶε�˳��
				ps.setString(1,wbk1.getText());
				System.out.println("���id�ɹ�");
				ps.setString(2,wbk2.getText());
				System.out.println("������ֳɹ�");
				ps.setString(3,wbk3.getText());
				System.out.println("��Ӽ۸�ɹ�");
				ps.setString(4,wbk4.getText());
				System.out.println("��ӻ��ֳɹ�");
				
				//ִ��SQL��䣬���ҷ��ص�ǰ��ִ�гɹ�������
				int databaseNum=ps.executeUpdate();
				System.out.println("����鼮��Ϣ�ɹ�");
				
				//�رյ�ǰ����
				this.dispose();
				
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this,"�벻Ҫ������ͬ���鼮���");
				return;//���return��ʾ���ص��õĵط�
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
		}
		if(e.getActionCommand().equals("cancel")){
			this.dispose();//�رյ�ǰ����
		}
	}
}