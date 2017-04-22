package lesson01;

public class Teacher extends People{
	Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}
	void teacher(){
		System.out.println("老师在教书");
	}
}
