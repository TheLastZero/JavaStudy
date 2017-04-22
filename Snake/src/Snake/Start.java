package Snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start extends JFrame{

	public static void main(String[] args) {
		Start one=new Start();
	}

	Start(){
		Mpanel mp1=new Mpanel();
		this.add(mp1);
		//对mp1键盘的监听
		this.addKeyListener(mp1);

		//开启面板mp1的线程
		Thread Tr=new Thread(mp1);
		Tr.start();

		//初始化窗口
		this.setTitle("贪吃蛇");
		this.setSize(805,735);
		this.setLocation(550, 200);
		this.setResizable(false);//禁止窗口被拉伸放大
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
