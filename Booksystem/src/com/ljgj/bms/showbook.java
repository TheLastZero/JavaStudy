package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class showbook {
	public static void show(){
		Scanner scan=new Scanner(System.in);
		String[] bookid=bms_data.bookid;
		String[] bookname=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		
		System.out.println("******************图书目录******************");
		System.out.println("书籍编号\t\t"+"书名\t\t"+"价格");
		for(int i=0;i<bookid.length;i++){
			if(bookid[i]==null){
				break;
			}else{
				System.out.println(bookid[i]+"\t\t"+bookname[i]+"\t\t"+bookprice[i]);
			}
		}
		System.out.println("按任意字符返回");
		String all=scan.next();
	}
}