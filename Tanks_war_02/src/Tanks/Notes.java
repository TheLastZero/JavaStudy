package Tanks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import Tanks.Notes;
import Tanks.enemyTank;
import Tanks.position;

public class Notes{//记录敌我坦克数量的类
private static int ETsum=10;//敌人坦克的数量
private static int MTank=2;//我的坦克数量
private static int dieETSum=0;//杀敌统计的变量
private static FileWriter fw=null;//IO流的输入流
private static BufferedWriter bw=null;//缓冲写
private static FileReader fr=null;//IO流的输出流
private static BufferedReader br=null;//缓冲读取

//声明一个集合类，来装主类里已经声明好的坦克集合类
Vector<enemyTank> ETank=new Vector<enemyTank>();
	
public void ETank(Vector<enemyTank> ETank){//从主类里接收坦克的集合类
	this.ETank=ETank;
}

//给保存的坦克的位置做一个集合类,这样就可以保存很多坦克的坐标
static Vector<position> wzjh=new Vector<position>();


public static void saveNotes(){//保存杀敌记录到记事本里,下次还是存在的
	try{
		fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");//保存的地址
		bw=new BufferedWriter(fw);//转换流
		/**
		 * 回车是将光标移到当前行的行首；
		 * 换行是将光标移到当前行的下一行，但还是同一列，
		 * 不会回到行首。它们合起来可以将光标移到下一行的行首，
		 * 也就是回车并换行。
		 */
		bw.write(dieETSum+"\r\n");
	}catch(Exception e){}
	finally{
		try{
			bw.close();//关闭转换流
			fw.close();//关闭输入流
		}catch(Exception e){}
	}
}


public static Vector<position> readNotes(){//读取从前的记录
	try{
		fr=new FileReader("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
		br=new BufferedReader(fr);
		String s=br.readLine();
		dieETSum=Integer.parseInt(s);//将读取到的结果s转化成整形,再给dieETSum
		
		while((s=br.readLine())!=null){//一行一行的读取br里的内容，有就继续，没有就跳出
			/**
			 * 用字符做间隔来确定数组元素,
			 * 假设有a" "b" "c" "这样一行话
			 * 我就以" "空格这个字符的数量作为数组的下标来间隔分块，
			 * 这样就可以分别读取一行里面的a,b,c了
			 */
			String[] sz=s.split(" ");
			//用Integer.parseInt()将读取到的字符串类型的文本转化成integer类型
			position wz=new position(Integer.parseInt(sz[0]),Integer.parseInt(sz[1]),Integer.parseInt(sz[2]));
			wzjh.add(wz);//将读取到的坦克位置数据，放到位置集合类里
		}
	}catch(Exception e){
		
	}
	finally{
		try{
			br.close();//关闭转换流
			fr.close();//关闭输出流
		}catch(Exception e){
			
		}
	}
	return wzjh;
}

public void saveGame(){//存档游戏的方法
	try{
		fw=new FileWriter("E:/study/java0/sy2/Tanks_war/src/saveGame.txt");
		bw=new BufferedWriter(fw);
		bw.write(dieETSum+"\r\n");
		for(int i=0;i<ETank.size();i++){
			enemyTank ET=ETank.get(i);
			if(ET.EnemyTankLife){//如果坦克还活着才记录它的坐标
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

public static void ETReduce(){//敌人坦克减少的类
	ETsum--;
}
public static void MTankReduce(){//敌人坦克减少的类
	MTank--;
}
public static void dieETSum(){//杀敌统计的类
	dieETSum++;
}
}