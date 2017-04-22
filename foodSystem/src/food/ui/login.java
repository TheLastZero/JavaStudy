package food.ui;

import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 登录界面
 * @author 小钢炮-ST-PRO
 *
 */
public class login extends JDialog{//继承空布局类
	JLabel jl1,jl2,jl3;//标签
	JTextField userId;//用户名
	JPasswordField userPassword;//密码
	JButton login,cancel;//登录，取消，两个按钮
	Font f1;

	public login(){//构造方法
		jl1=new JLabel("用户名：");
		//设置它的位置和宽度，高度
		jl1.setBounds(150,260,60,60);
		this.add(jl1);

		jl2=new JLabel("（员工号）");
		jl2.setForeground(Color.red);//设置颜色
		jl2.setBounds(140,300,100,20);
		this.add(jl2);

		jl3=new JLabel("密    码：");
		jl3.setBounds(150, 320,130,20);
		this.add(jl3);

		//用户名文本框
		userId=new JTextField(20);
		//放在空布局里设置的属性，光标会默认在这里
		userId.setFocusable(true);
		userId.setBounds(190, 280, 140,20);
		userId.setFont(f1);
		this.add(userId);
		//在空布局里，可以用这个对齐
		userId.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		//密码文本框
		userPassword=new JPasswordField(20);
		//放在空布局里设置的属性，光标会默认在这里
		userPassword.setFocusable(true);
		userPassword.setBounds(190, 320, 140,20);
		this.add(userPassword);
		//
		userPassword.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		login=new JButton("登录");
		login.setBounds(170, 360, 70, 30);
		login.setFont(f1);
		this.add(login);

		cancel=new JButton("取消");
		cancel.setBounds(270, 360, 70, 30);
		cancel.setFont(f1);
		this.add(cancel);
		
		this.setForeground(Color.GREEN);//设置标题为绿色

		
		this.setLayout(null);//空布局

		BackImage b=new BackImage();
		b.setBounds(0, 0,500,400);
		this.add(b);
		this.setUndecorated(true);
		this.setSize(500,400);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//屏幕的宽度除以二-200就是我们窗口的横坐标，高度除以二-150就是纵坐标
		this.setLocation(width/2-350,height/2-300);
		this.setVisible(true);	
	}
}

class BackImage extends JPanel{
	Image im;
	public BackImage(){
		try{
			im=ImageIO.read(new File("image/2.png"));
		}catch(Exception e){

		}	
	}
		public void paint(Graphics g){
			g.drawImage(im,0,0,600,250,this);
	}
}






