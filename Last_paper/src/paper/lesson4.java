package paper;

public class lesson4 {
	public static void main(String[] args){
		int i=1;
		for(;i<=9;i++){
			for(int j=0;j<i;j++){
				System.out.print(i+"*"+(j+1)+"="+(j+1)*i+"\t");
			}
			System.out.println();
		}
	}
}