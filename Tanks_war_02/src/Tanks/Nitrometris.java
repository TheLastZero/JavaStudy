package Tanks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 关卡面板类，实现Runnable线程接口
 * 做成线程类以后，第一关的字样，可以不停的闪烁
 * @author 小钢炮-ST-PRO
 *
 */


/**
 * 之所以本段程序可以不停的循环
 * 是因为实现了线程接口后，run方法在本段程序先运行，优先于paint
 * 而run方法中有一个while循环，
 * 里面先让线程睡眠400毫秒，
 * 再用this.repaint();调用当前对象的paint方法
 * 
 */

public class Nitrometris extends JPanel implements Runnable{

	int times=0;

	public void paint(Graphics g){
		super.paint(g);
		
		g.fillRect(0, 0,900,700);

		if(times%2==0){//time位偶数时才进来写第一关，所以会出现闪烁的效果
			g.setColor(Color.yellow);
			Font MyFont=new Font("华文行楷",Font.BOLD,38);//斜体，字号
			//设置字体
			g.setFont(MyFont);
			g.drawString("第一关",400, 300);//后两个是画出来的位置
		}
	}

	public void run() {
		while(true){
			try{
				Thread.sleep(400);//让线程休眠一下,就是闪烁间隔的时间
			}catch(Exception e){

			}
			times++;
			this.repaint();//重绘
		}
	}
}
