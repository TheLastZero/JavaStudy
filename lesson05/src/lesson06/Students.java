package lesson06;

public class Students {
	private String name;
	private int age;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	Students(String name,int age,String sex){
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
	}
	
	
	public String toString(String b){
		if(b.equals("����")){
			return "������:"+this.getName();
		}else if(b.equals("����")){
			return "������:"+this.getAge();
		}else if(b.equals("�Ա�")){
			return "�Ա���:"+this.sex;
		}
		return "�������÷�";
	}
}
