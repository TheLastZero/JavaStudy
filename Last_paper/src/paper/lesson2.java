package paper;

import java.util.Scanner;

public class lesson2 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个数字判断其是否为素数");
		int i=0;
		int sca=scan.nextInt();
		for(i=2;i<sca;i++){
			if(sca%i==0){
				System.out.println(sca+"不是素数");
				break;
			}
		}
		if(i==sca){
			System.out.println(sca+"是素数");
		}
	}
}