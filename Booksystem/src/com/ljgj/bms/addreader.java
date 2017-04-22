package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class addreader {
	public static boolean add(String readerid, String readername, int reader_integral){
		Scanner scan=new Scanner(System.in);
		String[] readerid0=bms_data.readerid;
		String[] readername0=bms_data.readername;
		int[] reader_integral0=bms_data.reader_integral;
		
		boolean flag=true;
		
		//用max计算储存的信息中有多少人
		int max=0;
		for(;max<readerid0.length;max++){
			if(readerid0[max]==null){
				break;
			}
		}
		boolean flag1=true;
		for(int i=0;i<max;i++){
			if(readerid.equalsIgnoreCase(readerid0[i])){
				System.out.println("编号相同，无法添加");
				flag=false;
				flag1=false;
				break;
			}else{
				if(i==max-1){
					if(flag){
						readerid0[max]=readerid;
						readername0[max]=readername;
						reader_integral0[max]=reader_integral;
					}
				}else{
				}
			}
		}
		return flag;
	}	
}