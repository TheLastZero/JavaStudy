package lesson01;
/**
 * 1.写出一个类People，并由该类做基类派生出子类Employee和Teacher。
 * 其中People 类具有name、age两个保护成员变量，分别为String,int，
 * 且具有公有的getAge成员方法，用于返回age变量的值。
 * Employee类具有保护成员变量empno,Teacher类有teach成员方法。分别测试
 * @author Administrator
 *
 */
public class People {
	protected String name;
	protected int age;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	People(){
		
	}
	People(String name,int age){
		this.name=name;
		this.age=age;
	}
	void GetAge(){
		System.out.println(this.age);
	}
}
