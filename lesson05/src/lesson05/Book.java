package lesson05;

public class Book {
	private String name;
	private double price;
	private String auther;//作者
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Book(String name,String auther,double price){
		this.setName(name);
		this.setAuther(auther);
		this.setPrice(price);
	}
	
	public String toString(){
		return "书名是："+this.getName()+"\t"+"作者是:"+this.getAuther()+"\t"+"价格是："+this.getPrice();
	}
}
