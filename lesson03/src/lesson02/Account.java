package lesson02;
/**
 * дһ���˻���(Account), ����: id:�˻����룬password:�˻�����name:��ʵ������
 * personId:���֤�����ַ������ͣ�
 * email:�ͻ��ĵ������䣬
 * balance:�˻�����:
 * deposit: ����,������double�͵Ľ��
 * withdraw:ȡ���,������double�͵Ľ��
 * @author Administrator
 *
 */
public class Account {//�˻���
	private int userId;
	private int password;
	private String name;
	private int personID;
	private String email;
	private double money;
	
	void balanced(){//�˻�����
		System.out.println("�˻����");
	}
	void deposit(double money){//����,������double�͵Ľ��
		this.money+=money;
	}
	void withdraw(double money){//ȡ���,������double�͵Ľ��
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
