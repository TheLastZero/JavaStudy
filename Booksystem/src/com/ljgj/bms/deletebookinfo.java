package com.ljgj.bms;

import com.ljgj.data.bms_data;

public class deletebookinfo {
	public static boolean bookinfo(String bookid,String bookname){
		//�ڴ˷�����ɾ���鼮
		/**
		 * �����鵼��
		 */
		String[] bookid0=bms_data.bookid;
		String[] bookname0=bms_data.bookname;
		double[] bookprice=bms_data.bookprice;
		
		boolean flag=false;

		int max=0; //��������˶��ٱ���
		int position=0;  //�����õ��鼮���±�
		
		//����max��ֵ
		for(;max<bookid0.length;max++){
			if(bookid0[max]==null){
				break;
			}
		}
		for(;position<max;position++){
			if(bookid.equalsIgnoreCase(bookid0[position])&&bookname.equalsIgnoreCase(bookname0[position])){
				bookid0[position]=null;
				bookname0[position]=null;
				bookprice[position]=0;
				flag=true;
			}else{
				
			}
		}	
		for(int i=0;i<max-1;i++){
			if(bookid0[i]==null&&bookname0[i]==null){
				bookid0[i]=bookid0[i+1];
				bookname0[i]=bookname0[i+1];
				bookprice[i]=bookprice[i+1];
				bookid0[i+1]=null;
				bookname0[i+1]=null;
				bookprice[i+1]=0;
			}else{			
			}
		}
		return flag;
	}
}