package lesson02;

import java.util.Random;

public class lesson01_b {
	//自定义10-999之间的随机数
	public static void main(String[] args) {
		for(int i=0;i<10000;i++){
			int r=new Random().nextInt(990)+10;
				System.out.println(r);
		}
	}
}