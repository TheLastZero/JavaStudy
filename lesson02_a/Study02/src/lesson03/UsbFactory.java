package lesson03;

public class UsbFactory{//������
	UsbFactory(){
		
	}
	UsbFactory(String a){
		if(a.equals("Apple")){
			Apple b=new Apple();
			System.out.println("���ڴ���ƻ���豸");
			b.write();
			b.read();
		}else if(a.equals("Kingston")){
			Kingston b=new Kingston();
			System.out.println("���ڴ�����ʿ���豸");
			b.write();
			b.read();
		}
	}
}
