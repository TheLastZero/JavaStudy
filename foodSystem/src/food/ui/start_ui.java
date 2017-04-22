package food.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 * 餐饮管理系统
 * 主要有模式model1是我们之前基础常用的思想,可扩展性比较差
 * 开发大型项目model2用的比较多,可拓展性非常强
 * Java可以做任何强大的界面，但是代码相对比较繁琐
 * 
 * 最上层是界面(ui)
 * 中间是模型(model)
 * 最下层是数据库(database)
 * 
 * JWindow,可以让我们的布局变的像窗口一样
 * @author 小钢炮-ST-PRO
 *
 */
//JWindow,可以让我们的布局变的像窗口一样
public class start_ui extends JWindow implements Runnable{
	/**
	 * 进度条:
	 * 以可视化形式显示某些任务进度的组件。
	 * 在任务的完成进度中，进度条显示该任务完成的百分比。
	 * 此百分比通常由一个矩形以可视化形式表示，该矩形开始是空的，
	 * 随着任务的完成逐渐被填充。此外，进度条可显示此百分比的文本表示形式。
	 */
	JProgressBar jpb;//放JWindow特有的控件,进度条
	JLabel jl1;//标签,用来放图片
	int width,height;//用长和宽代替像素，来设置出场位置
	
	public static void main(String[] args) {
		start_ui su=new start_ui();
		//new一个线程
		Thread t=new Thread(su);
		t.start();
	}
	
	public start_ui(){//构造方法
		
		jl1=new JLabel(new ImageIcon("image/2.png"));//括号里放图片地址
		
		jpb=new JProgressBar();
		//JProgressBar，有二十多种可以设置的地方
		jpb.setStringPainted(true);//对字符串进行设置
		jpb.setIndeterminate(false);
		jpb.setBorderPainted(false);
		jpb.setBackground(Color.PINK);//设置最下面的条的背景颜色
		
		this.add(jl1,BorderLayout.NORTH);//将图片添加至北部
		this.add(jpb,BorderLayout.SOUTH);//把进度条添加在南部
		
		this.setSize(600,360);
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//屏幕的宽度除以二-200就是我们窗口的横坐标，高度除以二-150就是纵坐标
		this.setLocation(width/2-350,height/2-300);
		this.setVisible(true);	
	}

	public void run() {
		//pv这个数组用来装进度条的百分比的数字
		int [] pv=new int[5];
		for(int i=0;i<pv.length;i++){
			pv[i]=(i+1)*20;
		}
		for(int i=0;i<pv.length;i++){
			try {
				Thread.sleep(1000);//睡眠一秒钟
			} catch (InterruptedException e) {
				
			}
			/**
			 * 把进度条分成了数组的值来过度
			 * 数组的值为1它就是 1，数组为的值为五十，它就是50
			 */
			jpb.setValue(pv[i]);
		}
		new login();
		this.dispose();//让当前界面关闭
	}
}
