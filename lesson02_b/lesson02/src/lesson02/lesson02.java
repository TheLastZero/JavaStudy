package lesson02;

import java.util.Calendar;
import java.util.Date;

public class lesson02 {
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		c.set(1997,3,20);
		
		System.out.println(c.get(Calendar.DAY_OF_YEAR));//那一年的第几天
		System.out.println(c.get(Calendar.WEEK_OF_MONTH));//那个月的第几周
		System.out.println(c.get(Calendar.DAY_OF_WEEK));//那周的第几天
		System.out.println(c.get(Calendar.WEEK_OF_YEAR));//那年的第几周
		System.out.println(c.get(Calendar.MONTH));//月份
		
		Date d=c.getTime();
		System.out.println(d);
	}
}
