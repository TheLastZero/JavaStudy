package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class modifyreader {
	public static boolean modify(String readerid,String readername,int reader_integral){
		Scanner scan=new Scanner(System.in);
		String[] readerid0=bms_data.readerid;
		String[] readername0=bms_data.readername;
		int[] reader_integral0=bms_data.reader_integral;
		
		boolean flag=true;
		
		int max=0; //��������˶��ٱ���
		
		//����max��ֵ��max��ֵΪ����������
		for(;max<readerid0.length;max++){
			if(readerid0[max]==null){
				break; 
			}
		}
		boolean flag2=true; 
		for(int i=0;i<max;i++){
			if(readerid.equalsIgnoreCase(readerid0[i])){
				readername0[i]=readername;
				reader_integral0[i]=reader_integral;
				flag2=false;
			}else{		
			}
			if(i==max-1){
				if(flag2){
					System.out.println("�鼮��Ų�����");
					flag=false;		
				}			
			}
		}	
		return flag;
	}
}