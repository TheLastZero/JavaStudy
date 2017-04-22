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
 * ��¼����
 * @author С����-ST-PRO
 *
 */
public class login extends JDialog{//�̳пղ�����
	JLabel jl1,jl2,jl3;//��ǩ
	JTextField userId;//�û���
	JPasswordField userPassword;//����
	JButton login,cancel;//��¼��ȡ����������ť
	Font f1;

	public login(){//���췽��
		jl1=new JLabel("�û�����");
		//��������λ�úͿ�ȣ��߶�
		jl1.setBounds(150,260,60,60);
		this.add(jl1);

		jl2=new JLabel("��Ա���ţ�");
		jl2.setForeground(Color.red);//������ɫ
		jl2.setBounds(140,300,100,20);
		this.add(jl2);

		jl3=new JLabel("��    �룺");
		jl3.setBounds(150, 320,130,20);
		this.add(jl3);

		//�û����ı���
		userId=new JTextField(20);
		//���ڿղ��������õ����ԣ�����Ĭ��������
		userId.setFocusable(true);
		userId.setBounds(190, 280, 140,20);
		userId.setFont(f1);
		this.add(userId);
		//�ڿղ�����������������
		userId.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		//�����ı���
		userPassword=new JPasswordField(20);
		//���ڿղ��������õ����ԣ�����Ĭ��������
		userPassword.setFocusable(true);
		userPassword.setBounds(190, 320, 140,20);
		this.add(userPassword);
		//
		userPassword.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		login=new JButton("��¼");
		login.setBounds(170, 360, 70, 30);
		login.setFont(f1);
		this.add(login);

		cancel=new JButton("ȡ��");
		cancel.setBounds(270, 360, 70, 30);
		cancel.setFont(f1);
		this.add(cancel);
		
		this.setForeground(Color.GREEN);//���ñ���Ϊ��ɫ

		
		this.setLayout(null);//�ղ���

		BackImage b=new BackImage();
		b.setBounds(0, 0,500,400);
		this.add(b);
		this.setUndecorated(true);
		this.setSize(500,400);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		//��Ļ�Ŀ�ȳ��Զ�-200�������Ǵ��ڵĺ����꣬�߶ȳ��Զ�-150����������
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






