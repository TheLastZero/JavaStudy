package lesson04;

import java.util.Scanner;

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
public class Text {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Master m=new Master();
		System.out.println("你的两只宠物都饿了，你要喂食猫，还是狗");
		System.out.println("1、猫       2、狗");
		int n=scan.nextInt();
		if(n==1){//喂猫
			System.out.println("1、喂骨头       2、喂鱼    3、喂垃圾");
			int n1=scan.nextInt();
			if(n1==1){
				m.feedCat(1);
			}else if(n1==2){
				m.feedCat(2);
			}else if(n1==3){
				m.feedCat(3);
			}else{
				System.out.println("没有别的选择了哦");
			}
			
		}else if(n==2){//喂狗
			System.out.println("1、喂骨头       2、喂鱼    3、喂垃圾");
			int n1=scan.nextInt();
			if(n1==1){
				m.feedDog(1);;
			}else if(n1==2){
				m.feedDog(2);
			}else if(n1==3){
				m.feedDog(3);
			}else{
				System.out.println("没有别的选择了哦");
			}
		}else{
			System.out.println("亲，里没有别的宠物了哦");
		}
	}
}
