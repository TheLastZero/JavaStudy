package lesson03;

public class Apple implements USB{

	
	public void write() {
		System.out.println("苹果设备正在使用USB的写入接口");
		
	}

	
	public void read() {
		System.out.println("苹果设备正在使用USB的读取接口");
		
	}
	
}
