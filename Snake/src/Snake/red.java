package Snake;

import java.util.Random;

//��Ϊ���Ӳ��������ߵ��ƶ������¼��أ�����Ҫ��Ϊһ���������߳�
public class red implements Runnable{

	int x=0,y=0;//����
	
	int sum=0;//���ǵڼ�����ɫ����
	
	boolean life=true;//���ӵ�����
	
	red(){//��ʼ�����ӵ�λ��
		this.x=new Random().nextInt(780)+1;
		this.y=new Random().nextInt(660)+1;
		sum++;
	}

	void Random(){//��ÿ�Ե�һ�����Ӿ͵���һ�Σ��ù����´γ��ֵĵط����
		this.x=new Random().nextInt(780)+1;
		this.y=new Random().nextInt(660)+1;
		sum++;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
