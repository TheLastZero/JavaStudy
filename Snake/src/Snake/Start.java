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
		//��mp1���̵ļ���
		this.addKeyListener(mp1);

		//�������mp1���߳�
		Thread Tr=new Thread(mp1);
		Tr.start();

		//��ʼ������
		this.setTitle("̰����");
		this.setSize(805,735);
		this.setLocation(550, 200);
		this.setResizable(false);//��ֹ���ڱ�����Ŵ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
