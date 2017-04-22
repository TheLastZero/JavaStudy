package Studentss;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stu_borrow extends JDialog implements ActionListener{
	/**
	 * JDialog�������ԴӴ���������������,
	 * �������Ĵ��ڣ�����Ҫ�ȶ��������ڲ����󣬲��ܻص�ԭ���ڲ���
	 * ActionListener�����ؼ�
	 */
	JLabel bq1,bq2,bq3;//��ǩ
	JTextField wbk1,wbk2,wbk3;//�ı���
	JButton an1,an2;//��ť
	JPanel mb1,mb2,mb3,mb4;//�ĸ����

	public stu_borrow(Frame fck,String ckm,Boolean msck){//���췽��
		super(fck,ckm,msck);
		//new����ǩ
		bq1=new JLabel("          �����˱��");
		bq2=new JLabel("          ����������");
		bq3=new JLabel("          ����");

		//new����ǩ����ı������ó���Ϊ10
		wbk1=new JTextField(5);//new���ı��򳤶�Ϊ10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);

		//new����ӣ�ȡ��������ť���������Ӽ���
		an1=new JButton("����");
		an1.addActionListener(this);
		an1.setActionCommand("borrow");;
		an2=new JButton("ȡ��");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//ȡ��

		//new���ĸ����
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		mb4=new JPanel();

		//�����񲼾ֹ�����������һ��
		mb1.setLayout(new GridLayout(3,1));
		mb2.setLayout(new GridLayout(3,1));

		//���1�������4����ǩ
		mb1.add(bq1);	mb1.add(bq2);	mb1.add(bq3);


		//���2��������ı���
		mb2.add(wbk1);	mb2.add(wbk2);	mb2.add(wbk3);

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
		if(e.getActionCommand().equals("borrow")){
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

				/**
				 * ��ѯ���ݿ�stuInfo���У���Ӧ��id��ѧ���Ļ���Ϊ����
				 */
				ps=ct.prepareStatement("select * from stuInfo");
				//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
				rs=ps.executeQuery();

				String stuId="0";
				System.out.println("��ʼ�������ݿ�");
				while(rs.next()){
					if(rs.getString(1).equals(wbk1.getText())){//֮ǰѧ���Ƿ��н�����֣��о͸�����û�о͸�0
						stuId=rs.getString(4);
						System.out.println("��ǰ�鼮����Ϊ"+rs.getString(3));
						System.out.println("���ִ��ݳɹ�");
						if(rs.getString(3).equals("�޽���")){//���ѧ��֮ǰ�鼮�����ˣ���ɾ����һ����Ϣ
							ps=ct.prepareStatement("delete stuInfo where stuId=? and bookName=?");
							ps.setString(1,rs.getString(1));
							ps.setString(2,"�޽���");
							int databaseNum=ps.executeUpdate();
							System.out.println("ȥ���޽�����Ŀ");
						}
					}
				}
				/**
				 * ����һ�����ݿ���bookInfo���Ƿ���������Ҫ�����
				 * �оͿ��Խ��Ȿ�飬û�оͱ������ݿ���û�д���
				 */

				ps=ct.prepareStatement("select * from bookInfo");
				//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
				rs=ps.executeQuery();
				boolean f1=true;
				while(rs.next()){
					System.out.println(rs.getString(2));
					System.out.println(wbk3.getText());
					if(rs.getString(2).equals(wbk3.getText())){//�ж��Ƿ����Ȿ��
						System.out.println("�ҵ��鼮");
						//дSQL���
						String s=("insert into stuInfo values(?,?,?,?)");
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
						System.out.println("�鼮����");
						ps.setString(4,stuId);
						System.out.println("����");

						//ִ��SQL��䣬���ҷ��ص�ǰ��ִ�гɹ�������
						int databaseNum=ps.executeUpdate();
						System.out.println("�����鼮��Ϣ�ɹ�2");

						//�����ĵ�ͼ��������Ϣ���ݵ�bookInfoReady
						ps=ct.prepareStatement("select * from bookInfo where bookName=?");
						ps.setString(1,wbk3.getText());
						rs=ps.executeQuery();
						rs.next();

						bookInfo.bookInfo=null;

						bookInfo bi=new bookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
						bi.bookInfo.add(bi);
						System.out.println(bi.bookInfo.get(0).bookName+bi.bookInfo.get(0).bookId+bi.bookInfo.get(0).bookPrice);

						//�������е����ݸ�bookReady�����bookReady�����汻���ߵ��������
						ps=ct.prepareStatement("insert into bookInfoReady values(?,?,?,?)");
						ps.setString(1,bi.bookInfo.get(0).bookId);
						ps.setString(2,bi.bookInfo.get(0).bookName);
						ps.setString(3,bi.bookInfo.get(0).bookPrice);
						ps.setString(4,bi.bookInfo.get(0).bookScore);
						int databaseNum3=ps.executeUpdate();

						bookInfo.bookInfo=null;
						System.out.println("��ʽ��bookInfo���ϳɹ�");

						String s1=("delete bookInfo where bookName=?");
						ps=ct.prepareStatement(s1);
						//�����1������ǵ�1���ʺţ�������ʺŶ�Ӧ������ֶ�
						ps.setString(1,wbk3.getText());
						int databaseNum1=ps.executeUpdate();
						System.out.println("ɾ���ɹ�");
						f1=false;
						//�رյ�ǰ����
						this.dispose();
					}else{
						
					}
				}
				if(f1){
					JOptionPane.showMessageDialog(this,"�Բ���,���ݿ��л�û���Ȿ��Ŷ");
					return;//���return��ʾ���ص��õĵط�
				}
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this,"�Բ���,δ֪����");
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