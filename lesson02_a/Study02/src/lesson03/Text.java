package lesson03;
/**
 * 2.�ӿڣ�����һ��USB�ӿ�  
���� һ��Apple��ȥʵ�� implements�ӿ�
����һ��Kingston��ȥʵ��implements �ӿ� 
��UsbFactory���У���̬����createUsb()ͨ�����ղ��Ա��ַ�������type��ֵ��
 * ����������ʲô����usb����Ԫ����������ݹ������ǡ�kingston�����򴴽���ʿ��u�̣�
 * ������ݵ��ǡ�apple�����򴴽�ƻ��mp3�����ʲôҲû�д��ݣ���ô�������κζ��󣬲��������
 
 * @author Administrator
 *
 */
public class Text {
	public static void main(String[] args) {
		UsbFactory a=new UsbFactory("Apple");
		UsbFactory b=new UsbFactory("Kingston");
	}
}
