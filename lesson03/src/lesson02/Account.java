package lesson02;
/**
 * 写一个账户类(Account), 属性: id:账户号码，password:账户密码name:真实姓名，
 * personId:身份证号码字符串类型，
 * email:客户的电子邮箱，
 * balance:账户余额方法:
 * deposit: 存款方法,参数是double型的金额
 * withdraw:取款方法,参数是double型的金额
 * @author Administrator
 *
 */
public class Account {//账户类
	private int userId;
	private int password;
	private String name;
	private int personID;
	private String email;
	private double money;
	
	void balanced(){//账户余额方法
		System.out.println("账户余额");
	}
	void deposit(double money){//存款方法,参数是double型的金额
		this.money+=money;
	}
	void withdraw(double money){//取款方法,参数是double型的金额
		this.money-=money;
	}
	
	Account(){
		
	}
	Account(String name,int userId,int password,int personID){
		
	}
	public static void main(String[] args) {
		Account a=new Account();
	}
}
