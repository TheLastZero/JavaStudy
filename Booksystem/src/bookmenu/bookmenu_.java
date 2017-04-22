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
			System.out.println("欢迎进入书屋主菜单");
			System.out.println("1.书籍管理");
			System.out.println("2.读者管理");
			System.out.println("3.书籍借阅");
			System.out.println("4.积分换礼品");
			System.out.println("5.退出");
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
				System.out.println("您的输入有误请重新输入");
			}
		}while(b);
		
	}
}
