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
			System.out.println("��ӭ����������ͼ���");
			System.out.println("1.��¼����");
			System.out.println("2.�˳�ϵͳ");
			input=scan.next();
			if(input.equalsIgnoreCase("1")){
				com.ljgj.bms.redister.login();;
				a=true;
			}else if(input.equalsIgnoreCase("2")){
				a=false;
			}else{
				System.out.println("�������������ѡ��");
				a=true;
			}
		}while(a);
	}
}