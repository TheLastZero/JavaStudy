package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class deletereader {
	public static boolean delete(String readerid,String readername){
		Scanner scan=new Scanner(System.in);
		String[] readerid0=bms_data.readerid;
		String[] readername0=bms_data.readername;
		int[] reader_integral0=bms_data.reader_integral;
		
		boolean flag=false;
		
		//用max计算储存的信息中有多少人
		int max=0;
		for(;max<readerid0.length;max++){
			if(readerid0[max]==null){
				break;
				}
			}
		boolean flag2=true;
		for(int i=0;i<max;i++){
			if(readerid.equalsIgnoreCase(readerid0[i])||readername.equalsIgnoreCase(readername0[i])){
				readerid0[i]=null;
				readername0[i]=null;
				reader_integral0[i]=0;
				flag=true;
				flag2=false;
			}else{
			}
			if(flag2){
				System.out.println("信息输入错误编号或者，姓名不存在");
				break;
			}
		}
		for(int j=0;j<max;j++){
			if(readerid0[j]==null){
				readerid0[j]=readerid0[j+1];
				readername0[j]=readername0[j+1];
				reader_integral0[j]=reader_integral0[j+1];
				readerid0[j+1]=null;
				readername0[j+1]=null;
				reader_integral0[j+1]=0;
				
			}else{
				
			}
		}
		return flag;
	}
}