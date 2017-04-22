package lesson03;
/**
 * 2.接口：创建一个USB接口  
创建 一个Apple类去实现 implements接口
创建一个Kingston类去实现implements 接口 
在UsbFactory类中，静态方法createUsb()通过接收并对比字符串参数type的值，
 * 来决定创建什么样的usb兼容元件，如果传递过来的是“kingston”，则创建金士顿u盘，
 * 如果传递的是“apple”，则创建苹果mp3，如果什么也没有传递，那么不创建任何对象，并报告错误
 
 * @author Administrator
 *
 */
public class Text {
	public static void main(String[] args) {
		UsbFactory a=new UsbFactory("Apple");
		UsbFactory b=new UsbFactory("Kingston");
	}
}
