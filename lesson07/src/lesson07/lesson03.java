package lesson07;

/**
 * ��StringBuffer��ȡ�ļ����ݣ�
 * �����ʱ���ÿ��Ǻ����ֽ�����
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
		
		//�½�һ���ļ�
		File f1=new File("D:/1.txt");
		f1.createNewFile();
		
		//����һ��д��Ķ�����1.txt���ļ�����д��write���������������
		FileWriter fw=new FileWriter("D:/1.txt");
		fw.write("������ͦ����΢��");
		
		//������������Ҳȫ�������Ȼ��ر�
		fw.flush();
		fw.close();
		
		//newһ������������1.txt���ļ�������
		FileInputStream fis=new FileInputStream("D:/1.txt");
		
		/**
		 * ��һ��int���͵Ķ���ȥ��ȡ��fis������ݣ�Ҳ����ASCLL��ֵ��
		 * ÿ�ν���b���ֽڣ������b��100�ֽ�ÿ��
		 */
		int hasRead=0;
		byte[] b=new byte[100];
		
		hasRead=fis.read(b);
		//��һ������������ȡ����ļ�������
		StringBuffer sb=new StringBuffer();
		
		while(hasRead!=-1){//һ��һ�еĶ�ȡfis�е�����
			sb.append(new String(b,0,hasRead));
			hasRead=fis.read(b);
			System.out.println(sb);
		}	
		//�ر������������ɾ��������±�
		fis.close();
		f1.delete();
	}
}