package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class readershow {
	public static void show(){
		Scanner scan=new Scanner(System.in);
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		System.out.println("******��ӭ����������Ϣ����******");
		System.out.println("���߱��\t\t"+"��������\t\t"+"���߻���");
		for(int i=0;i<readerid.length;i++){
			if(readerid[i]==null){
				break;
			}else{
				System.out.println(readerid[i]+"\t\t"+readername[i]+"\t\t"+reader_integral[i]);
			}
		}
		System.out.println("�밴���������");
		String answer=scan.next();
	}
}