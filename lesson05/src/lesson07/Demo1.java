package lesson07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		HashMap<Integer,String> mp1=new HashMap<Integer,String>();
		
		mp1.put(1,"牛魔王");
		mp1.put(27,"太上老君");
		mp1.put(39,"红孩儿");
		
		Set r1=mp1.keySet();//获得键集
		
		Collection r2=mp1.values();//获得值集
		
		Set r3=mp1.entrySet();//获得所有映射关系的Collection视图
			
		Demo1 a=new Demo1();
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		a.Iterator(r1);
		a.Iterator(r2);
		a.Iterator(r3);
	}
	
	void Iterator(Collection a){//做一个迭代器
		Iterator i=a.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
