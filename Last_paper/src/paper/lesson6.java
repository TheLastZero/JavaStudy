package paper;

import java.util.Scanner;

public class lesson6 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int sroce=scan.nextInt();
		int n=0;
		if(sroce>=90){
			n=1;
		}else if(sroce>=80&&sroce<90){
			n=2;
		}else if(sroce>=70&&sroce<80){
			n=3;
		}else if(sroce>=60&&sroce<70){
			n=4;
		}
		switch(n){
		case 1:System.out.println("a");break;
		case 2:System.out.println("b");break;
		case 3:System.out.println("c");break;
		case 4:System.out.println("d");break;
		default:System.out.println("d");break;
		}
	}
}