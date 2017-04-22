package Studentss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class stu_find extends AbstractTableModel{

	Vector field,notes;//�ֶκͼ�¼,�ļ�����
	/**
	 * �����������ݿ�
	 */
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;

	public stu_find(){
		this.sqlyj("select * from stuInfo");
	}

	public stu_find(String sql) {
		this.sqlyj(sql);
	}

	public String getColumnName(int e){//�����ж������Լ����������
		return (String)this.field.get(e);
	}
	
	public int getColumnCount() {//�����еĸ���

		return this.field.size();//�����ֶΣ�Ҳ����ÿ�еı��⣩�ĸ���
	}

	public int getRowCount() {//�����еĸ���
		
		return this.notes.size();//���ؼ�¼��Ҳ�����ж�����ѧ����Ϣ���ĸ���
	}

	public Object getValueAt(int row, int col) {//�����У�����Ӧ�þ��е�ֵ
		return ((Vector)this.notes.get(row)).get(col);
	}

	public void sqlyj(String sql){
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
			ps=ct.prepareStatement(sql);
			//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
			rs=ps.executeQuery();

			System.out.println("���ӳɹ�");

			while(rs.next()){
				//ÿ�ζ�ȡһ�У��е������ֶ�
				//newһ���е��ֶ����ţ������ӵ���Ϣ�ֶ�
				Vector line =new Vector();
				line.add(rs.getInt(1));
				line.add(rs.getString(2));
				line.add(rs.getString(3));
				line.add(rs.getInt(4));

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
	}
}
