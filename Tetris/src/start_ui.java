import java.util.Random;

/**
 * ��̬��ϰ����˹������
 * @author С����-ST-PRO
 *
 */
public class start_ui {
	public static void main(String[] args) {
		int a= new Random().nextInt(4);
		FK fk =new FK();
		fk=null;
		switch(a){
		case 0:
			fk = new FK_szx();
			break;
		case 1:
			fk = new FK_lzx();
			break;
		case 2:
			fk = new FK_zzx();
			break;
		case 3:
			fk = new FK_cfx();
			break;
		}
		fk.bx();//���ö�̬�Ӹ����������ķ���
	}
}