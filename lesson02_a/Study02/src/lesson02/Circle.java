package lesson02;

public class Circle extends Shape{//求圆的周长
	double r;
	final double PI=3.1415926;
	
	void getGirth(){
		System.out.println("圆的周长是："+(2*r*PI));
	}
}
