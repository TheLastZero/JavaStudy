package Studentss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * �����������ת�����ߵ������������
 * @author С����-ST-PRO
 *
 */
public class bookInfo {
	public static Vector<bookInfo> bookInfo=new Vector<bookInfo>();
	String bookId;
	String bookName;
	String bookPrice;
	String bookScore="0";
	bookInfo(String bookId,String bookName,String bookPrice,String bookScore){
		bookInfo=new Vector<bookInfo>();
		this.bookId=bookId;
		this.bookName=bookName;
		this.bookPrice=bookPrice;
		this.bookScore=bookScore;
	}
	bookInfo(){//ÿ��newһ��bookInfo��ʱ�򣬾ͱ���bookInfo�е���Ϣ���ŵ������������
		bookInfo=new Vector<bookInfo>();
//		/**
//		 * �����������ݿ�
//		 */
//		PreparedStatement ps=null;
//		Connection ct=null;
//		ResultSet rs=null;
//		try{//���ú����ݿ�
//			//��������
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			//ѡ�����ݿ⣬дSQL���˺�����
//			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");
//
//			//дSQL���
//			ps=ct.prepareStatement("select * from stuInfo");
//			//ִ��SQL��䣬���ҽ��õ���ֵ�����ظ�ResultSet���͵�rs
//			rs=ps.executeQuery();
//
//			System.out.println("���ӳɹ�");
//			while(rs.next()){
//				this.bookId=rs.getString(1);
//				this.bookName=rs.getString(2);
//				this.bookPrice=rs.getString(3);
//				this.bookScore=rs.getString(4);
//				System.out.println(this.bookId);
//				this.bookInfo.add(this);
//			}
//		}catch(Exception e){
//
//		}
//		finally{//����ر���Դ
//			try{
//				if(rs!=null){
//					rs.close();
//				}
//				if(ps!=null){
//					ps.close();
//				}
//				if(ct!=null){
//					ct.close();
//				}
//			}catch(Exception e){
//				
//			}
//		}
	}
}