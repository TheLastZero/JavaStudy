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

public class stu_return extends JDialog implements ActionListener{
	/**
	 * JDialog这个类可以从窗口里派生出窗口,
	 * 派生出的窗口，必须要先对派生窗口操作后，才能回到原窗口操作
	 * ActionListener监听控件
	 */
	JLabel bq1,bq2,bq3,bq4;//标签
	JTextField wbk1,wbk2,wbk3,wbk4;//文本框
	JButton an1,an2;//按钮
	JPanel mb1,mb2,mb3,mb4;//四个面板

	public stu_return(Frame fck,String ckm,Boolean msck){//构造方法
		super(fck,ckm,msck);
		//new出标签
		bq1=new JLabel("          借阅编号");
		bq2=new JLabel("          借书人名字");
		bq3=new JLabel("          归还书籍名字");

		//new出标签后的文本框，设置长度为10
		wbk1=new JTextField(5);//new出文本框长度为10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);

		//new出添加，取消两个按钮，并且增加监听
		an1=new JButton("归还书籍");
		an1.addActionListener(this);
		an1.setActionCommand("return");;
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
		mb1.add(bq1);	mb1.add(bq2);
		mb1.add(bq3);	

		//面板2里面添加文本框
		mb2.add(wbk1);	mb2.add(wbk2);
		mb2.add(wbk3);	

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
		if(e.getActionCommand().equals("return")){
			System.out.println("点击了还书按钮");
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
				 * 将数据库bookInfoReady表中的信息，转给bookInfo集合	
				 */
				ps=ct.prepareStatement("select * from bookInfoReady");
				//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
				rs=ps.executeQuery();

				System.out.println("开始遍历数据库传递数据给bookInfo集合");
				boolean f2=false;
				
				while(rs.next()){
					if(rs.getString(2).equals(wbk3.getText())){
						System.out.println("书籍名字相等");
						f2=true;
						bookInfo bi=new bookInfo();
						bi.bookId=rs.getString(1);
						bi.bookName=rs.getString(2);
						bi.bookPrice=rs.getString(3);
						bi.bookScore=rs.getString(4);
						System.out.println(bi.bookId);
						bi.bookInfo.add(bi);
						System.out.println(bi.bookInfo.size());
					}
				}
				/**
				 * 用双重for循环核对书籍的名字，和借书编号，借书人信息
				 * 第一层for循环核对，借书编号，借书人信息
				 * 第二层for循环核对借书的名字
				 */
				ps=ct.prepareStatement("select * from stuInfo");
				//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
				rs=ps.executeQuery();
				System.out.println("开始遍历数据库核对学生借书信息");
				System.out.println("学生的个数"+rs);
				boolean f4=true;
				while(rs.next()){
					System.out.println("开始核对信息");
					if(rs.getString(1).equals(wbk1.getText())&&rs.getString(2).equals(wbk2.getText())){
						System.out.println("核对ID名字信息成功");
						for(int i=0;i<bookInfo.bookInfo.size();i++){
							System.out.println(bookInfo.bookInfo.get(i).bookId);
							System.out.println(bookInfo.bookInfo.get(i).bookName);
							System.out.println(wbk3.getText());
							//判断书籍名字是否相等
							if(f2){
								System.out.println("核对书名成功");
								//写SQL语句
								String s=("insert into bookInfo values(?,?,?,?)");
								ps=ct.prepareStatement(s);
								/**
								 * 获取文本框中的字符，放到ps对应的1234字段里
								 * setString类型一定要和数据库的表的字段的类型一样
								 * 否则不能添加
								 */
								System.out.println("开始还书");
								//这里的1234代表的是第1234个问号，这里的问号代表的是数据库表中字段的顺序
								ps.setString(1,bookInfo.bookInfo.get(0).bookId);
								System.out.println("添加原书id成功");
								ps.setString(2,bookInfo.bookInfo.get(0).bookName);
								System.out.println("添加原书名字成功");
								ps.setString(3,bookInfo.bookInfo.get(0).bookPrice);
								System.out.println("添加原书价格成功");
								ps.setString(4,bookInfo.bookInfo.get(0).bookScore);
								System.out.println("添加原书籍积分成功");

								//执行SQL语句，并且返回当前的执行成功的行数
								int databaseNum6=ps.executeUpdate();
								System.out.println("添加书籍信息成功");
								System.out.println("开始更改当前行");
								//归还成功后立刻修改当前行，将借书信息修改为无借书，积分应该有相应的增加
								ps=ct.prepareStatement("update stuInfo set bookName=?,stuScore=? where stuId=? and bookName=?");
								ps.setString(1,"无借书");
								//此书籍的积分给s1，然后加在这个人的积分栏里
								String s1=bookInfo.bookInfo.get(i).bookScore;
								int a1=Integer.parseInt(s1);//将数据库中的String类型的数据转化成int类型
								System.out.println("此书的积分为"+a1);
								int a2=Integer.parseInt(rs.getString(4));
								System.out.println("此学生原本的积分为"+a2);
								int sum=a1+a2;
								System.out.println(sum);
								/**
								 * 将积分相加的结果再次转化回String类型
								 */
								String sum2=String.valueOf(sum);
								System.out.println(sum2);
								ps.setString(2,sum2);//增加积分
								ps.setString(3,wbk1.getText());
								ps.setString(4, wbk3.getText());
								int databaseNum2=ps.executeUpdate();
								System.out.println("更改当前行成功");
								
								ps=ct.prepareStatement("update stuInfo set stuScore=? where stuId=?");
								ps.setString(1,sum2);
								ps.setString(2,wbk1.getText());
								int databaseNum23=ps.executeUpdate();
								System.out.println("积分同步成功");
								
								//删除bookInfoReady表里中中转的信息
								String s2=("delete bookInfoReady where bookId=?");
								ps=ct.prepareStatement(s2);
								//这里的1代表的是第1个问号，这里的问号对应上面的字段
								ps.setString(1,bookInfo.bookInfo.get(i).bookId);
								int databaseNum1=ps.executeUpdate();
								System.out.println("删除成功");
								bookInfo.bookInfo=null;
								//关闭当前窗口
								this.dispose();
							}else{
								JOptionPane.showMessageDialog(this,"书籍名字填写错误");
								return;//这个return表示返回调用的地方
							}
						}
						f4=false;
					}else{
						
					}
				}
				if(f4){
					JOptionPane.showMessageDialog(this,"借阅ID或者借书人名字填写错误");
					return;//这个return表示返回调用的地方
				}
			}catch(Exception e2){
				
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