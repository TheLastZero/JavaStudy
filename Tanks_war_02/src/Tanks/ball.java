package Tanks;


public class ball implements Runnable{
	//�ӵ���,���ӵ�����һ���߳��࣬��Ϊ���˵��ӵ��ǿ������⶯��
	int x,y;
	int direction;
	int speed=10;
	boolean life=true;//Ϊfalseʱ�Ͳ��ٻ��ӵ�
	public ball(int x,int y,int direction){//���췽��
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	public void run(){
		/**
		 * run�����Ǹ��ǵĸ��෽��
		 * �����߳�ʱ��˭���õ�start����������ͻ�ȥ�Զ�����run����
		 * start�ڵ��õ�ʱ��ᵥ����һ���߳�ȥ���ã�������ֱ�ӵ���
		 */
		while(true){
			try{
				/**
				 * �������ӵ�һֱ���䣬Ҫ����һ��ͣ�٣�Ҳ����˯��һ��ʱ��
				 * �����߳��������ѭ���ﶼҪ�и�˯�ߣ���Ȼ��������ױ���
				 */
				Thread.sleep(50);
			}catch(Exception e){

			}
			switch(direction){//����̹��ͷ�ķ����ж��ӵ�����ķ���
			case 0://̹��ͷ����
				y-=speed;
				break;
			case 1://̹��ͷ����
				x-=speed;
				break;
			case 2://̹��ͷ����
				x+=speed;
				break;
			case 3://̹��ͷ����
				y+=speed;
				break;
			}
			if(x<0||x>900||y<0||y>700){
				life=false;
				break;
			}
		}
	}
}
