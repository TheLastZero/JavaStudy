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
		if(b.equals("名字")){
			return "名字是:"+this.getName();
		}else if(b.equals("年龄")){
			return "年龄是:"+this.getAge();
		}else if(b.equals("性别")){
			return "性别是:"+this.sex;
		}
		return "返回你妹夫";
	}
}
