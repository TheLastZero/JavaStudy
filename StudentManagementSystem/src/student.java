
public class student {
	private int num;
	private String name;
	private int age;
	private int java;
	private int c;
	private int html;
	private int sql;
	private int sum;
	private int avg;
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return this.java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getC() {
		return this.c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getHtml() {
		return this.html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getSql() {
		return this.sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getSum() {
		return this.sum;
	}
	public void setSum() {
		this.sum =getJava()+getC()+getHtml()+getSql();
	}
	public int getAvg() {
		return this.avg;
	}
	public void setAvg() {
		this.avg = sum/4;
	}
	public String toString(){
		return "\t"+getNum()+"\t"+getName()+"\t"+getAge()
		+"\t"+getJava()+"\t"+getC()+"\t"+getHtml()+"\t"+getSql()
		+"\t"+getSum()+"\t"+getAvg();
	}
}