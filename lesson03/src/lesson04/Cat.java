package lesson04;

public class Cat extends pet{
	void Ptype(){
		System.out.println("����һֻ��С��������");
	}
	void eat(String food){
		Ptype();
		if(food.equals("Fish")){
			System.out.println("�ð����������");
		}else if(food.equals("Bone")){
			System.out.println("�ߣ���ôӲ�Ĺ�ͷ�ҲŲ���");
		}else{
			System.out.println("�ⶫ���ܳ���");
		}
	}
}
