package lesson04;

public class Dog extends pet{
	void Ptype(){
		System.out.println("����һֻ�ɰ���С����,�ҽ�����");
	}
	void eat(String food){
		Ptype();
		if(food.equals("Bone")){
			System.out.println("�ð������й�ͷ��");
		}else if(food.equals("Fish")){
			System.out.println("��Ȼ��Ҳ���㣬�����Ҹ�ϲ���Թ�ͷ߹");
		}else{
			System.out.println("�ⶫ���ܳ���");
		}
	}
}
