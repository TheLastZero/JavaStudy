package Tanks;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class music extends Thread{//����������ʱ�����ж������Ķ��������������߳���
	private String FileName;//�ļ���
	public music(String ypwj){//��Ƶ�ļ�
		FileName=ypwj;
	}
	public void run(){//�߳������д��run����
		
		File wjl=new File(FileName);//���ļ����������ļ���
		
		AudioInputStream musicInput=null;//��Ƶ������
		
		try{
			//����Ƶ�ļ��������
			musicInput =AudioSystem.getAudioInputStream(wjl);
		}catch(Exception e){
			
		}
		
		//�������Ƶ�ļ����и�ʽ����,����һ���̶���ʽ
		AudioFormat format=musicInput.getFormat();
		SourceDataLine aqsj=null;
		DataLine.Info info=new DataLine.Info(DataLine.class, format);
		
		try{
			//���ļ�����һ����ȫ�Եĸ�ʽ���İ�װ
			aqsj=(SourceDataLine) AudioSystem.getLine(info);
			aqsj.open(format);
		}catch(Exception e){
			
		}
		aqsj.start();
		
		int zjtj=0;
		
		byte[] hczj=new byte[1024];//�����ֽ�
		
		try{
			while(zjtj!=-1){//������-1��ʾ�ļ���ȡ����
				zjtj=musicInput.read(hczj,0,hczj.length);
				if(zjtj>0){
					//�±��㿪ʼ�����һ��hczj.length���ж��پͶ�����
					aqsj.write(hczj,0,zjtj);
				}
				
			}
		}catch(Exception e){
			
		}
		
		finally{
			aqsj.drain();//���������ִ���ɾ�
			aqsj.close();
		}
		
	}
}