package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class borrowbook {
	public static void borrow(int id){//id表示读者名字的下标，也即为读者编号id的下标
		Scanner scan=new Scanner(System.in);
		String[] bookid=bms_data.bookid;
		String[] bookname=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		
		System.out.println("借书人的编号为"+readerid[id]+"\t姓名："+readername[id]);
		System.out.println("******************图书目录******************");
		System.out.println("书籍编号\t\t"+"书名\t\t");
		int max;
		for(max=0;max<bookid.length;max++){
			if(bookid[max]==null){
				break;
			}else{
				System.out.println(bookid[max]+"\t\t"+bookname[max]+"\t\t");
			}
		}
		
		boolean flag=true;
		boolean flag0=true;
		do{
			System.out.println("请输入相应编号选择要借阅的书籍");
			String idn=scan.next();
			for(int i=0;i<max;i++){
				if(idn.equalsIgnoreCase(bookid[i])){
					System.out.println("找到此书,处理借阅中。。。");
					borrowdo(i,id);
					System.out.println("借阅成功，是否继续借阅\n1、继续借阅\n2、我不借了");
					String all=scan.next();
					flag=false;
					if(all.equalsIgnoreCase("1")){
					}else{
						flag0=false;
					}
				}else{
					if(i==max-1){
						if(flag){
							System.out.println("无此编号\n1、重新输入\n2、返回上一级");
							String a=scan.next();
							if(a.equalsIgnoreCase("1")){
								
							}else{
								flag0=false;
							}
						}else{
							
						}
					}else{
					}
				}
			}
		}while(flag0);
	}
	public static void borrowdo(int i, int id){
		//i为找到的书的原书库的下标，id为读者名字的下标
		Scanner scan=new Scanner(System.in);
		String[] bookid=bms_data.bookid;
		String[] bookname=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		String[] borrowid=bms_data.boorowid;
		String[] borrowname=bms_data.boorowname;
		double[] borrowprice=bms_data.borrowprice;
		int []borrowamount=bms_data.boorowamount;
		
		//转换书籍编号,书的名字，书的价格。
		int a=i*5;
		int b=(i+1)*5-1;
		for(;a<b;a++){
			if(borrowid[a]==null){
				borrowid[a]=bookid[i];
				borrowname[a]=bookname[i];
				borrowprice[a]=bookprice[i];
				System.out.println("借阅书籍的编号为"+borrowid[a]);
				System.out.println("借阅的书名为"+borrowname[a]);
				break;
			}else{
				
			}
		}	
		bookid[i]=null;
		bookname[i]=null;	
		do{
			if(bookid[i]==null){
				bookid[i]=bookid[i+1];
				bookname[i]=bookname[i+1];
				bookprice[i]=bookprice[i+1];
				bookid[i+1]=null;
				bookname[i+1]=null;
				bookprice[i+1]=0;
				i++;
			}else{
				
			}
		}while(i<49);
		borrowamount[id]+=1;
	}
}