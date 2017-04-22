import java.util.*;
public class start_ui {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生的人数");
		int stu0 = scan.nextInt();
		student stu[] = new student[stu0];
		boolean flag=true;
		while(flag){
			System.out.println("请选择要使用的功能");
			System.out.println("1、添加一个学生");
			System.out.println("2、查找一个学生");
			System.out.println("3、根据学生编号输入或更改学生各门成绩");
			System.out.println("4、根据学生编号删除学生");
			System.out.println("5、根据编号更改学生基本信息");
			System.out.println("6、根据某门成绩进行排序");
			System.out.println("7、根据总分进行排序");
			System.out.println("8、退出系统");
			System.out.println("00、载入系统随机数据");
			String select =scan.next();
			if(select.equals("1")){
				System.out.println("请添加编号");
				int num = scan.nextInt();
				System.out.println("请添加名字");
				String name=scan.next();
				System.out.println("请输入年龄");
				int age = scan.nextInt();
				method.add(num,name,age,stu);
			}else if(select.equals("2")){
				System.out.println("请输入想要查找学生的名字");
				String name = scan.next();
				method.find(name,stu);
			}else if(select.equals("3")){
				System.out.println("请输入学生的编号");
				int num = scan.nextInt();
				System.out.println("请输入Java的成绩");
				int java=scan.nextInt();
				System.out.println("请输C#的成绩");
				int c=scan.nextInt();
				System.out.println("请输入HTML的成绩");
				int html=scan.nextInt();
				System.out.println("请输入SQL的成绩");
				int sql=scan.nextInt();
				method.updata(num,java,c,html,sql,stu);

			}else if(select.equals("4")){
				System.out.println("请输入学生的编号");
				int num = scan.nextInt();
				method.delete(num,stu);
			}else if(select.equals("5")){
				System.out.println("请输入学生的编号");
				int num = scan.nextInt();
				System.out.println("请输入修改的名字");
				String name=scan.next();
				System.out.println("请输入修改的年龄");
				int age = scan.nextInt();
				method.modify(num,name,age,stu);
			}else if(select.equals("6")){
				System.out.println("请问想根据哪一门成绩来排序");
				System.out.println("1、Java");
				System.out.println("2、C#");
				System.out.println("3、HTML");
				System.out.println("4、SQL");
				int n = scan.nextInt();
				method.sorting(n,stu);
			}else if(select.equals("7")){
				method.arr(stu);

			}else if(select.equals("8")){
				flag=false;
				System.out.println("系统已退出");
			}else if(select.equals("00")){
				method.loading(stu);
			}else{
				System.out.println("小淘气，你没有别的选择啦！！！");
			}
		}
	}
}