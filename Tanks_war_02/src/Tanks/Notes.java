package Tanks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import Tanks.Notes;
import Tanks.enemyTank;
import Tanks.position;

public class Notes{//��¼����̹����������
private static int ETsum=10;//����̹�˵�����
private static int MTank=2;//�ҵ�̹������
private static int dieETSum=0;//ɱ��ͳ�Ƶı���
private static FileWriter fw=null;//IO����������
private static BufferedWriter bw=null;//����д
private static FileReader fr=null;//IO���������
private static BufferedReader br=null;//�����ȡ

//����һ�������࣬��װ�������Ѿ������õ�̹�˼�����
Vector<enemyTank> ETank=new Vector<enemyTank>();
	
public void ETank(Vector<enemyTank> ETank){//�����������̹�˵ļ�����
	this.ETank=ETank;
}

//�������̹�˵�λ����һ��������,�����Ϳ��Ա���ܶ�̹�˵�����
static Vector<position> wzjh=new Vector<position>();


public static void saveNotes(){//����ɱ�м�¼�����±���,�´λ��Ǵ��ڵ�
	try{
		fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");//����ĵ�ַ
		bw=new BufferedWriter(fw);//ת����
		/**
		 * �س��ǽ�����Ƶ���ǰ�е����ף�
		 * �����ǽ�����Ƶ���ǰ�е���һ�У�������ͬһ�У�
		 * ����ص����ס����Ǻ��������Խ�����Ƶ���һ�е����ף�
		 * Ҳ���ǻس������С�
		 */
		bw.write(dieETSum+"\r\n");
	}catch(Exception e){}
	finally{
		try{
			bw.close();//�ر�ת����
			fw.close();//�ر�������
		}catch(Exception e){}
	}
}


public static Vector<position> readNotes(){//��ȡ��ǰ�ļ�¼
	try{
		fr=new FileReader("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
		br=new BufferedReader(fr);
		String s=br.readLine();
		dieETSum=Integer.parseInt(s);//����ȡ���Ľ��sת��������,�ٸ�dieETSum
		
		while((s=br.readLine())!=null){//һ��һ�еĶ�ȡbr������ݣ��оͼ�����û�о�����
			/**
			 * ���ַ��������ȷ������Ԫ��,
			 * ������a" "b" "c" "����һ�л�
			 * �Ҿ���" "�ո�����ַ���������Ϊ������±�������ֿ飬
			 * �����Ϳ��Էֱ��ȡһ�������a,b,c��
			 */
			String[] sz=s.split(" ");
			//��Integer.parseInt()����ȡ�����ַ������͵��ı�ת����integer����
			position wz=new position(Integer.parseInt(sz[0]),Integer.parseInt(sz[1]),Integer.parseInt(sz[2]));
			wzjh.add(wz);//����ȡ����̹��λ�����ݣ��ŵ�λ�ü�������
		}
	}catch(Exception e){
		
	}
	finally{
		try{
			br.close();//�ر�ת����
			fr.close();//�ر������
		}catch(Exception e){
			
		}
	}
	return wzjh;
}

public void saveGame(){//�浵��Ϸ�ķ���
	try{
		fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
		bw=new BufferedWriter(fw);
		bw.write(dieETSum+"\r\n");
		for(int i=0;i<ETank.size();i++){
			enemyTank ET=ETank.get(i);
			if(ET.EnemyTankLife){//���̹�˻����Ųż�¼��������
				String position=ET.x+" "+ET.y+" "+ET.direction+" ";
				bw.write(position+"\r\n");
			}
		}
	}catch(Exception e){
		
	}
	finally{
		try{
			bw.close();
			fw.close();
		}catch(Exception e){
			
		}
	}
}


public static int getDieETSum() {
	return dieETSum;
}
public static void setDieETSum(int dieETSum) {
	Notes.dieETSum = dieETSum;
}
public static int getETsum() {
	return ETsum;
}
public static void setETsum(int eTsum) {
	ETsum = eTsum;
}
public static int getMTank() {
	return MTank;
}
public static void setMTank(int mTank) {
	MTank = mTank;
}

public static void ETReduce(){//����̹�˼��ٵ���
	ETsum--;
}
public static void MTankReduce(){//����̹�˼��ٵ���
	MTank--;
}
public static void dieETSum(){//ɱ��ͳ�Ƶ���
	dieETSum++;
}
}