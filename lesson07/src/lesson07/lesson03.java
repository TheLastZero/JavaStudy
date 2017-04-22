package lesson07;

/**
 * 用StringBuffer读取文件内容，
 * 用这个时不用考虑汉字字节问题
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

public class lesson03 {
	public static void main(String[] args) throws Exception {
		
		//新建一个文件
		File f1=new File("D:/1.txt");
		f1.createNewFile();
		
		//声明一个写入的对象，在1.txt的文件里面写入write（）方法里的内容
		FileWriter fw=new FileWriter("D:/1.txt");
		fw.write("核武器挺热情微软");
		
		//将残留的数据也全部输出，然后关闭
		fw.flush();
		fw.close();
		
		//new一个输入流接收1.txt的文件的数据
		FileInputStream fis=new FileInputStream("D:/1.txt");
		
		/**
		 * 用一个int类型的对象去读取，fis里的数据，也就是ASCLL码值，
		 * 每次接收b个字节，这里的b是100字节每次
		 */
		int hasRead=0;
		byte[] b=new byte[100];
		
		hasRead=fis.read(b);
		//用一个缓冲流来读取这个文件的数据
		StringBuffer sb=new StringBuffer();
		
		while(hasRead!=-1){//一行一行的读取fis中的内容
			sb.append(new String(b,0,hasRead));
			hasRead=fis.read(b);
			System.out.println(sb);
		}	
		//关闭输入流，最后删除这个记事本
		fis.close();
		f1.delete();
	}
}