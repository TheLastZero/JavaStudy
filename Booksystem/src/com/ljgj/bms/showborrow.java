package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class showborrow {
	public static void show(){
		Scanner scan=new Scanner(System.in);
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		int[] borrowamount=bms_data.boorowamount;
		String[] borrowid=bms_data.boorowid;
		String[] borrowname=bms_data.boorowname;
		double[] borrowprice=bms_data.borrowprice;
		
		System.out.println("欢迎来到书籍借阅信息处");
		System.out.println("读者编号\t\t读者姓名\t\t借阅书籍数量\t读者积分");
		int max=0;
		for(;max<readerid.length;max++){
			if(readerid[max]==null){
				break;
			}else{
				System.out.println(readerid[max]+"\t\t"+readername[max]+"\t\t    "+borrowamount[max]+"\t\t  "+reader_integral[max]);
			}
		}
		boolean flag=true;
		boolean flag1=true;
		do{
			System.out.println("输入读者编号可以查看读者借阅的书籍信息");
			String a=scan.next();
			for(int i=0;i<max;i++){
				if(a.equalsIgnoreCase(readerid[i])){
					System.out.println("编号为"+readerid[i]+"的读者："+readername[i]+"借阅的书籍有：");
					System.out.println("编号\t"+"书名");
						int b=i*5;
						int c=(i+1)*5-1;
						for(;b<=c;b+=1){
							if(borrowid[i*5]==null){
								System.out.println(readername[i]+"暂时还没有借阅图书哦");
								break;
							}else{
	
							}
							if(b<=c){
								if(borrowid[b]==null){
									break;
								}else{						
								}
								System.out.println(borrowid[b]+"\t"+borrowname[b]);	
							}else{			
							}
						}			
					System.out.println("请输入任意字符返回上一级");
					String all=scan.next();
					flag1=false;
					flag=false;
				}else{
					if(i==max-1){
						if(flag1){
							System.out.println("对不起，未找到此编号。\n1、重新输入\n2、返回上一级");
							String b=scan.next();
							if(b.equalsIgnoreCase("1")){
							}else{
								flag=false;
							}
						}else{		
						}
					}else{
					}
				}
			}
		}while(flag);
	}
}