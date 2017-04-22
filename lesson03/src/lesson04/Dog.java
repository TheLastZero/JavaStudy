package lesson04;

public class Dog extends pet{
	void Ptype(){
		System.out.println("我是一只可爱的小狗狗,我叫旺财");
	}
	void eat(String food){
		Ptype();
		if(food.equals("Bone")){
			System.out.println("好棒啊，有骨头吃");
		}else if(food.equals("Fish")){
			System.out.println("虽然我也吃鱼，但是我更喜欢吃骨头吖");
		}else{
			System.out.println("这东西能吃嘛");
		}
	}
}
