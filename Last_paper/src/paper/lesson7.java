package paper;

import java.util.Scanner;

public class lesson7 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[] score={100,89,99,80,98};
		System.out.println("�����һ��������ѯ");
		int a=scan.nextInt();
		int i;
		boolean flag=false;
		for(i=0;i<score.length-1;i++){
			if(a==score[i]){
				flag=true;
			}
		}
		if(flag){
			System.out.println("���ҵ�");
		}else{
			System.out.println("�Ҳ���");
		}
	}
}
