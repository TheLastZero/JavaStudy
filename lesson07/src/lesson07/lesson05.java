package lesson07;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �ַ���ת���ֽ���
 * @author С����-ST-PRO
 *
 */
public class lesson05 {
	public static void main(String[] args) throws IOException {
		BufferedWriter b=new BufferedWriter(new OutputStreamWriter(System.out));
		b.write("������дҪ������ַ���");
		b.write("\n");//  \n�ǻ��е���˼
		b.write(65);//������Ϊ����ʱ������ASCII��ֵ
		b.close();
	}
}
