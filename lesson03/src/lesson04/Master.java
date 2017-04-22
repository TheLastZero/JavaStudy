package lesson04;
/**
 * 4.用Java程序完成以下场景： 有一个主人（Master类），
 * 他养了两只宠物（Pet类），
 * 一只宠物是狗（Dog类），名字叫“旺财”，
 * 另一只宠物是猫（Cat类），名字叫“小花”，
 * 现在有两种食物（Food类），
 * 分别是骨头（Bone）和鱼（Fish）。
 * 主人分别给两只宠物喂食.
 * @author Administrator
 *
 */
public class Master {//主人类
	void feedCat(int n1){
		Cat c=new Cat();
		if(n1==1){//1代表喂骨头
			c.eat(giveBone());
		}else if(n1==2){//2代表喂鱼
			c.eat(giveFish());
		}else{
			c.eat("垃圾");
		}
	}
	void feedDog(int n2){
		Dog d=new Dog();
		if(n2==1){//1代表喂骨头
			d.eat(giveBone());
		}else if(n2==2){//2代表喂鱼
			d.eat(giveFish());
		}else{
			d.eat("垃圾");
		}
	}
	
	String giveBone(){
		Bone b=new Bone();
		return b.name;
	}
	String giveFish(){
		Fish f=new Fish();
		return f.name;
	}
}
