package paper;

import java.util.Random;
import java.util.Scanner;

public class lesson1 {
	public static void main(String[] args){
		int num=new Random().nextInt(100);
		Scanner scan=new Scanner(System.in);
		System.out.println("ϵͳ�Ѿ��������һ��0-100������");
		System.out.println("���������ֲ�һ�°ɣ�����");
		int b=1;
		boolean flag=true;
		do{
			int a=scan.nextInt();
			if(a>num){
				System.out.println("���ԣ���µ�����̫����,�ٲ�");
			}else if(a<num){
				System.out.println("���ԣ���µ�����̫С�����ٲ�");
			}else{
				if(b==1){
					System.out.println("��������һ�ξͲ�����������");
				}else if(b>=2&&b<=6){
					System.out.println("��ܴ���Ŷ����"+b+"��");
				}else{
					System.out.println("��ñ���������"+b+"��");
				}
				flag=false;
			}
			b++;
		}while(flag);
	}
}
