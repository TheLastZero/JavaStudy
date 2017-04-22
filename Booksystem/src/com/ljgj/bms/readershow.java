package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class readershow {
	public static void show(){
		Scanner scan=new Scanner(System.in);
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		System.out.println("******欢迎来到读者信息界面******");
		System.out.println("读者编号\t\t"+"读者名字\t\t"+"读者积分");
		for(int i=0;i<readerid.length;i++){
			if(readerid[i]==null){
				break;
			}else{
				System.out.println(readerid[i]+"\t\t"+readername[i]+"\t\t"+reader_integral[i]);
			}
		}
		System.out.println("请按任意键返回");
		String answer=scan.next();
	}
}