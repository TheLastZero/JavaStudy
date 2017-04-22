package zidingyi;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
public class ImagePanel extends JPanel{

	Image im;
	public ImagePanel(Image im)
	{
		this.im=im;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}
