package com.ljgj.bms;

import com.ljgj.data.bms_data;

public class addbook {
	public static boolean add(String bookid,String bookname,double bookprice){
		String[] bookid0=bms_data.bookid;
		String[] bookname0=bms_data.bookname;
		double[] bookprice0=bms_data.bookprice;
		boolean flag=true;
		
		int max=0; //算出储存了多少本书
		
		//计算max的值，max的值为数的总数量
		for(;max<bookid0.length;max++){
			if(bookid0[max]==null){
				break;
			}
		}
		boolean flag1=true;
		for(int i=0;i<max;i++){
			if(bookid.equals(bookid0[i])||bookname.equalsIgnoreCase(bookname0[i])){
				System.out.println("书籍编号或名字重复");
				flag=false;
				flag1=false;
				break;
			}else{
				if(i==max-1){
					if(flag){
						bookid0[max]=bookid;
						bookname0[max]=bookname;
						bookprice0[max]=bookprice;
					}
				}else{
				}
			}
		}
		return flag;
	}
}