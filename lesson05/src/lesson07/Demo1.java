package lesson07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		HashMap<Integer,String> mp1=new HashMap<Integer,String>();
		
		mp1.put(1,"ţħ��");
		mp1.put(27,"̫���Ͼ�");
		mp1.put(39,"�캢��");
		
		Set r1=mp1.keySet();//��ü���
		
		Collection r2=mp1.values();//���ֵ��
		
		Set r3=mp1.entrySet();//�������ӳ���ϵ��Collection��ͼ
			
		Demo1 a=new Demo1();
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		a.Iterator(r1);
		a.Iterator(r2);
		a.Iterator(r3);
	}
	
	void Iterator(Collection a){//��һ��������
		Iterator i=a.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
