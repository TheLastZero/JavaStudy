package lesson07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lesson02 {
	public static void main(String[] args) throws Exception {
		FileReader wf=new FileReader("D:/lesson07/lesson07/src/lesson07/lesson02.java");
		
		int aa=0;
		aa=wf.read();
		
		while(aa!=-1){
			System.out.print((char)aa);
			aa=wf.read();
		}
		wf.close();
	}
}
