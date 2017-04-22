package lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class lesson04 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:/1.jpg");
		FileOutputStream fos=new FileOutputStream("D:/1.jpg");
		
		int aa;
		aa=fis.read();
		while(aa!=-1){
			fos.write(aa);
			aa=fis.read();
		}
		
		fos.flush();
		fis.close();
		fos.close();
	}
}
