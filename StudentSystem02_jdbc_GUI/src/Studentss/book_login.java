package Studentss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class book_login extends JDialog implements ActionListener{
	
	JLabel jl1,jl2;//用户名，密码两个标签
	JButton jb1,jb2,jb3;//登录，取消，注册三个按钮
	JTextField wbk1;//用户名，密码，两个文本框
	JPasswordField wbk2;

	book_login(){
		jl1=new JLabel("用户名:",JLabel.LEFT);
		jl1.setBounds(140,180,100,100);
		this.add(jl1);
		wbk1=new JTextField();
		wbk1.setBounds(190,215,150,30);
		this.add(wbk1);

		jl2=new JLabel("密    码:",JLabel.LEFT);
		jl2.setBounds(140,220,100,100);
		this.add(jl2);
		wbk2=new JPasswordField(15);
		wbk2.setBounds(190,255,150,30);
		this.add(wbk2);

		//new出登录按钮，并且监听事件
		jb1=new JButton("登录");
		jb1.setBounds(130,300,60,30);
		jb1.addActionListener(this);
		jb1.setActionCommand("login");;
		this.add(jb1);

		//new出取消按钮，并且监听事件
		jb2=new JButton("取消");
		jb2.setBounds(210,300,60,30);
		jb2.addActionListener(this);
		jb2.setActionCommand("cancel");;
		this.add(jb2);

		//new出注册按钮，并且监听事件
		jb3=new JButton("注册");
		jb3.setBounds(290,300,60,30);
		jb3.addActionListener(this);
		jb3.setActionCommand("sign");;
		this.add(jb3);

		this.add(jb2);
		this.add(jb3);

		BackImage b=new BackImage();
		b.setBounds(0,0,500,250);
		this.add(b);
		
		this.setLayout(null);//空布局		
		this.setTitle("书籍系统登录");
		this.setSize(500,350);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);//为true时，不显示边框
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")){
			System.out.println("登录按钮");
			checkLogin();
		}
		if(e.getActionCommand().equals("cancel")){
			System.out.println("取消");
			System.exit(-1);
		}
		if(e.getActionCommand().equals("sign")){
			System.out.println("注册");
			sign();
		}
	}

	void checkLogin(){//检查用户名密码是否匹配
		/**
		 * 配置连接数据库
		 */
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;

		try{//配置好数据库
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//选择数据库，写SQL的账号密码
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			//写SQL语句
			ps=ct.prepareStatement("select  * from stuAdmin");
			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
			rs=ps.executeQuery();
			
			System.out.println("连接成功");

			String nowName=wbk1.getText();//文本框中的用户名
			String nowPassword=wbk2.getText();//文本框中的用户名
			System.out.println("读取文本框里的用户名密码"+nowName+"  " +nowPassword);

			boolean f1=true;//用来判断用户名密码是否相等
			
			while(rs.next()){
				System.out.println("开始核对用户名密码");
				//每次读取一行，中的所有字段
				String stuName=rs.getString(1);//得到数据库中的用户名
				String stuPassword=rs.getString(2);//得到数据库中的密码
				System.out.println(stuName+"  "+stuPassword);
				if(stuName.equals(nowName) && stuPassword.equals(nowPassword)){
					Students_Start xs=new Students_Start();
					this.setVisible(false);
					f1=false;//如果有成功登陆，就把f1改为false，就不会输出用户名错误这句话
					break;
				}else{
					
				}
			}
			if(f1){
				JOptionPane.showMessageDialog(this,"用户名或者密码错误");
				return;//这个return表示返回调用的地方
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
	void sign(){//注册方法
		/**
		 * 配置连接数据库
		 */
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;

		try{//配置好数据库
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//选择数据库，写SQL的账号密码
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

			//写SQL语句
			ps=ct.prepareStatement("select  * from stuAdmin");
			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
			rs=ps.executeQuery();

			System.out.println("连接成功");

			String nowName=wbk1.getText();//文本框中的用户名
			String nowPassword=wbk2.getText();//文本框中的用户名
			System.out.println("读取文本框里的用户名密码"+nowName+"  " +nowPassword);

			boolean f2=true;
			
			while(rs.next()){
				System.out.println("开始核对用户名，防止添加到重复的用户名");
				//每次读取一行，中的所有字段
				String stuName=rs.getString(1);//得到数据库中的用户名
				String stuPassword=rs.getString(2);//得到数据库中的密码
				System.out.println(stuName+"  "+stuPassword);
				if(stuName.equals(nowName)){
					JOptionPane.showMessageDialog(this,"此用户名已经被使用");
					f2=false;//如果有相同用户名就停止创建
					return;//这个return表示返回调用的地方
				}else{	
				}
			}
			if(f2){
				System.out.println("开始创建用户");
				String s=("insert into stuAdmin values(?,?)");
				ps=ct.prepareStatement(s);
				ps.setString(1,nowName);
				ps.setString(2,nowPassword);
				ps.execute();
				JOptionPane.showMessageDialog(this,"创建用户名成功");
				return;//这个return表示返回调用的地方
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

class BackImage extends JPanel{
	Image im;
	public BackImage(){
		try{
			im=ImageIO.read(new File("image/2.jpg"));
		}catch(Exception e){

		}	
	}
		public void paint(Graphics g){
			g.drawImage(im,0,0,500,200,this);
	}
}






