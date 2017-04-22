import java.util.Random;

/**
 * 多态练习俄罗斯方块框架
 * @author 小钢炮-ST-PRO
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
		fk.bx();//利用多态从父类调用子类的方法
	}
}