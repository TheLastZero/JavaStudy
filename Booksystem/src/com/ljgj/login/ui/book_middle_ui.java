package com.ljgj.login.ui;

import java.util.Scanner;

import com.ljgj.bms.showbook;
import com.ljgj.data.bms_data;

public class book_middle_ui {
	public static void middleui(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("欢迎来到书籍管理主菜单");
			System.out.println("1、查看书籍");
			System.out.println("2、增加书籍");
			System.out.println("3、删除书籍");
			System.out.println("4、修改书籍");
			System.out.println("5、返回上一级");
			String b=scan.next();
			if(b.equalsIgnoreCase("1")){
				showbook.show();
			}else if(b.equalsIgnoreCase("2")){
				addbook();
			}else if(b.equalsIgnoreCase("3")){
				deletebookinfo();
			}else if(b.equalsIgnoreCase("4")){
				modifybook();
			}else if(b.equalsIgnoreCase("5")){
				flag=false;
			}else{
				System.out.println("对不起，输入有误请重新输入");
			}
		}while(flag);
	}
	

	public static void modifybook(){
		Scanner scan=new Scanner(System.in);
		String[] bookname0=bms_data.bookname;
		double[] bookprice0=bms_data.bookprice;
		boolean flag=true;
		do{
			System.out.println("请输入想要修改的书籍编号");
			String bookid=scan.next();
			System.out.println("请输入想要修改的书籍名字");
			String bookname=scan.next();
			System.out.println("请输入想要修改的书籍价格");
			double bookprice=scan.nextDouble();
			if(com.ljgj.bms.modifybook.modify(bookid, bookname, bookprice)){
				System.out.println("修改书籍成功");
				System.out.println("是否继续修改  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("修改书籍失败");
				System.out.println("是否继续修改  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);	
	}
	
	public static void addbook(){
		String[] bookid0=bms_data.bookid;
		String[] bookname0=bms_data.bookname;
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("请输入想要添加的书籍编号");
			String bookid=scan.next();
			System.out.println("请输入想要添加的书籍名称");
			String bookname=scan.next();
			System.out.println("请输入想要添加的书籍的价格");
			double bookprice=scan.nextDouble();
			if(com.ljgj.bms.addbook.add(bookid,bookname,bookprice)){
				System.out.println("添加书籍成功");
				System.out.println("是否继续添加  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("添加书籍失败");
				System.out.println("是否继续添加  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);
	}
	
	public static void deletebookinfo(){
		//这个界面用来删除书籍
		String[] bookid0=bms_data.bookid;
		String[] bookname0=bms_data.bookname;
		Scanner scan=new Scanner(System.in);
		boolean flag=false;
		do{
			System.out.println("请输入想要删除的书籍编号");
			String bookid=scan.next();
			System.out.println("请输入想要删除的书籍名称");
			String bookname=scan.next();
			if(com.ljgj.bms.deletebookinfo.bookinfo(bookid,bookname)){
				System.out.println("删除成功"); 
				System.out.println("是否想要继续删除,Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					flag=true;
				}else{
					flag=false;
				}
			}else{
				System.out.println("信息输入错误，是否重新输入    Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					flag=true;
				}else{
					flag=false;
				}
			}
		}while(flag);
	}
}