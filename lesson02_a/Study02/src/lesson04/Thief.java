package lesson04;

import java.util.Random;

/**
 * 判断小偷是否进来了的类
 * @author Administrator
 *
 */
public class Thief {
	Thief(){
		boolean i=new Random().nextBoolean();
		if(i){//i为true表示有小偷进来
			Door a=new Door();
			System.out.println("小偷来了");
			a.alarm();
			a.light();
		}else{//i为false表示没有小偷
			System.out.println("家里安全没有小偷");
		}
	}
}
