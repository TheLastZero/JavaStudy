package Tanks;

/**
 * �����ǹ���̹�˵�ԭ���Ϸ���
 */

/**
 * ������������̹�˳��ֵ�λ�ã�Ҳ���Ǻ�������
 * ���ҵ���̹�˵ķ���
 * @author С����-ST-PRO
 *
 */
public class Tank{
	//�����x��y����̹�˵ĺ�������
	int x=0,y=0;
	//̹�˵ķ���,0�ϣ�1��2�ң�3��
	int direction=0;
	//̹�˵��ƶ��ٶ�
	int speed=10;
	//������̹�˼�һ������ֵ
	boolean EnemyTankLife=true;


	//��װ̹�˵ķ�����ٶ�
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//��get��set��װx��y���Ժ�ı��������϶�Ҫ��װ��ʹ�ú�����ֱ��ʹ�ñ���Ҫ��ȫ
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	Tank(int x,int y){//���췽��
		this.x=x;
		this.y=y;
	}
}
