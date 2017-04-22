package lesson03;

public class BasketballAthlete extends athlete{
	//篮球运动员继承运动员抽象类，并且要重写抽象方法
	void Atype(){
		System.out.println("我是篮球运动员");
	} 
	BasketballAthlete(){
		Atype();
	}
}
