package Students;

import java.sql.*;

/**
 * ��JDBC�������ݿ��Java��һ���򵥵�ѧ������ϵͳ,����ƪ
 * @author С����-ST-PRO
 *
 */
public class Start {
	public static void main(String[] args) throws Exception{
		PreparedStatement ps=null;//�����÷��ʱ�ø���ȫ
		Connection ct=null;//�������ݿ���д��ѯ���
		ResultSet rs=null;//Connection ct�õ������ݿ�ı��ֵ�����ظ�ResultSet���͵�rs
		try{
			/**
			 * ʹ��jdbc�Ĺ̶���ʽ,
			 * com.microsoft.sqlserver.jdbc.SQLServerDriver������������
			 */
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/***
			 * day04_2�����ݿ�����ƣ�Ҳ�������ݿ�������ʹ�õ�ѧ�����ݿ�Day04_2,Ҳ����д������ݿ�
			 * �ڶ����������û���������������������
			 */
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			System.out.println("���ӳɹ�");
			//�������������仰��Java�ͺ����ݿ��Ѿ����������ӣ����Բ����������Դ��������ж���
			
			/**
			 * �����µ����ݿ�, ��Java�ж����ݿ��һЩ��������
			 */
			//����һ���µ����ݿ�
//			ps=ct.prepareStatement("create database abcd");//дSQL���
//			ps.execute();//ִ��SQL���
//			System.out.println("������ݿ�abcdִ�����");
			//�����ݿ��½���
//			ps=ct.prepareStatement("create table aabbcc(aa int,bb nvarchar(2))");
			//�������ݿ�
//			ps=ct.prepareStatement("backup database Day04_2 to disk='E:/Day04_2.bak'");
//			System.out.println("�������ݿ�ɹ�");
			//��ԭ���ݿ�
//			ps=ct.prepareStatement("restore database Day04_2 from disk='E:/Day04_2.bak'");
			//ɾ��
//			ps=ct.prepareStatement("drop table abc");
//			//ɾ��ɾ���ݿ�
//			ps=ct.prepareStatement("drop database abcd");
			ps.execute();
			
			/**
			 * ��һ�ָ���ȫ�Ķ����ݿ⣬����ɾ���ģ���ķ���
			 */
			//���,stuInfo�������ĸ��ֶΣ��������ĸ��ʺ�
			ps=ct.prepareStatement("insert into stuInfo values(?,?,?,?)");
			ps.setInt(1,6002);	ps.setString(2, "����һ����˵");	ps.setString(3, "��");	ps.setInt(4, 20);
			int	DataBaseNum=ps.executeUpdate();//ִ��sql���,�����޸ĳɹ�������
			if(DataBaseNum==1){
				System.out.println("������ݳɹ�");
			}else{
				System.out.println("�������ʧ��");
			}
			
			//�������Ĳ�ѯ
			ps=ct.prepareStatement("select * from stuInfo where stuId=? and stuName=?");
			ps.setInt(1,6002); ps.setString(2, "����һ����˵");
			//������������дsql��䣬����һ����ִ��sql��䣬ps���÷������õ���SQLֵ�����ظ�ResultSet���͵�rs
			rs=ps.executeQuery();
			
			//����ѧ����Ϣ�����Ϣ
			while(rs.next()){//������һ��һ���Ķ�����
				//���ݿ�����и��ֶ���ʲô���������������ʲô��������ȥ��������
				//�������1��ʾ��һ��Ҳ���ǵ�һ���ֶ�
				System.out.println("��������ѯ");
				int ID=rs.getInt(1);
				String stuName=rs.getString(2);
				String stuSex=rs.getString(3);
				int age=rs.getInt(4);
				System.out.println(ID+"  "+stuName+"  "+stuSex+"  "+age);
			}
			
			/**
			 * ��ѯѧ�����е�������Ϣ
			 * ����������Sql���,����ִ��֮��Ϳ��Բ���stuinfo�ı���
			 * �����������Ƕ���ѯ���������Ӳ�ѯ���ȵ�sql��ѯ��䶼����ʹ��
			 * 
			 * rs2Ĭ��ָ����ǵ�һ�е�ǰһ�У�����Ϊ��
			 */
			System.out.println("����ѧ������ϢΪ:");
			ps=ct.prepareStatement("select * from stuInfo");//дSQL���
			rs=ps.executeQuery();//ִ��SQL���,���ҽ�ps�õ���SQLֵ�����ظ�ResultSet���͵�rs
			
			//����ѧ����Ϣ�����Ϣ
			while(rs.next()){//������һ��һ���Ķ�����
				//���ݿ�����и��ֶ���ʲô���������������ʲô��������ȥ��������
				//�������1��ʾ��һ��Ҳ���ǵ�һ���ֶ�
				int ID=rs.getInt(1);
				String stuName=rs.getString(2);
				String stuSex=rs.getString(3);
				int age=rs.getInt(4);
				System.out.println(ID+"  "+stuName+"  "+stuSex+"  "+age);
			}
			
		}catch(Exception e){
			System.out.println("�����쳣");
		}
		finally{
			try{
				if(rs!=null){
					rs.close();//�ر�smռ�õ���Դ
				}
				if(ct!=null){
					ct.close();//�ر�ctռ�õ���Դ
				}
			}catch(Exception e){
				
			}
		}
	}
}