package com.ljgj.bms;

import java.util.Scanner;

import com.ljgj.data.bms_data;

public class borrowbook {
	public static void borrow(int id){//id��ʾ�������ֵ��±꣬Ҳ��Ϊ���߱��id���±�
		Scanner scan=new Scanner(System.in);
		String[] bookid=bms_data.bookid;
		String[] bookname=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		String[] readerid=bms_data.readerid;
		String[] readername=bms_data.readername;
		int[] reader_integral=bms_data.reader_integral;
		
		System.out.println("�����˵ı��Ϊ"+readerid[id]+"\t������"+readername[id]);
		System.out.println("******************ͼ��Ŀ¼******************");
		System.out.println("�鼮���\t\t"+"����\t\t");
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
			System.out.println("��������Ӧ���ѡ��Ҫ���ĵ��鼮");
			String idn=scan.next();
			for(int i=0;i<max;i++){
				if(idn.equalsIgnoreCase(bookid[i])){
					System.out.println("�ҵ�����,��������С�����");
					borrowdo(i,id);
					System.out.println("���ĳɹ����Ƿ��������\n1����������\n2���Ҳ�����");
					String all=scan.next();
					flag=false;
					if(all.equalsIgnoreCase("1")){
					}else{
						flag0=false;
					}
				}else{
					if(i==max-1){
						if(flag){
							System.out.println("�޴˱��\n1����������\n2��������һ��");
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
		//iΪ�ҵ������ԭ�����±꣬idΪ�������ֵ��±�
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
		
		//ת���鼮���,������֣���ļ۸�
		int a=i*5;
		int b=(i+1)*5-1;
		for(;a<b;a++){
			if(borrowid[a]==null){
				borrowid[a]=bookid[i];
				borrowname[a]=bookname[i];
				borrowprice[a]=bookprice[i];
				System.out.println("�����鼮�ı��Ϊ"+borrowid[a]);
				System.out.println("���ĵ�����Ϊ"+borrowname[a]);
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