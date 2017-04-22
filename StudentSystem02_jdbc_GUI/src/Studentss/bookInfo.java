package Studentss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * 这个类用来中转被借走的书的所有数据
 * @author 小钢炮-ST-PRO
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
	bookInfo(){//每当new一个bookInfo的时候，就遍历bookInfo中的信息，放到这个集合类里
		bookInfo=new Vector<bookInfo>();
//		/**
//		 * 配置连接数据库
//		 */
//		PreparedStatement ps=null;
//		Connection ct=null;
//		ResultSet rs=null;
//		try{//配置好数据库
//			//加载驱动
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			//选择数据库，写SQL的账号密码
//			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");
//
//			//写SQL语句
//			ps=ct.prepareStatement("select * from stuInfo");
//			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
//			rs=ps.executeQuery();
//
//			System.out.println("连接成功");
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
//		finally{//常规关闭资源
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