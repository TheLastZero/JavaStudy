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
		
		
		//�������䣬�Ա����֣��ɵõ�ѧ���༯���зֿ���ѧ�����䣬�Ա�������Ϣ
		t.iterator(one,"����");
//		t.iterator(one,"����");
//		t.iterator(one,"�Ա�");
		
	}
	
	ArrayList<Students> getNameALL(){
		ArrayList<Students> one=new ArrayList();
		
		Students a=new Students("�����", 20,"��");
		Students b=new Students("�ܴ�", 15,"��");
		Students c=new Students("�跨��Ů", 20,"δ֪");
		
		one.add(a);
		one.add(b);
		one.add(c);
		
		
		return one;
	}
	
	LinkedList<Students> getAgeAll(){
		LinkedList<Students> one=new LinkedList<Students>();
		
		Students a=new Students("�����", 20,"��");
		Students b=new Students("�ܴ�", 15,"��");
		Students c=new Students("�跨��Ů", 20,"δ֪");
		
		one.add(a);
		one.add(b);
		one.add(c);
		
		return one;
	}
	
	void iterator(Collection<Students> a,String b){//������
		Iterator i=a.iterator();
			while(i.hasNext()){
				Object i1=i.next();
				Students q=(Students)i1;
				
				System.out.println(q.toString(b));
			}
		}
}
