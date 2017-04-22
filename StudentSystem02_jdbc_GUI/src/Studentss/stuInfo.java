package Studentss;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class stuInfo extends JFrame implements ActionListener{
	/**
	 * JFrame是一个可以装JPanel面板的容器，ActionListener是对按钮的监听
	 * @param args                                   
	 */
	JPanel mb1,mb2;
	JLabel bq1;//标签
	JTextField wbk1;//文本框
	JButton an1,an11,an2,an3,an4,an5;//四个按钮
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
		stuInfo xs=new stuInfo();
	}

	stuInfo(){//构造方法
		mb1=new JPanel();//面板1
		bq1=new JLabel("请输入学生名字");//标签1
		wbk1=new JTextField(15);//文本框
		an1=new JButton("查询");//查询按钮
		an1.addActionListener(this);//增加对按钮1的监听
		an1.setActionCommand("find");//设置类似于css的ID

		an11=new JButton("显示所有借书信息");
		an11.addActionListener(this);
		an11.setActionCommand("all");
		//将以上组件添加至面板1
		mb1.add(bq1);	mb1.add(wbk1);	mb1.add(an1);	mb1.add(an11);

		mb2=new JPanel();//面板2
		an2=new JButton("借书");//添加按钮
		an2.addActionListener(this);
		an2.setActionCommand("borrow");
		an3=new JButton("还书");//修改按钮
		an3.addActionListener(this);
		an3.setActionCommand("return");
		an4=new JButton("积分换礼品");//删除按钮
		an4.addActionListener(this);
		an4.setActionCommand("gift");
		an5=new JButton("切换到书籍信息");//删除按钮
		an5.addActionListener(this);
		an5.setActionCommand("bookInfo");
		mb2.add(an2);	mb2.add(an3);	
		mb2.add(an4);	mb2.add(an5);

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

		this.setTitle("书籍信息管理系统");
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
		if(e.getActionCommand().equals("find")){//查找借书人信息
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
		if(e.getActionCommand().equals("return")){//还书
			stu_return sf6=new stu_return(this,"归还书籍信息",true);
			
			book_find sf7=new book_find();
			bg1.setModel(sf7);
			System.out.println("return");
		}
		if(e.getActionCommand().equals("borrow")){//借书
			//派生窗口的标题是"添加学生信息"，true表示在此窗口时无法对父类窗口操作
			stu_borrow a=new stu_borrow(this,"添加借书信息",true);
			//为了方便添加之后看到所有学生信息，这里再new一个
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
			System.out.println("borrow");
		}
		if(e.getActionCommand().equals("gift")){//积分换礼品
			System.out.println("点击了积分换礼品按钮");
			gift g=new gift(this,"兑换界面",true);
			stu_find sf2=new stu_find(); 
			bg1.setModel(sf2);	
		}
		if(e.getActionCommand().equals("bookInfo")){//查看学生信息
			System.out.println("查看学生信息");
			//关闭当前窗口
			this.dispose();
			Students_Start xs=new Students_Start();
		}
	}
}
