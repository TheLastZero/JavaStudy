package day_;

import java.util.Scanner;
 
public class lesson2 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in); 
		boolean flag = true;
		System.out.println("***零界计算器***");
		System.out.println("请选择要使用的功能");
		do{
		System.out.println("1、加法  2、减法  3、乘法 4、除法");
		int s = scan.nextInt(); 
		if(s==1){
			System.out.println("请输入第一个数字");
			int a1 = scan.nextInt();
			System.out.println("请输入第二个数字");
			int a2 = scan.nextInt();
			int sum =a1+a2;
			System.out.println(a1+"+"+a2+"="+sum);
		}else if(s==2){
			System.out.println("请输入第一个数字");
			int a1 = scan.nextInt();
			System.out.println("请输入第二个数字");
			int a2 = scan.nextInt();
			int sum =a1-a2;
			System.out.println(a1+"-"+a2+"="+sum);
		}else if(s==3){
			System.out.println("请输入第一个数字");
			int a1 = scan.nextInt();
			System.out.println("请输入第二个数字");
			int a2 = scan.nextInt();
			int sum =a1*a2;
			System.out.println(a1+"*"+a2+"="+sum);
		}else if(s==4){
			System.out.println("请输入第一个数字");
			int a1 = scan.nextInt();
			System.out.println("请输入第二个数字");
			int a2 = scan.nextInt();
			double sum =(double)a1/a2;
			System.out.println(a1+"/"+a2+"="+sum);
		}else{
			System.out.println("亲，没有别的选项了哦");
		}
		System.out.println("是否要继续使用计算器");
		System.out.println("1、是"+"  2、否");
		int x = scan.nextInt();
		if(x==2){
			flag=false;
			System.out.println("计算器系统已退出");
		}
		}while(flag);
	}
}