package bookmenu;

import java.util.Scanner;

import com.ljgj.data.bms_data;
import com.ljgj.login.ui.Reader;
import com.ljgj.login.ui.borrowbookinfo;

public class bookmenu_ {
	public static void bookmenu(){
		bms_data.initbookdata();
		Scanner scan=new Scanner(System.in);
		String a;
		boolean b=true;
		do{
			System.out.println("��ӭ�����������˵�");
			System.out.println("1.�鼮����");
			System.out.println("2.���߹���");
			System.out.println("3.�鼮����");
			System.out.println("4.���ֻ���Ʒ");
			System.out.println("5.�˳�");
			a=scan.next();
			if(a.equals("1")){
				com.ljgj.login.ui.book_middle_ui.middleui();
			}else if(a.equals("2")){
				Reader.Readerbook();
			}else if(a.equals("3")){
				borrowbookinfo.borrowbook();
			}else if(a.equals("4")){
				
			}else if(a.equals("5")){
				b=false;
			}else{
				System.out.println("����������������������");
			}
		}while(b);
		
	}
}
