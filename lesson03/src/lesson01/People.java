package lesson01;
/**
 * 1.д��һ����People�����ɸ�������������������Employee��Teacher��
 * ����People �����name��age����������Ա�������ֱ�ΪString,int��
 * �Ҿ��й��е�getAge��Ա���������ڷ���age������ֵ��
 * Employee����б�����Ա����empno,Teacher����teach��Ա�������ֱ����
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
