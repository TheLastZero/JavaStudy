package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class redister {
	public static void login(){
		bms_data.redister();
		String[] username0=com.ljgj.data.bms_data.username;
		String[] password0=com.ljgj.data.bms_data.password;
		boolean a=false;
		do{
			Scanner scan=new Scanner(System.in);
			System.out.println("�������û���");
			String username=scan.next();
			System.out.println("����������");
			String password=scan.next();
			//��һ�¶����ٸ����е��û���
			int max=0;
			for(;max<username0.length;max++){
				if(username0[max]==null){
					break;
				}
			}
			boolean flag=true;
			for(int i=0;i<max;i++){
				if(username.equals(username0[i])&&password.equals(password0[i])){
					System.out.println("��ȷ�������������˵�");
					bookmenu.bookmenu_.bookmenu();
					flag=false;
					a=false;
				}else{
					if(i==max-1){
						if(flag){
							System.out.println("�˺Ż��������\n1����������\n2��ע���˺�");
							String b=scan.next();
							if(b.equals("1")){
								a=true;
							}else{
								redister();
								a=false;
							}
						}
					}else{
						
					}
				}
			}
		}while(a);
	}
	public static void redister(){
		String[] username0=com.ljgj.data.bms_data.username;
		String[] password0=com.ljgj.data.bms_data.password;
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("�������½����û���");
			String username=scan.next();
			System.out.println("�������½�������");
			String password=scan.next();
			int max=0;//max����Ѿ������˶��ٸ��û���
			for(;max<username0.length;max++){
				if(username0[max]==null){
					break;
				}
			}
			boolean flag1=true;
			for(int i=0;i<max;i++){//i��ʾ�洢���û������±�
				if(username.equals(username0[i])){
					System.out.println("�Բ����û�����ͬ������������");
					flag1=false;
				}else{
					if(i==max-1){
						if(flag1){
							username0[max]=username;
							password0[max]=password;
							System.out.println("��ϲ�������ɹ�");
							flag=false;
						}else{
						}	
					}else{
					}
				}
			}
		}while(flag);	
	}
}