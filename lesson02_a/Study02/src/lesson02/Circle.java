package lesson02;

public class Circle extends Shape{//��Բ���ܳ�
	double r;
	final double PI=3.1415926;
	
	void getGirth(){
		System.out.println("Բ���ܳ��ǣ�"+(2*r*PI));
	}
}
