package Students;

import java.sql.*;

/**
 * 用JDBC连接数据库和Java做一个简单的学生管理系统,基础篇
 * @author 小钢炮-ST-PRO
 *
 */
public class Start {
	public static void main(String[] args) throws Exception{
		PreparedStatement ps=null;//可以让访问变得更安全
		Connection ct=null;//连接数据库来写查询语句
		ResultSet rs=null;//Connection ct得到的数据库的表的值集返回给ResultSet类型的rs
		try{
			/**
			 * 使用jdbc的固定格式,
			 * com.microsoft.sqlserver.jdbc.SQLServerDriver加载驱动程序
			 */
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			/***
			 * day04_2是数据库的名称，也就是数据库里我们使用的学生数据库Day04_2,也可以写别的数据库
			 * 第二个参数是用户名，第三个参数是密码
			 */
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			System.out.println("连接成功");
			//有了以上这三句话，Java就和数据库已经建立了连接，可以操作这个数据源下面的所有东西
			
			/**
			 * 创建新的数据库, 在Java中对数据库的一些基本操作
			 */
			//创建一个新的数据库
//			ps=ct.prepareStatement("create database abcd");//写SQL语句
//			ps.execute();//执行SQL语句
//			System.out.println("添加数据库abcd执行完毕");
			//在数据库下建表
//			ps=ct.prepareStatement("create table aabbcc(aa int,bb nvarchar(2))");
			//备份数据库
//			ps=ct.prepareStatement("backup database Day04_2 to disk='E:/Day04_2.bak'");
//			System.out.println("备份数据库成功");
			//还原数据库
//			ps=ct.prepareStatement("restore database Day04_2 from disk='E:/Day04_2.bak'");
			//删表
//			ps=ct.prepareStatement("drop table abc");
//			//删表，删数据库
//			ps=ct.prepareStatement("drop database abcd");
			ps.execute();
			
			/**
			 * 另一种更安全的对数据库，增，删，改，查的方法
			 */
			//添加,stuInfo表中有四个字段，所以有四个问号
			ps=ct.prepareStatement("insert into stuInfo values(?,?,?,?)");
			ps.setInt(1,6002);	ps.setString(2, "禅剑一如寄昙说");	ps.setString(3, "男");	ps.setInt(4, 20);
			int	DataBaseNum=ps.executeUpdate();//执行sql语句,返回修改成功的行数
			if(DataBaseNum==1){
				System.out.println("添加数据成功");
			}else{
				System.out.println("添加数据失败");
			}
			
			//带条件的查询
			ps=ct.prepareStatement("select * from stuInfo where stuId=? and stuName=?");
			ps.setInt(1,6002); ps.setString(2, "禅剑一如寄昙说");
			//上面两句用来写sql语句，下面一句来执行sql语句，ps调用方法将得到的SQL值集返回给ResultSet类型的rs
			rs=ps.executeQuery();
			
			//遍历学生信息表的信息
			while(rs.next()){//把数据一条一条的读出来
				//数据库里各列各字段是什么数据类型这里就用什么数据类型去接收它，
				//括号里的1表示第一列也就是第一个字段
				System.out.println("带条件查询");
				int ID=rs.getInt(1);
				String stuName=rs.getString(2);
				String stuSex=rs.getString(3);
				int age=rs.getInt(4);
				System.out.println(ID+"  "+stuName+"  "+stuSex+"  "+age);
			}
			
			/**
			 * 查询学生表中的所有信息
			 * 括号里面是Sql语句,这里执行之后就可以操作stuinfo的表了
			 * 括号里无论是多表查询，还是连接查询，等等sql查询语句都可以使用
			 * 
			 * rs2默认指向的是第一行的前一行，此行为空
			 */
			System.out.println("所有学生的信息为:");
			ps=ct.prepareStatement("select * from stuInfo");//写SQL语句
			rs=ps.executeQuery();//执行SQL语句,并且将ps得到的SQL值集返回给ResultSet类型的rs
			
			//遍历学生信息表的信息
			while(rs.next()){//把数据一条一条的读出来
				//数据库里各列各字段是什么数据类型这里就用什么数据类型去接收它，
				//括号里的1表示第一列也就是第一个字段
				int ID=rs.getInt(1);
				String stuName=rs.getString(2);
				String stuSex=rs.getString(3);
				int age=rs.getInt(4);
				System.out.println(ID+"  "+stuName+"  "+stuSex+"  "+age);
			}
			
		}catch(Exception e){
			System.out.println("程序异常");
		}
		finally{
			try{
				if(rs!=null){
					rs.close();//关闭sm占用的资源
				}
				if(ct!=null){
					ct.close();//关闭ct占用的资源
				}
			}catch(Exception e){
				
			}
		}
	}
}