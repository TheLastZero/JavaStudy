package lesson02;

import java.util.Random;
import java.util.Scanner;
/**
 * 1��2��3��4��5��6���� �����6�����ĸ���(Ͷ��ʮ��ɸ��)
 * @author Administrator
 *
 */
public class lesson01_c {
	public static void main(String[] args){
		Scanner scan= new Scanner(System.in);
		System.out.println("������Ҫ��ɸ�ӵĴ���");
		int s=scan.nextInt();
		
		float a=1/6.000f;
		float b=5/6.000f;
		
		float p=a;//���ĸ���
		
		for(int i=0;i<s-1;i++){
			p=p*b;
		}
		System.out.println("������"+s+"���Ժ󣬳���һ�����ĸ����ǣ�"+p);
	}
}
