package Snake;

public class MySnake {
	//�����ɶ�����鹹�ɵ�,ÿ�����鶼���Լ��ĺ�������
	int x=0,y=0;
	static int sum=0;
	
	//�����ʾ��ͷ�ķ���,0,1,2,3�����ϣ��ң��£���
	int direction=1;
	
	MySnake(int x,int y){
		this.x=x;
		this.y=y;
		sum++;
	}
}