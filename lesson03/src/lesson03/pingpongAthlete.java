package lesson03;

public class pingpongAthlete extends athlete implements studyEnglish{
	//乒乓球运动员继承运动员抽象类，并且要重写抽象方法
	void Atype() {
		System.out.println("我是乒乓球运动员");
	}
	public void SEnglish() {
		System.out.println("乒乓球运动员学习了英语");
	}

	pingpongAthlete(){
		Atype();
		SEnglish();
	}
}
