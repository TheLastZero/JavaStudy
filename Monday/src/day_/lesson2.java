package day_;

import java.util.Scanner;
 
public class lesson2 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in); 
		boolean flag = true;
		System.out.println("***��������***");
		System.out.println("��ѡ��Ҫʹ�õĹ���");
		do{
		System.out.println("1���ӷ�  2������  3���˷� 4������");
		int s = scan.nextInt(); 
		if(s==1){
			System.out.println("�������һ������");
			int a1 = scan.nextInt();
			System.out.println("������ڶ�������");
			int a2 = scan.nextInt();
			int sum =a1+a2;
			System.out.println(a1+"+"+a2+"="+sum);
		}else if(s==2){
			System.out.println("�������һ������");
			int a1 = scan.nextInt();
			System.out.println("������ڶ�������");
			int a2 = scan.nextInt();
			int sum =a1-a2;
			System.out.println(a1+"-"+a2+"="+sum);
		}else if(s==3){
			System.out.println("�������һ������");
			int a1 = scan.nextInt();
			System.out.println("������ڶ�������");
			int a2 = scan.nextInt();
			int sum =a1*a2;
			System.out.println(a1+"*"+a2+"="+sum);
		}else if(s==4){
			System.out.println("�������һ������");
			int a1 = scan.nextInt();
			System.out.println("������ڶ�������");
			int a2 = scan.nextInt();
			double sum =(double)a1/a2;
			System.out.println(a1+"/"+a2+"="+sum);
		}else{
			System.out.println("�ף�û�б��ѡ����Ŷ");
		}
		System.out.println("�Ƿ�Ҫ����ʹ�ü�����");
		System.out.println("1����"+"  2����");
		int x = scan.nextInt();
		if(x==2){
			flag=false;
			System.out.println("������ϵͳ���˳�");
		}
		}while(flag);
	}
}