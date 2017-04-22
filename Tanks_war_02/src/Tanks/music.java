package Tanks;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class music extends Thread{//播放声音的时候不能中断其他的动作，所以做成线程类
	private String FileName;//文件名
	public music(String ypwj){//音频文件
		FileName=ypwj;
	}
	public void run(){//线程类得重写的run方法
		
		File wjl=new File(FileName);//用文件流来接收文件名
		
		AudioInputStream musicInput=null;//音频输入流
		
		try{
			//把音频文件输入进来
			musicInput =AudioSystem.getAudioInputStream(wjl);
		}catch(Exception e){
			
		}
		
		//这里对音频文件进行格式处理,这是一个固定格式
		AudioFormat format=musicInput.getFormat();
		SourceDataLine aqsj=null;
		DataLine.Info info=new DataLine.Info(DataLine.class, format);
		
		try{
			//对文件进行一个安全性的格式化的包装
			aqsj=(SourceDataLine) AudioSystem.getLine(info);
			aqsj.open(format);
		}catch(Exception e){
			
		}
		aqsj.start();
		
		int zjtj=0;
		
		byte[] hczj=new byte[1024];//缓冲字节
		
		try{
			while(zjtj!=-1){//不等于-1表示文件读取完了
				zjtj=musicInput.read(hczj,0,hczj.length);
				if(zjtj>0){
					//下标零开始，最后一次hczj.length里有多少就读多少
					aqsj.write(hczj,0,zjtj);
				}
				
			}
		}catch(Exception e){
			
		}
		
		finally{
			aqsj.drain();//将残留部分处理干净
			aqsj.close();
		}
		
	}
}