package com.ljgj.login.ui;

import java.util.Scanner;

import com.ljgj.bms.booklogin;
import com.ljgj.data.bms_data;

public class book_ljgj_login_ui {
	public static void main(String[] args) {
		loginui();
	}
	public static void loginui(){
		bms_data.initreaderdata();
		com.ljgj.data.bms_data.initbookdata();
		Scanner scan=new Scanner(System.in);
		String input ;
		boolean a=false;
		System.out.println();
		do{
			System.out.println("欢迎进入零界国际图书馆");
			System.out.println("1.登录界面");
			System.out.println("2.退出系统");
			input=scan.next();
			if(input.equalsIgnoreCase("1")){
				com.ljgj.bms.redister.login();;
				a=true;
			}else if(input.equalsIgnoreCase("2")){
				a=false;
			}else{
				System.out.println("输入错误，请重新选择");
				a=true;
			}
		}while(a);
	}
}