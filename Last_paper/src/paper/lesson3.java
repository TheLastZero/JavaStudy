package paper;

import java.util.Scanner;

public class lesson3 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=1;i<=n;i++){
			if(i==7){
				System.out.println("¹ý");
			}else{
				System.out.println(i);
			}
		}
	}
}