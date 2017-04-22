package lesson03;

public class UsbFactory{//工厂类
	UsbFactory(){
		
	}
	UsbFactory(String a){
		if(a.equals("Apple")){
			Apple b=new Apple();
			System.out.println("正在创建苹果设备");
			b.write();
			b.read();
		}else if(a.equals("Kingston")){
			Kingston b=new Kingston();
			System.out.println("正在创建金士顿设备");
			b.write();
			b.read();
		}
	}
}
