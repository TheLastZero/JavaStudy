package com.ljgj.data;

public class bms_data {
	public static String[] username=new String[50];
	public static String[] password=new String[50];
	public static void redister(){
		username[0]="ljgj";
		password[0]="ljgj";
	}
	public static String[] bookid=new String[50];
	public static String[] bookname=new String[50];
	public static double[] bookprice=new double[50];
	public static void initbookdata(){
		bookid[0]="16001";
		bookname[0]="∫Ï¬•√Œ";
		bookprice[0]=59.6;
		
		bookid[1]="16002";
		bookname[1]="Œﬁœﬁø÷≤¿";
		bookprice[1]=67.2;
		
		bookid[2]="16003";
		bookname[2]="≈Ã¡˙";
		bookprice[2]=49.6;
		
		bookid[3]="16004";
		bookname[3]="–«≥Ω±‰";
		bookprice[3]=52.6;
		
		bookid[4]="16005";
		bookname[4]="ŒﬁœﬁŒ¥¿¥";
		bookprice[4]=109.6;
		
		bookid[5]="16006";
		bookname[5]="…Òƒπ";
		bookprice[5]=79.6;
		
		bookid[6]="16007";
		bookname[6]="∂∑∆∆≤‘Ò∑";
		bookprice[6]=89.6;
	}
	
	public static String[] readerid=new String[50];
	public static String[] readername=new String[50];
	public static int[] reader_integral=new int[50];
	public static void initreaderdata(){
		readerid[0]="1000";
		readername[0]="∏ ÷æ∏’";
		reader_integral[0]=10;
		
		readerid[1]="1001";
		readername[1]="œ£¿≠¿Ô";
		reader_integral[1]=15;
		
		readerid[2]="1002";
		readername[2]="∂≈‘¬Ûœ";
		reader_integral[2]=20;
	}
	public static int []boorowamount=new int[50];
	public static String []boorowid=new String[250];
	public static String []boorowname=new String[250];
	public static double []borrowprice=new double[250];
}