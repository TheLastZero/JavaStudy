package lesson03;

public class pingpongAthlete extends athlete implements studyEnglish{
	//ƹ�����˶�Ա�̳��˶�Ա�����࣬����Ҫ��д���󷽷�
	void Atype() {
		System.out.println("����ƹ�����˶�Ա");
	}
	public void SEnglish() {
		System.out.println("ƹ�����˶�Աѧϰ��Ӣ��");
	}

	pingpongAthlete(){
		Atype();
		SEnglish();
	}
}
