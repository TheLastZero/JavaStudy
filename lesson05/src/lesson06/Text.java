package lesson06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Text {
	public static void main(String[] args) {
		
		Text t=new Text();
		ArrayList<Students> one=t.getNameALL();
		
		LinkedList<Students> two=t.getAgeAll();
		
		
		//传入年龄，性别，名字，可得到学生类集合中分开的学生年龄，性别，名字信息
		t.iterator(one,"名字");
//		t.iterator(one,"年龄");
//		t.iterator(one,"性别");
		
	}
	
	ArrayList<Students> getNameALL(){
		ArrayList<Students> one=new ArrayList();
		
		Students a=new Students("巴洛克", 20,"男");
		Students b=new Students("熊大", 15,"公");
		Students c=new Students("舞法天女", 20,"未知");
		
		one.add(a);
		one.add(b);
		one.add(c);
		
		
		return one;
	}
	
	LinkedList<Students> getAgeAll(){
		LinkedList<Students> one=new LinkedList<Students>();
		
		Students a=new Students("巴洛克", 20,"男");
		Students b=new Students("熊大", 15,"公");
		Students c=new Students("舞法天女", 20,"未知");
		
		one.add(a);
		one.add(b);
		one.add(c);
		
		return one;
	}
	
	void iterator(Collection<Students> a,String b){//迭代器
		Iterator i=a.iterator();
			while(i.hasNext()){
				Object i1=i.next();
				Students q=(Students)i1;
				
				System.out.println(q.toString(b));
			}
		}
}
