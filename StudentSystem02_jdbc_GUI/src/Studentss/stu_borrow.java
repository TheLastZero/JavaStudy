package Studentss;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stu_borrow extends JDialog implements ActionListener{
	/**
	 * JDialog这个类可以从窗口里派生出窗口,
	 * 派生出的窗口，必须要先对派生窗口操作后，才能回到原窗口操作
	 * ActionListener监听控件
	 */
	JLabel bq1,bq2,bq3;//标签
	JTextField wbk1,wbk2,wbk3;//文本框
	JButton an1,an2;//按钮
	JPanel mb1,mb2,mb3,mb4;//四个面板

	public stu_borrow(Frame fck,String ckm,Boolean msck){//构造方法
		super(fck,ckm,msck);
		//new出标签
		bq1=new JLabel("          借书人编号");
		bq2=new JLabel("          借书人名字");
		bq3=new JLabel("          书名");

		//new出标签后的文本框，设置长度为10
		wbk1=new JTextField(5);//new出文本框长度为10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);

		//new出添加，取消两个按钮，并且增加监听
		an1=new JButton("借阅");
		an1.addActionListener(this);
		an1.setActionCommand("borrow");;
		an2=new JButton("取消");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//取消

		//new出四个面板
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		mb4=new JPanel();

		//用网格布局管理器，四行一列
		mb1.setLayout(new GridLayout(3,1));
		mb2.setLayout(new GridLayout(3,1));

		//面板1里面添加4个标签
		mb1.add(bq1);	mb1.add(bq2);	mb1.add(bq3);


		//面板2里面添加文本框
		mb2.add(wbk1);	mb2.add(wbk2);	mb2.add(wbk3);

		//给面板3添加，提交或取消两个按钮
		mb3.add(an1);	mb3.add(an2);


		this.add(mb1,BorderLayout.WEST);
		this.add(mb2);//默认为边界布局管理器的中部
		this.add(mb3,BorderLayout.SOUTH);
		this.add(mb4,BorderLayout.EAST);

		this.setSize(400,200);
		this.setLocation(750, 400);
		this.setResizable(false);//不允许调节窗口大小
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		//继承JDialog类所必须实现的方法,对按钮控件的监听，以及实现
		if(e.getActionCommand().equals("borrow")){
			Vector field,notes;//字段和记录,的集合类
			/**
			 * 配置连接数据库
			 */
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;

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

				/**
				 * 查询数据库stuInfo表中，对应的id的学生的积分为多少
				 */
				ps=ct.prepareStatement("select * from stuInfo");
				//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
				rs=ps.executeQuery();

				String stuId="0";
				System.out.println("开始遍历数据库");
				while(rs.next()){
					if(rs.getString(1).equals(wbk1.getText())){//之前学生是否有借书积分，有就给他，没有就给0
						stuId=rs.getString(4);
						System.out.println("当前书籍名字为"+rs.getString(3));
						System.out.println("积分传递成功");
						if(rs.getString(3).equals("无借书")){//如果学生之前书籍都还了，就删除那一条信息
							ps=ct.prepareStatement("delete stuInfo where stuId=? and bookName=?");
							ps.setString(1,rs.getString(1));
							ps.setString(2,"无借书");
							int databaseNum=ps.executeUpdate();
							System.out.println("去除无借书条目");
						}
					}
				}
				/**
				 * 遍历一下数据库里bookInfo里是否有我们所要借的书
				 * 有就可以借这本书，没有就报错，数据库中没有此书
				 */

				ps=ct.prepareStatement("select * from bookInfo");
				//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
				rs=ps.executeQuery();
				boolean f1=true;
				while(rs.next()){
					System.out.println(rs.getString(2));
					System.out.println(wbk3.getText());
					if(rs.getString(2).equals(wbk3.getText())){//判断是否有这本书
						System.out.println("找到书籍");
						//写SQL语句
						String s=("insert into stuInfo values(?,?,?,?)");
						ps=ct.prepareStatement(s);
						/**
						 * 获取文本框中的字符，放到ps对应的1234字段里
						 * setString类型一定要和数据库的表的字段的类型一样
						 * 否则不能添加
						 */
						System.out.println("开始添加");
						//这里的1234代表的是第1234个问号，这里的问号代表的是数据库表中字段的顺序
						ps.setString(1,wbk1.getText());
						System.out.println("添加id成功");
						ps.setString(2,wbk2.getText());
						System.out.println("添加名字成功");
						ps.setString(3,wbk3.getText());
						System.out.println("书籍名字");
						ps.setString(4,stuId);
						System.out.println("积分");

						//执行SQL语句，并且返回当前的执行成功的行数
						int databaseNum=ps.executeUpdate();
						System.out.println("借阅书籍信息成功2");

						//将借阅的图书所有信息备份到bookInfoReady
						ps=ct.prepareStatement("select * from bookInfo where bookName=?");
						ps.setString(1,wbk3.getText());
						rs=ps.executeQuery();
						rs.next();

						bookInfo.bookInfo=null;

						bookInfo bi=new bookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
						bi.bookInfo.add(bi);
						System.out.println(bi.bookInfo.get(0).bookName+bi.bookInfo.get(0).bookId+bi.bookInfo.get(0).bookPrice);

						//将集合中的数据给bookReady，这个bookReady用来存被借走的书的数据
						ps=ct.prepareStatement("insert into bookInfoReady values(?,?,?,?)");
						ps.setString(1,bi.bookInfo.get(0).bookId);
						ps.setString(2,bi.bookInfo.get(0).bookName);
						ps.setString(3,bi.bookInfo.get(0).bookPrice);
						ps.setString(4,bi.bookInfo.get(0).bookScore);
						int databaseNum3=ps.executeUpdate();

						bookInfo.bookInfo=null;
						System.out.println("格式化bookInfo集合成功");

						String s1=("delete bookInfo where bookName=?");
						ps=ct.prepareStatement(s1);
						//这里的1代表的是第1个问号，这里的问号对应上面的字段
						ps.setString(1,wbk3.getText());
						int databaseNum1=ps.executeUpdate();
						System.out.println("删除成功");
						f1=false;
						//关闭当前窗口
						this.dispose();
					}else{
						
					}
				}
				if(f1){
					JOptionPane.showMessageDialog(this,"对不起,数据库中还没有这本书哦");
					return;//这个return表示返回调用的地方
				}
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this,"对不起,未知错误");
				return;//这个return表示返回调用的地方
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
		}
		if(e.getActionCommand().equals("cancel")){
			this.dispose();//关闭当前窗口
		}
	}
}