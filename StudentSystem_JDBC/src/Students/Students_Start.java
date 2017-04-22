package Students;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;

/**
 *  用JDBC连接数据库和Java做一个简单的学生管理系统,实战篇
 * @author 小钢炮-ST-PRO
 *
 */
public class Students_Start extends JFrame implements ActionListener{
	/**
	 * JFrame是一个可以装JPanel面板的容器，ActionListener是对按钮的监听
	 * @param args                                   
	 */
	JPanel mb1,mb2;
	JLabel bq1;//标签
	JTextField wbk1;//文本框
	JButton an1,an11,an2,an3,an4;//四个按钮
	JTable bg1;//表格
	JScrollPane gd1;//滚动条

	Vector field,notes;//字段和记录,的集合类

	/**
	 * 配置连接数据库
	 */
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;

	public static void main(String[] args) {
		Students_Start xs=new Students_Start();
	}

	Students_Start(){//构造方法
		mb1=new JPanel();//面板1
		bq1=new JLabel("请输入姓名");//标签1
		wbk1=new JTextField(15);//文本框
		an1=new JButton("查询");//查询按钮
		an1.addActionListener(this);//增加对按钮1的监听
		an1.setActionCommand("find");//设置类似于css的ID

		an11=new JButton("显示所有学生信息");
		an11.addActionListener(this);
		an11.setActionCommand("all");
		//将以上组件添加至面板1
		mb1.add(bq1);	mb1.add(wbk1);	mb1.add(an1);	mb1.add(an11);

		mb2=new JPanel();//面板2
		an2=new JButton("添加");//添加按钮
		an2.addActionListener(this);
		an2.setActionCommand("add");
		an3=new JButton("修改");//修改按钮
		an3.addActionListener(this);
		an3.setActionCommand("modify");
		an4=new JButton("删除");//删除按钮
		an4.addActionListener(this);
		an4.setActionCommand("delete");
		mb2.add(an2);	mb2.add(an3);	mb2.add(an4);

		//new出字段的对象的集合类
		field=new Vector();
		//让字段添加显示在面板上的文字
		field.add("学号");
		field.add("姓名");
		field.add("性别");
		field.add("年龄");

		//new出记录的集合类
		notes=new Vector();

		try{//配置好数据库
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//选择数据库，写SQL的账号密码
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			//写SQL语句
			ps=ct.prepareStatement("select * from stuInfo");
			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
			rs=ps.executeQuery();

			System.out.println("连接成功");

			while(rs.next()){
				//每次读取一行，中的所有字段
				//new一个行的字段来放，新增加的信息字段
				Vector line =new Vector();
				line.add(rs.getInt(1));//得到ID,1代表第一个字段
				line.add(rs.getString(2));//得到名字，名字在第2个字段
				line.add(rs.getString(3));//得到性别，
				line.add(rs.getInt(4));//得到年龄

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

		//将记录，字段添加到表格里
		bg1=new JTable(notes,field);//先写记录,后写字段
		//使表格可以滚动
		gd1=new JScrollPane(bg1);

		this.add(gd1);//将滚动条添加进
		this.add(mb1,"North");//将mb1面板添加至北部
		this.add(mb2,"South");//将mb2面板添加至南部

		this.setTitle("学生信息管理系统");
		this.setSize(700,600);
		this.setLocation(600, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * 要实现ActionListener的接口，就要实现它的抽象方法
	 * 对点击控件的监听
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("find")){//查找
			//将文本框里的字的值赋给name
			String name=this.wbk1.getText().trim();
			String sql="select * from stuInfo where stuName='"+name+"'";
			stu_find sf=new stu_find(sql);
			bg1.setModel(sf);//立即显示表格里的效果
			System.out.println("find");
		}
		if(e.getActionCommand().equals("all")){
			//将文本框里的字的值赋给name
			String name=this.wbk1.getText().trim();
			String sql="select * from stuInfo";
			stu_find sf=new stu_find(sql);
			bg1.setModel(sf);//立即显示表格里的效果
			System.out.println("all");
		}
		if(e.getActionCommand().equals("modify")){//修改
			//ii表示鼠标选中的那一行
			int ii=this.bg1.getSelectedRow();
			System.out.println(ii);
			if(ii==-1){//如果ii没有被选中，就弹出一个对话框
				JOptionPane.showMessageDialog(this,"请选中要修改的行");
				return;//这个return表示返回调用的地方
			}
			stu_modify sf6=new stu_modify(this,"修改学生信息",true,ii);
			
			stu_find sf7=new stu_find();
			bg1.setModel(sf7);
			
			System.out.println("modify");
		}
		if(e.getActionCommand().equals("add")){//添加

			//派生窗口的标题是"添加学生信息"，true表示在此窗口时无法对父类窗口操作
			stu_add a=new stu_add(this,"添加学生信息",true);
			//为了方便添加之后看到所有学生信息，这里再new一个
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
			
			System.out.println("add");
		}
		if(e.getActionCommand().equals("delete")){//删除

			//ii表示鼠标选中的那一行
			int ii=this.bg1.getSelectedRow();
			System.out.println(ii);
			if(ii==-1){//如果ii没有被选中，就弹出一个对话框
				JOptionPane.showMessageDialog(this,"请选中要删除的行");
				return;//这个return表示返回调用的地方
			}

			stu_find sf3=new stu_find();
			/**
			 * 返回一个Object的值，强转成int类型,
			 * ii代表行，0代表第一列
			 * 如果我选中的是ii行,
			 * 那么它返回的就是ii行，0列的表内的信息，在学生表中第一个是学生的ID
			 * 但是他是Object类型的，所以需要转换成int，或者String类型
			 * 主要看我们之前的表这个字段是用什么类型接收的
			 */
			int st=(int)sf3.getValueAt(ii,0);
			System.out.println(st);
			
			try{
				/**
				 * 配置连接数据库
				 */
				PreparedStatement ps=null;
				Connection ct=null;
				ResultSet rs=null;
				//配置好数据库
				//加载驱动
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//选择数据库，写SQL的账号密码
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

				//写SQL语句
				String s=("delete stuInfo where stuId=?");
				ps=ct.prepareStatement(s);
				//这里的1代表的是第1个问号，这里的问号对应上面的字段
				ps.setInt(1, st);
				
				int databaseNum=ps.executeUpdate();
				System.out.println("删除成功");

			}catch(Exception e4){

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
				}catch(Exception e2){

				}
			}	
			stu_find sf5=new stu_find();
			bg1.setModel(sf5);
			System.out.println("delete");
		}
	}
}
