package lesson02;

import java.util.Random;
/**
 * ������ɶ�ʮ������ĸ
 * @author С����-ST-PRO
 *
 */
public class lesson01 {
	public static void main(String[] args) {
	
		for(int i=0;i<100;i++){
			int r=new Random().nextInt(26)+65;
			char a=(char)r;
			System.out.println(a);
		}
	}
}
