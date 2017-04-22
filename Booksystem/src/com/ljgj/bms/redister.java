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
			System.out.println("请输入用户名");
			String username=scan.next();
			System.out.println("请输入密码");
			String password=scan.next();
			//找一下都多少个已有的用户名
			int max=0;
			for(;max<username0.length;max++){
				if(username0[max]==null){
					break;
				}
			}
			boolean flag=true;
			for(int i=0;i<max;i++){
				if(username.equals(username0[i])&&password.equals(password0[i])){
					System.out.println("正确，即将进入主菜单");
					bookmenu.bookmenu_.bookmenu();
					flag=false;
					a=false;
				}else{
					if(i==max-1){
						if(flag){
							System.out.println("账号或密码错误\n1、重新输入\n2、注册账号");
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
			System.out.println("请输入新建的用户名");
			String username=scan.next();
			System.out.println("请输入新建的密码");
			String password=scan.next();
			int max=0;//max算出已经储存了多少个用户名
			for(;max<username0.length;max++){
				if(username0[max]==null){
					break;
				}
			}
			boolean flag1=true;
			for(int i=0;i<max;i++){//i表示存储的用户名的下标
				if(username.equals(username0[i])){
					System.out.println("对不起，用户名相同，请重新输入");
					flag1=false;
				}else{
					if(i==max-1){
						if(flag1){
							username0[max]=username;
							password0[max]=password;
							System.out.println("恭喜您创建成功");
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