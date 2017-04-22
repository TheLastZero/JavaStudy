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

public class stu_return extends JDialog implements ActionListener{
	/**
	 * JDialog�������ԴӴ���������������,
	 * �������Ĵ��ڣ�����Ҫ�ȶ��������ڲ����󣬲��ܻص�ԭ���ڲ���
	 * ActionListener�����ؼ�
	 */
	JLabel bq1,bq2,bq3,bq4;//��ǩ
	JTextField wbk1,wbk2,wbk3,wbk4;//�ı���
	JButton an1,an2;//��ť
	JPanel mb1,mb2,mb3,mb4;//�ĸ����

	public stu_return(Frame fck,String ckm,Boolean msck){//���췽��
		super(fck,ckm,msck);
		//new����ǩ
		bq1=new JLabel("          ���ı��");
		bq2=new JLabel("          ����������");
		bq3=new JLabel("          �黹�鼮����");

		//new����ǩ����ı������ó���Ϊ10
		wbk1=new JTextField(5);//new���ı��򳤶�Ϊ10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);

		//new����ӣ�ȡ��������ť���������Ӽ���
		an1=new JButton("�黹�鼮");
		an1.addActionListener(this);
		an1.setActionCommand("return");;
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
		mb1.add(bq1);	mb1.add(bq2);
		mb1.add(bq3);	

		//���2��������ı���
		mb2.add(wbk1);	mb2.add(wbk2);
		mb2.add(wbk3);	

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
		if(e.getActionCommand().equals("return")){
			System.out.println("����˻��鰴ť");
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
				 * �����ݿ�bookInfoReady���е���Ϣ��ת��bookInfo����	
				 */
				ps=ct.prepareStatement("select * from bookInfoReady");
				//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
				rs=ps.executeQuery();

				System.out.println("��ʼ�������ݿ⴫�����ݸ�bookInfo����");
				boolean f2=false;
				
				while(rs.next()){
					if(rs.getString(2).equals(wbk3.getText())){
						System.out.println("�鼮�������");
						f2=true;
						bookInfo bi=new bookInfo();
						bi.bookId=rs.getString(1);
						bi.bookName=rs.getString(2);
						bi.bookPrice=rs.getString(3);
						bi.bookScore=rs.getString(4);
						System.out.println(bi.bookId);
						bi.bookInfo.add(bi);
						System.out.println(bi.bookInfo.size());
					}
				}
				/**
				 * ��˫��forѭ���˶��鼮�����֣��ͽ����ţ���������Ϣ
				 * ��һ��forѭ���˶ԣ������ţ���������Ϣ
				 * �ڶ���forѭ���˶Խ��������
				 */
				ps=ct.prepareStatement("select * from stuInfo");
				//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
				rs=ps.executeQuery();
				System.out.println("��ʼ�������ݿ�˶�ѧ��������Ϣ");
				System.out.println("ѧ���ĸ���"+rs);
				boolean f4=true;
				while(rs.next()){
					System.out.println("��ʼ�˶���Ϣ");
					if(rs.getString(1).equals(wbk1.getText())&&rs.getString(2).equals(wbk2.getText())){
						System.out.println("�˶�ID������Ϣ�ɹ�");
						for(int i=0;i<bookInfo.bookInfo.size();i++){
							System.out.println(bookInfo.bookInfo.get(i).bookId);
							System.out.println(bookInfo.bookInfo.get(i).bookName);
							System.out.println(wbk3.getText());
							//�ж��鼮�����Ƿ����
							if(f2){
								System.out.println("�˶������ɹ�");
								//дSQL���
								String s=("insert into bookInfo values(?,?,?,?)");
								ps=ct.prepareStatement(s);
								/**
								 * ��ȡ�ı����е��ַ����ŵ�ps��Ӧ��1234�ֶ���
								 * setString����һ��Ҫ�����ݿ�ı���ֶε�����һ��
								 * ���������
								 */
								System.out.println("��ʼ����");
								//�����1234������ǵ�1234���ʺţ�������ʺŴ���������ݿ�����ֶε�˳��
								ps.setString(1,bookInfo.bookInfo.get(0).bookId);
								System.out.println("���ԭ��id�ɹ�");
								ps.setString(2,bookInfo.bookInfo.get(0).bookName);
								System.out.println("���ԭ�����ֳɹ�");
								ps.setString(3,bookInfo.bookInfo.get(0).bookPrice);
								System.out.println("���ԭ��۸�ɹ�");
								ps.setString(4,bookInfo.bookInfo.get(0).bookScore);
								System.out.println("���ԭ�鼮���ֳɹ�");

								//ִ��SQL��䣬���ҷ��ص�ǰ��ִ�гɹ�������
								int databaseNum6=ps.executeUpdate();
								System.out.println("����鼮��Ϣ�ɹ�");
								System.out.println("��ʼ���ĵ�ǰ��");
								//�黹�ɹ��������޸ĵ�ǰ�У���������Ϣ�޸�Ϊ�޽��飬����Ӧ������Ӧ������
								ps=ct.prepareStatement("update stuInfo set bookName=?,stuScore=? where stuId=? and bookName=?");
								ps.setString(1,"�޽���");
								//���鼮�Ļ��ָ�s1��Ȼ���������˵Ļ�������
								String s1=bookInfo.bookInfo.get(i).bookScore;
								int a1=Integer.parseInt(s1);//�����ݿ��е�String���͵�����ת����int����
								System.out.println("����Ļ���Ϊ"+a1);
								int a2=Integer.parseInt(rs.getString(4));
								System.out.println("��ѧ��ԭ���Ļ���Ϊ"+a2);
								int sum=a1+a2;
								System.out.println(sum);
								/**
								 * ��������ӵĽ���ٴ�ת����String����
								 */
								String sum2=String.valueOf(sum);
								System.out.println(sum2);
								ps.setString(2,sum2);//���ӻ���
								ps.setString(3,wbk1.getText());
								ps.setString(4, wbk3.getText());
								int databaseNum2=ps.executeUpdate();
								System.out.println("���ĵ�ǰ�гɹ�");
								
								ps=ct.prepareStatement("update stuInfo set stuScore=? where stuId=?");
								ps.setString(1,sum2);
								ps.setString(2,wbk1.getText());
								int databaseNum23=ps.executeUpdate();
								System.out.println("����ͬ���ɹ�");
								
								//ɾ��bookInfoReady��������ת����Ϣ
								String s2=("delete bookInfoReady where bookId=?");
								ps=ct.prepareStatement(s2);
								//�����1������ǵ�1���ʺţ�������ʺŶ�Ӧ������ֶ�
								ps.setString(1,bookInfo.bookInfo.get(i).bookId);
								int databaseNum1=ps.executeUpdate();
								System.out.println("ɾ���ɹ�");
								bookInfo.bookInfo=null;
								//�رյ�ǰ����
								this.dispose();
							}else{
								JOptionPane.showMessageDialog(this,"�鼮������д����");
								return;//���return��ʾ���ص��õĵط�
							}
						}
						f4=false;
					}else{
						
					}
				}
				if(f4){
					JOptionPane.showMessageDialog(this,"����ID���߽�����������д����");
					return;//���return��ʾ���ص��õĵط�
				}
			}catch(Exception e2){
				
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