package lesson04;

public class Cat extends pet{
	void Ptype(){
		System.out.println("我是一只叫小花的喵咪");
	}
	void eat(String food){
		Ptype();
		if(food.equals("Fish")){
			System.out.println("好棒啊，有鱼吃");
		}else if(food.equals("Bone")){
			System.out.println("哼，这么硬的骨头我才不吃");
		}else{
			System.out.println("这东西能吃嘛");
		}
	}
}
