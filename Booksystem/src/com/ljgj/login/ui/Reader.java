package com.ljgj.login.ui;

import java.util.Scanner;

import com.ljgj.bms.deletereader;
import com.ljgj.bms.readershow;
import com.ljgj.data.bms_data;

public class Reader {
	public static void Readerbook(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
	do{
		System.out.println("欢迎来到读者管理菜单");
		System.out.println("1、查看读者信息");
		System.out.println("2、增加读者信息");
		System.out.println("3、删除读者信息");
		System.out.println("4、修改读者信息");
		System.out.println("5、返回上一级");
		String answer=scan.next();
		if(answer.equalsIgnoreCase("1")){
			readershow.show();
		}else if(answer.equalsIgnoreCase("2")){
			addreader();
		}else if(answer.equalsIgnoreCase("3")){
			deletareader();
		}else if(answer.equalsIgnoreCase("4")){
			modifyreader();
		}else if(answer.equalsIgnoreCase("5")){
			flag=false;
		}else{
			
		}
	}while(flag);
	}
	public static void addreader(){
		Scanner scan=new Scanner(System.in);
		
		boolean flag=true;
		do{
			System.out.println("请输入想要添加的读者编号");
			String readerid=scan.next();
			System.out.println("请输入想要添加的读者名字");
			String readername=scan.next();
			System.out.println("请输入想要添加的积分");
			int reader_integral=scan.nextInt();
			if(com.ljgj.bms.addreader.add(readerid, readername, reader_integral)){
				System.out.println("添加读者信息成功");
				System.out.println("是否继续添加  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("添加读者失败");
				System.out.println("是否继续添加  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);	
	}
	public static void deletareader(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("请输入想要删除的读者编号");
			String readerid=scan.next();
			System.out.println("请输入想要删除的读者名字");
			String readername=scan.next();
			if(deletereader.delete(readerid, readername)){
				System.out.println("删除读者信息成功");
				System.out.println("是否继续删除  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("删除读者失败");
				System.out.println("是否继续删除  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);	
	}
	
	public static void modifyreader(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("请输入想要修改的读者编号");
			String readerid=scan.next();
			System.out.println("请输入想要修改的读者名字");
			String readername=scan.next();
			System.out.println("请输入想要修改的读者积分");
			int reader_integral=scan.nextInt();
			if(com.ljgj.bms.modifyreader.modify(readerid,readername,reader_integral)){
				System.out.println("修改读者信息成功");
				System.out.println("是否继续修改  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("修改读者失败");
				System.out.println("是否继续修改  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);	
	}
}