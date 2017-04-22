package lesson07;

import java.io.File;
import java.io.IOException;

public class lesson01 {
	public static void main(String[] args) throws Exception {
		File a1=new File("D:/1.txt");
		a1.createNewFile();
		
		File a2=new File("D:/tx/tx");
		a2.mkdirs();
		
		File a3=new File("D:/tx/tx/2.txt");
		a3.createNewFile();
		
		File a4=new File("D:","/3.txt");
		a4.createNewFile();
		
		System.out.println(a4.length());
	}
}