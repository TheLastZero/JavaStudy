package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class showbook {
	public static void show(){
		Scanner scan=new Scanner(System.in);
		String[] bookid=bms_data.bookid;
		String[] bookname=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		
		System.out.println("******************ͼ��Ŀ¼******************");
		System.out.println("�鼮���\t\t"+"����\t\t"+"�۸�");
		for(int i=0;i<bookid.length;i++){
			if(bookid[i]==null){
				break;
			}else{
				System.out.println(bookid[i]+"\t\t"+bookname[i]+"\t\t"+bookprice[i]);
			}
		}
		System.out.println("�������ַ�����");
		String all=scan.next();
	}
}