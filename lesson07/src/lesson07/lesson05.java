package lesson07;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流转成字节流
 * @author 小钢炮-ST-PRO
 *
 */
public class lesson05 {
	public static void main(String[] args) throws IOException {
		BufferedWriter b=new BufferedWriter(new OutputStreamWriter(System.out));
		b.write("从这里写要输出的字符串");
		b.write("\n");//  \n是换行的意思
		b.write(65);//括号内为数字时，就是ASCII码值
		b.close();
	}
}
