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
		System.out.println("��ӭ�������߹���˵�");
		System.out.println("1���鿴������Ϣ");
		System.out.println("2�����Ӷ�����Ϣ");
		System.out.println("3��ɾ��������Ϣ");
		System.out.println("4���޸Ķ�����Ϣ");
		System.out.println("5��������һ��");
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
			System.out.println("��������Ҫ��ӵĶ��߱��");
			String readerid=scan.next();
			System.out.println("��������Ҫ��ӵĶ�������");
			String readername=scan.next();
			System.out.println("��������Ҫ��ӵĻ���");
			int reader_integral=scan.nextInt();
			if(com.ljgj.bms.addreader.add(readerid, readername, reader_integral)){
				System.out.println("��Ӷ�����Ϣ�ɹ�");
				System.out.println("�Ƿ�������  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("��Ӷ���ʧ��");
				System.out.println("�Ƿ�������  Y/N");
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
			System.out.println("��������Ҫɾ���Ķ��߱��");
			String readerid=scan.next();
			System.out.println("��������Ҫɾ���Ķ�������");
			String readername=scan.next();
			if(deletereader.delete(readerid, readername)){
				System.out.println("ɾ��������Ϣ�ɹ�");
				System.out.println("�Ƿ����ɾ��  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("ɾ������ʧ��");
				System.out.println("�Ƿ����ɾ��  Y/N");
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
			System.out.println("��������Ҫ�޸ĵĶ��߱��");
			String readerid=scan.next();
			System.out.println("��������Ҫ�޸ĵĶ�������");
			String readername=scan.next();
			System.out.println("��������Ҫ�޸ĵĶ��߻���");
			int reader_integral=scan.nextInt();
			if(com.ljgj.bms.modifyreader.modify(readerid,readername,reader_integral)){
				System.out.println("�޸Ķ�����Ϣ�ɹ�");
				System.out.println("�Ƿ�����޸�  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}else{
				System.out.println("�޸Ķ���ʧ��");
				System.out.println("�Ƿ�����޸�  Y/N");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("y")){
					
				}else{
					flag=false;
				}
			}
		}while(flag);	
	}
}