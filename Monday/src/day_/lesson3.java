package day_;

public class lesson3 {
	public static void main(String[] args) {
		boolean flag=true;
		int i=1;
		do{
			System.out.println(i);
			i++;
			if(i==5){
				flag=false;
			}
		}while(flag);
	}
}