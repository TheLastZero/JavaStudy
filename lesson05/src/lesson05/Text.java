package lesson05;

import java.util.ArrayList;

public class Text {
	public static void main(String[] args) {
		ArrayList<Book> book=new ArrayList<Book>();
		
		Book a=new Book("����","�ҳ�������",56);
		Book b=new Book("Ф���˵ľ���","δ֪",78);
		Book c=new Book("�ǳ���","�ҳ�������",36);
		Book d=new Book("�����ط���","����",34);
		
		book.add(a);
		book.add(b);
		book.add(c);
		book.add(d);
//		System.out.println(book.get(0).getAuther()+book.get(0).getName()+book.get(0).getPrice());
//		System.out.println(book.get(1).getAuther()+book.get(1).getName()+book.get(1).getPrice());
//		
		for (int i = 0; i < book.size(); i++) {
			System.out.println(book.get(i).getAuther()+","+book.get(i).getName()+","+book.get(i).getPrice());
			
		}
		System.out.println(book);
		
		
		
		for(int i=0;i<book.size();i++){
			System.out.println(book.get(i));
		}
	}
}
