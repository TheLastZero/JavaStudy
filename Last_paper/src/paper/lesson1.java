package paper;

import java.util.Random;
import java.util.Scanner;

public class lesson1 {
	public static void main(String[] args){
		int num=new Random().nextInt(100);
		Scanner scan=new Scanner(System.in);
		System.out.println("系统已经随机生成一个0-100的数字");
		System.out.println("来输入数字猜一下吧！！！");
		int b=1;
		boolean flag=true;
		do{
			int a=scan.nextInt();
			if(a>num){
				System.out.println("不对，你猜的数字太大啦,再猜");
			}else if(a<num){
				System.out.println("不对，你猜的数字太小啦，再猜");
			}else{
				if(b==1){
					System.out.println("真厉害，一次就猜中啦！！！");
				}else if(b>=2&&b<=6){
					System.out.println("你很聪明哦猜了"+b+"次");
				}else{
					System.out.println("你好笨啊，猜了"+b+"次");
				}
				flag=false;
			}
			b++;
		}while(flag);
	}
}
