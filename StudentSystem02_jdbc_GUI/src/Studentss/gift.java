package Studentss;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gift extends JDialog implements ActionListener{
	/**
	 * JDialog这个类可以从窗口里派生出窗口,
	 * 派生出的窗口，必须要先对派生窗口操作后，才能回到原窗口操作
	 * ActionListener监听控件
	 */
	JLabel bq1,bq2,bq3;//标签
	JLabel bq4,bq5,bq6;//礼品1，2，3，信息
	JLabel bq7,bq8,bq9;//礼品1，2，3，编号
	JTextField wbk1,wbk2,wbk3;//文本框
	JButton an1,an2;//按钮

	public gift(Frame fck,String ckm,Boolean msck){//构造方法
		super(fck,ckm,msck);

		//new出礼品标签
		bq4=new JLabel("暖暖床单一套（1000积分）");
		bq4.setBounds(30,100,180,100);
		bq4.setForeground(Color.red);
		this.add(bq4);

		bq5=new JLabel("立白洗衣粉（500积分）");
		bq5.setBounds(210,100,180,100);
		bq5.setForeground(Color.red);
		this.add(bq5);

		bq6=new JLabel("海外十国游（50000积分）");
		bq6.setBounds(370,100,180,100);
		bq6.setForeground(Color.red);
		this.add(bq6);

		//new出礼品编号
		bq7=new JLabel("(1)");
		bq7.setBounds(90,120,180,100);
		bq7.setForeground(Color.red);
		this.add(bq7);
		bq8=new JLabel("(2)");
		bq8.setBounds(270,120,180,100);
		bq8.setForeground(Color.red);
		this.add(bq8);
		bq9=new JLabel("(3)");
		bq9.setBounds(430,120,180,100);
		bq9.setForeground(Color.red);
		this.add(bq9);

		//new出标签
		bq1=new JLabel("          兑换人编号:");
		bq1.setBounds(90,160,100,100);
		this.add(bq1);
		bq2=new JLabel("          兑换人名字:");
		bq2.setBounds(90,195,100,100);
		this.add(bq2);
		bq3=new JLabel("          兑换奖品编号:");
		bq3.setBounds(90,230,120,100);
		this.add(bq3);

		//new出标签后的文本框，设置长度为10
		wbk1=new JTextField(5);//new出文本框长度为10
		wbk1.setBounds(220,195,150,30);
		this.add(wbk1);
		wbk2=new JTextField(5);
		wbk2.setBounds(220,230,150,30);
		this.add(wbk2);
		wbk3=new JTextField(5);
		wbk3.setBounds(220,265,150,30);
		this.add(wbk3);

		//new出添加，取消两个按钮，并且增加监听
		an1=new JButton("兑换");
		an1.addActionListener(this);
		an1.setActionCommand("gift");
		an1.setBounds(220,320,60,30);
		this.add(an1);
		an2=new JButton("取消");
		an2.addActionListener(this);
		an2.setActionCommand("cancel");//取消
		an2.setBounds(290,320,60,30);
		this.add(an2);

		/**
		 * 添加奖品的三张图片
		 */
		BackImage2 b1=new BackImage2("image/3.jpg");
		b1.setBounds(30,30,150,100);
		this.add(b1);
		BackImage2 b2=new BackImage2("image/4.jpg");
		b2.setBounds(200,30,150,100);
		this.add(b2);
		BackImage2 b3=new BackImage2("image/2.jpg");
		b3.setBounds(370,30,150,100);
		this.add(b3);

		this.setLayout(null);//空布局	
		this.setSize(550,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//不允许调节窗口大小
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("gift")){
			System.out.println("点击了兑换按钮");
			exchange();
		}
		if(e.getActionCommand().equals("cancel")){
			this.dispose();//关闭当前窗口
		}
	}

	public void exchange(){//兑换
		System.out.println("开始兑换操作");
		int i=0;
		if(wbk3.getText().equals("1")){
			i=1000;
		}else if(wbk3.getText().equals("2")){
			i=500;
		}else if(wbk3.getText().equals("3")){
			i=50000;
		}else{
			JOptionPane.showMessageDialog(this,"请输入正确的礼品兑换编号");
			return;//这个return表示返回调用的地方
		}

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
			ps=ct.prepareStatement("select * from stuInfo");
			//执行SQL语句，并且将得到的值集返回给ResultSet类型的rs
			rs=ps.executeQuery();
			System.out.println("连接成功");
			boolean f5=true;
			while(rs.next()){
				//判断是否有这个学生，核对ID和名字
				if(rs.getString(1).equals(wbk1.getText())&&rs.getString(2).equals(wbk2.getText())){
					System.out.println("学生存在，继续下一步");
					
					String s1=rs.getString(4);//获取积分
					int it=Integer.parseInt(s1);
					if(it>i){
						System.out.println("学生积分大于兑换积分，满足兑换条件");
						int it2=it-i;
						String s2=String.valueOf(it2);
						System.out.println(s2);
						//更新积分信息
						ps=ct.prepareStatement("update stuInfo set stuScore=? where stuId=?");
						ps.setString(1,s2);
						ps.setString(2,wbk1.getText());
						int databaseNum6=ps.executeUpdate();
						System.out.println("积分更新成功");
						
						JOptionPane.showMessageDialog(this,"兑换礼品成功");
						f5=false;
						return;//这个return表示返回调用的地方
					}else{
						JOptionPane.showMessageDialog(this,"学生积分不足，无法兑换");
						return;//这个return表示返回调用的地方
					}
				}else{
					
				}			
			}
			if(f5){
				JOptionPane.showMessageDialog(this,"学生信息有误，请重新填写");
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

class BackImage2 extends JPanel{
	Image im;
	BackImage2(String s){
		try{
			im=ImageIO.read(new File(s));
		}catch(Exception e){

		}	
	}
	public void paint(Graphics g){
		g.drawImage(im,0,0,150,100,this);
	}
}
