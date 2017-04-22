package Studentss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class stu_find extends AbstractTableModel{

	Vector field,notes;//字段和记录,的集合类
	/**
	 * 配置连接数据库
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

	public String getColumnName(int e){//返回有多少列以及标题的名字
		return (String)this.field.get(e);
	}
	
	public int getColumnCount() {//返回列的个数

		return this.field.size();//返回字段（也就是每列的标题）的个数
	}

	public int getRowCount() {//返回行的个数
		
		return this.notes.size();//返回记录（也就是有多少行学生信息）的个数
	}

	public Object getValueAt(int row, int col) {//返回行，列中应该具有的值
		return ((Vector)this.notes.get(row)).get(col);
	}

	public void sqlyj(String sql){
		//new出字段的对象的集合类
		field=new Vector();
		//让字段添加显示在面板上的文字
		field.add("借书人编号");
		field.add("借书人名字");
		field.add("已借书籍名字");
		field.add("当前积分");

		//new出记录的集合类
		notes=new Vector();

		try{//配置好数据库
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//选择数据库，写SQL的账号密码
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			//写SQL语句
			ps=ct.prepareStatement(sql);
			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
			rs=ps.executeQuery();

			System.out.println("连接成功");

			while(rs.next()){
				//每次读取一行，中的所有字段
				//new一个行的字段来放，新增加的信息字段
				Vector line =new Vector();
				line.add(rs.getInt(1));
				line.add(rs.getString(2));
				line.add(rs.getString(3));
				line.add(rs.getInt(4));

				//将一行中所有的信息读取，然后放到记录里
				notes.add(line);
			}
		}catch(Exception e){

		}
		finally{//常规关闭资源
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
