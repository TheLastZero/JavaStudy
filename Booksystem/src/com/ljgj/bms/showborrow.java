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
		
		System.out.println("��ӭ�����鼮������Ϣ��");
		System.out.println("���߱��\t\t��������\t\t�����鼮����\t���߻���");
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
			System.out.println("������߱�ſ��Բ鿴���߽��ĵ��鼮��Ϣ");
			String a=scan.next();
			for(int i=0;i<max;i++){
				if(a.equalsIgnoreCase(readerid[i])){
					System.out.println("���Ϊ"+readerid[i]+"�Ķ��ߣ�"+readername[i]+"���ĵ��鼮�У�");
					System.out.println("���\t"+"����");
						int b=i*5;
						int c=(i+1)*5-1;
						for(;b<=c;b+=1){
							if(borrowid[i*5]==null){
								System.out.println(readername[i]+"��ʱ��û�н���ͼ��Ŷ");
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
					System.out.println("�����������ַ�������һ��");
					String all=scan.next();
					flag1=false;
					flag=false;
				}else{
					if(i==max-1){
						if(flag1){
							System.out.println("�Բ���δ�ҵ��˱�š�\n1����������\n2��������һ��");
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