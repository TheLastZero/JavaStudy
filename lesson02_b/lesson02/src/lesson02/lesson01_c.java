package lesson02;

import java.util.Random;
import java.util.Scanner;
/**
 * 1，2，3，4，5，6六点 随机数6产生的概率(投掷十次筛子)
 * @author Administrator
 *
 */
public class lesson01_c {
	public static void main(String[] args){
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入要抛筛子的次数");
		int s=scan.nextInt();
		
		float a=1/6.000f;
		float b=5/6.000f;
		
		float p=a;//最后的概率
		
		for(int i=0;i<s-1;i++){
			p=p*b;
		}
		System.out.println("掷骰子"+s+"次以后，出现一次六的概率是："+p);
	}
}
