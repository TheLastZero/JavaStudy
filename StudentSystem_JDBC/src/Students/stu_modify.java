package Students;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stu_modify extends JDialog implements ActionListener{
	/**
	 * JDialog�������ԴӴ���������������,
	 * �������Ĵ��ڣ�����Ҫ�ȶ��������ڲ����󣬲��ܻص�ԭ���ڲ���
	 * ActionListener�����ؼ�
	 */
	JLabel bq1,bq2,bq3,bq4;//��ǩ
	JTextField wbk1,wbk2,wbk3,wbk4;//�ı���
	JButton an1,an2;//��ť
	JPanel mb1,mb2,mb3,mb4;//�ĸ����

	public stu_modify(Frame fck,String ckm,Boolean msck,int line){//���췽��
		super(fck,ckm,msck);
		//new����ǩ
		bq1=new JLabel("          ѧ��");
		bq2=new JLabel("          ����");
		bq3=new JLabel("          �Ա�");
		bq4=new JLabel("          ����");

		//new����ǩ����ı������ó���Ϊ10
		stu_find sf=new stu_find();
		
		wbk1=new JTextField(5);//new���ı��򳤶�Ϊ10
		//��line�еļ�¼ȡ�����������ı�����
		wbk1.setText((String)sf.getValueAt(line,0).toString());
		wbk1.setEditable(false);//����һ�е��ı���ȥ����ʹ���޷��޸�
		wbk2=new JTextField(5);
		wbk2.setText((String)sf.getValueAt(line,1));
		wbk3=new JTextField(5);
		wbk3.setText((String)sf.getValueAt(line,2));
		wbk4=new JTextField(5);
		wbk4.setText((String)sf.getValueAt(line,3).toString());

		//new����ӣ�ȡ��������ť���������Ӽ���
		an1=new JButton("�޸�");
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
		//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				String s=("update stuInfo set stuName=?,stuSex=?,stuAge=? where stuId=?");
				ps=ct.prepareStatement(s);
				/**
				 * ��ȡ�ı����е��ַ����ŵ�ps��Ӧ��1234�ֶ���
				 * setString����һ��Ҫ�����ݿ�ı���ֶε�����һ��
				 * ���������
				 */
				//�����1234������ǵ�1234���ʺţ��ʺŶ�Ӧ������ֶ�
				System.out.println("��ʼ�޸�");
				ps.setString(1,wbk2.getText());
				ps.setString(2,wbk3.getText());
				ps.setString(3,wbk4.getText());
				
				//id�����޸ģ����¶�ȡһ���ı������
				ps.setString(4,wbk1.getText());
				
				//ִ��SQL��䣬���ҷ��ص�ǰ��ִ�гɹ�������
				int databaseNum=ps.executeUpdate();
				System.out.println("���ѧ����Ϣ�ɹ�");
				
				//�رյ�ǰ����
				this.dispose();
				
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
