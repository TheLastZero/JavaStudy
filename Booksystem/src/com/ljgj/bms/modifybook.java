package com.ljgj.bms;

import com.ljgj.data.bms_data;

public class modifybook {
	public static boolean modify(String bookid,String bookname,double bookprice){
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
		boolean flag2=true;
		for(int i=0;i<max;i++){
			if(bookid.equalsIgnoreCase(bookid0[i])){
				bookname0[i]=bookname;
				bookprice0[i]=bookprice;
				flag2=false;
			}else{
				
			}
			if(i==max-1){
				if(flag2){
					System.out.println("书籍编号不存在");
					flag=false;		
				}			
			}
		}
		return flag;
	}
}