import java.util.*;
public class start_ui {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("������ѧ��������");
		int stu0 = scan.nextInt();
		student stu[] = new student[stu0];
		boolean flag=true;
		while(flag){
			System.out.println("��ѡ��Ҫʹ�õĹ���");
			System.out.println("1�����һ��ѧ��");
			System.out.println("2������һ��ѧ��");
			System.out.println("3������ѧ�������������ѧ�����ųɼ�");
			System.out.println("4������ѧ�����ɾ��ѧ��");
			System.out.println("5�����ݱ�Ÿ���ѧ��������Ϣ");
			System.out.println("6������ĳ�ųɼ���������");
			System.out.println("7�������ֽܷ�������");
			System.out.println("8���˳�ϵͳ");
			System.out.println("00������ϵͳ�������");
			String select =scan.next();
			if(select.equals("1")){
				System.out.println("����ӱ��");
				int num = scan.nextInt();
				System.out.println("���������");
				String name=scan.next();
				System.out.println("����������");
				int age = scan.nextInt();
				method.add(num,name,age,stu);
			}else if(select.equals("2")){
				System.out.println("��������Ҫ����ѧ��������");
				String name = scan.next();
				method.find(name,stu);
			}else if(select.equals("3")){
				System.out.println("������ѧ���ı��");
				int num = scan.nextInt();
				System.out.println("������Java�ĳɼ�");
				int java=scan.nextInt();
				System.out.println("����C#�ĳɼ�");
				int c=scan.nextInt();
				System.out.println("������HTML�ĳɼ�");
				int html=scan.nextInt();
				System.out.println("������SQL�ĳɼ�");
				int sql=scan.nextInt();
				method.updata(num,java,c,html,sql,stu);

			}else if(select.equals("4")){
				System.out.println("������ѧ���ı��");
				int num = scan.nextInt();
				method.delete(num,stu);
			}else if(select.equals("5")){
				System.out.println("������ѧ���ı��");
				int num = scan.nextInt();
				System.out.println("�������޸ĵ�����");
				String name=scan.next();
				System.out.println("�������޸ĵ�����");
				int age = scan.nextInt();
				method.modify(num,name,age,stu);
			}else if(select.equals("6")){
				System.out.println("�����������һ�ųɼ�������");
				System.out.println("1��Java");
				System.out.println("2��C#");
				System.out.println("3��HTML");
				System.out.println("4��SQL");
				int n = scan.nextInt();
				method.sorting(n,stu);
			}else if(select.equals("7")){
				method.arr(stu);

			}else if(select.equals("8")){
				flag=false;
				System.out.println("ϵͳ���˳�");
			}else if(select.equals("00")){
				method.loading(stu);
			}else{
				System.out.println("С��������û�б��ѡ����������");
			}
		}
	}
}