package com.ljgj.login.ui;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class borrowbookinfo {
	public static void borrowbook(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("欢迎来到书籍借阅菜单");
			System.out.println("1、查看书籍借阅信息");
			System.out.println("2、借阅图书");
			System.out.println("3、归还图书");
			System.out.println("4、返回上一级");
			String a=scan.next();
			if(a.equalsIgnoreCase("1")){
				show();
			}else if(a.equalsIgnoreCase("2")){
				borrow();
			}else if(a.equalsIgnoreCase("3")){
				returnbook();
			}else{
				flag=false;
			}
		}while(flag);
		
	}
	public static void show(){
		com.ljgj.bms.showborrow.show();
	}
	public static void borrow(){
		Scanner scan=new Scanner(System.in);
		String[] readerid0=bms_data.readerid;
		String[] readername0=bms_data.readername;
		int max=0;
		for(;max<readerid0.length;max++){
			if(readerid0[max]==null){
				break;
			}else{
				
			}
		}
		boolean flag=false;
		boolean flag1=true;
		do{
			System.out.println("请输入想要借书的读者名字");
			String name=scan.next();
			for(int i=0;i<max;i++){
				if(readername0[i].equalsIgnoreCase(name)){
					com.ljgj.bms.borrowbook.borrow(i);
					flag1=false;
				}else{
					if(i==max-1){
						if(flag1){
							System.out.println("对不起，查无此人。\n1、重新输入\n2、返回上一级");
							int a=scan.nextInt();
							if(a==1){
								flag=true;
							}else{
								
							}
						}	
					}else{
						
					}
				}
			}	
		}while(flag);
	}
	public static void returnbook(){
	}
}