package com.ljgj.login.ui;

import java.util.Scanner;

import com.ljgj.bms.showbook;
import com.ljgj.data.bms_data;

public class book_middle_ui {
	public static void middleui(){
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		do{
			System.out.println("��ӭ�����鼮�������˵�");
			System.out.println("1���鿴�鼮");
			System.out.println("2�������鼮");
			System.out.println("3��ɾ���鼮");
			System.out.println("4���޸��鼮");
			System.out.println("5��������һ��");
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
				System.out.println("�Բ���������������������");
			}
		}while(flag);
	}
	

	public static void modifybook(){
		Scanner scan=new Scanner(System.in);
		String[] bookname0=bms_data.bookname;
		double[] bookprice0=bms_data.bookprice;
		boolean flag=true;
		do{
			System.out.println("��������Ҫ�޸ĵ��鼮���");
			String bookid=scan.next();
			System.out.println("��������Ҫ�޸ĵ��鼮����");
			String bookname=scan.next();
			System.out.println("��������Ҫ�޸ĵ��鼮�۸�");
			double bookprice=scan.nextDouble();
			if(com.ljgj.bms.modifybook.modify(bookid, bookname, bookprice)){
				System.out.println("�޸��鼮�ɹ�");
				System.out.println("�Ƿ�����޸�  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("�޸��鼮ʧ��");
				System.out.println("�Ƿ�����޸�  Y/N");
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
			System.out.println("��������Ҫ��ӵ��鼮���");
			String bookid=scan.next();
			System.out.println("��������Ҫ��ӵ��鼮����");
			String bookname=scan.next();
			System.out.println("��������Ҫ��ӵ��鼮�ļ۸�");
			double bookprice=scan.nextDouble();
			if(com.ljgj.bms.addbook.add(bookid,bookname,bookprice)){
				System.out.println("����鼮�ɹ�");
				System.out.println("�Ƿ�������  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("����鼮ʧ��");
				System.out.println("�Ƿ�������  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);
	}
	
	public static void deletebookinfo(){
		//�����������ɾ���鼮
		String[] bookid0=bms_data.bookid;
		String[] bookname0=bms_data.bookname;
		Scanner scan=new Scanner(System.in);
		boolean flag=false;
		do{
			System.out.println("��������Ҫɾ�����鼮���");
			String bookid=scan.next();
			System.out.println("��������Ҫɾ�����鼮����");
			String bookname=scan.next();
			if(com.ljgj.bms.deletebookinfo.bookinfo(bookid,bookname)){
				System.out.println("ɾ���ɹ�"); 
				System.out.println("�Ƿ���Ҫ����ɾ��,Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					flag=true;
				}else{
					flag=false;
				}
			}else{
				System.out.println("��Ϣ��������Ƿ���������    Y/N");
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