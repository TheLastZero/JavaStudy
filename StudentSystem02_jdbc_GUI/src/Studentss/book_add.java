package Studentss;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;
/**
 * 添加学生信息
 * @author 小钢炮-ST-PRO
 *
 */
public class book_add extends JDialog implements ActionListener{
	/**
	 * JDialog这个类可以从窗口里派生出窗口,
	 * 派生出的窗口，必须要先对派生窗口操作后，才能回到原窗口操作
	 * ActionListener监听控件
	 */
	JLabel bq1,bq2,bq3,bq4;//标签
	JTextField wbk1,wbk2,wbk3,wbk4;//文本框
	JButton an1,an2;//按钮
	JPanel mb1,mb2,mb3,mb4;//四个面板

	public book_add(Frame fck,String ckm,Boolean msck){//构造方法
		super(fck,ckm,msck);
		//new出标签
		bq1=new JLabel("          编号");
		bq2=new JLabel("          书名");
		bq3=new JLabel("          价格");
		bq4=new JLabel("          积分");

		//new出标签后的文本框，设置长度为10
		wbk1=new JTextField(5);//new出文本框长度为10
		wbk2=new JTextField(5);
		wbk3=new JTextField(5);
		wbk4=new JTextField(5);

		//new出添加，取消两个按钮，并且增加监听
		an1=new JButton("添加");
		an1.addActionListener(this);
		an1.setActionCommand("add2");;
		an2=new JButton("取消");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//取消

		//new出四个面板
		mb1=new JPanel();
		mb2=new JPanel();
		mb3=new JPanel();
		mb4=new JPanel();

		//用网格布局管理器，四行一列
		mb1.setLayout(new GridLayout(4,1));
		mb2.setLayout(new GridLayout(4,1));

		//面板1里面添加4个标签
		mb1.add(bq1);	mb1.add(bq2);
		mb1.add(bq3);	mb1.add(bq4);

		//面板2里面添加文本框
		mb2.add(wbk1);	mb2.add(wbk2);
		mb2.add(wbk3);	mb2.add(wbk4);

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
		if(e.getActionCommand().equals("add2")){
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
			field.add("编号");
			field.add("书名");
			field.add("价格");
			field.add("积分");

			//new出记录的集合类
			notes=new Vector();

			try{//配置好数据库
				//加载驱动
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//选择数据库，写SQL的账号密码
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=day04_2","sa","123");

				//写SQL语句
				String s=("insert into bookInfo values(?,?,?,?)");
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
				System.out.println("添加价格成功");
				ps.setString(4,wbk4.getText());
				System.out.println("添加积分成功");
				
				//执行SQL语句，并且返回当前的执行成功的行数
				int databaseNum=ps.executeUpdate();
				System.out.println("添加书籍信息成功");
				
				//关闭当前窗口
				this.dispose();
				
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this,"请不要输入相同的书籍编号");
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