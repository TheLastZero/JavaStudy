import java.util.Random;

public class method {
	public static void head(){
		System.out.println("\t���\t����\t����\tJava\tC#\tHTML"
				+ "\tSQL\t�ܷ�\tƽ����");
	}
	//�����Ǳ���ѧ������ķ���
	public static void look(student[] stu){
		head();
		for(int i=0;i<stu.length;i++){
			if(stu[i]!=null){
				System.out.println(stu[i]);
			}
		}
	}
	//�������ѧ���ķ���
	public static void add(int num, String name,
			int age, student[] stu) {
		for(int i=0;i<stu.length;i++){
			if(stu[i]==null){
				stu[i]= new student();//ÿ�����ѧ��������һ���µĶ���
				stu[i].setNum(num);
				stu[i].setName(name);
				stu[i].setAge(age);
				System.out.println("��ӳɹ�");
				look(stu);
				return;
			}
		}
		System.out.println("�����������޷������Ŷ����~~~");
	}

	//������������ѧ���ķ���
	public static void find(String name, student[] stu) {
		head();
		for(int i=0;i<stu.length;i++){
			if(stu[i]!=null&&stu[i].getName().equals(name)){
				System.out.println(stu[i]);
			}
		}
	}

	//���ݱ�Ÿ���ѧ���ɼ�
	public static void updata(int num, int java, int c,
			int html, int sql, student[] stu) {
		for(int i=0;i<stu.length;i++){
			if(stu[i].getNum()==num){
				stu[i].setJava(java);
				stu[i].setC(c);
				stu[i].setHtml(html);
				stu[i].setSql(sql);
				stu[i].setSum();
				stu[i].setAvg();
				look(stu);
				return;
			}
		}
		System.out.println("�ף������Ų�����Ŷ~~~");
	}

	//���ݱ����ɾ��ѧ��
	public static void delete(int num, student[] stu) {
		for(int i=0;i<stu.length;i++){
			if(stu[i].getNum()==num){
				stu[i]=null;
				student stu1;
				break;
			}
		}
		for(int i=0;i<stu.length;i++){
			if(stu[i]==null){
				if(i!=stu.length-1){
					stu[i]=stu[i+1];
					stu[i+1]=null;
				}
			}
		}
		System.out.println("ɾ���ɹ�");
		look(stu);
	}

	//�޸�ѧ���Ļ�����Ϣ
	public static void modify(int num, String name,
			int age, student[] stu) {
		for(int i=0;i<stu.length;i++){
			if(num==stu[i].getNum()){
				stu[i].setName(name);
				stu[i].setAge(age);
				look(stu);
				System.out.println("�޸ĳɹ�");
				return;
			}
		}
		System.out.println("��������������û����ӹ������Ű�");
	}

	//���ճɼ�����ķ���
	public static void sorting(int n, student[] stu) {
		//�ж�������鲻Ϊnull��ֵ�ж��ٸ�
		int j=0;
		for(;j<stu.length;){
			if(stu[j]!=null){
				j++;
			}
		}
		if(n==1){
			for(;j>1;j--){
				for(int i=0;i<stu.length-1;i++){
					if(stu[i].getJava()<stu[i+1].getJava()){
						student stu2;
						stu2=stu[i];
						stu[i]=stu[i+1];
						stu[i+1]=stu2;
					}
				}
			}
			System.out.println("����Java�ɼ���������������");
		}else if(n==2){
			for(;j>1;j--){
				for(int i=0;i<stu.length-1;i++){
					if(stu[i].getC()<stu[i+1].getC()){
						student stu2;
						stu2=stu[i];
						stu[i]=stu[i+1];
						stu[i+1]=stu2;
					}
				}
			}
			System.out.println("����C#�ɼ���������������");
		}else if(n==3){
			for(;j>1;j--){
				for(int i=0;i<stu.length-1;i++){
					if(stu[i].getHtml()<stu[i+1].getHtml()){
						student stu2;
						stu2=stu[i];
						stu[i]=stu[i+1];
						stu[i+1]=stu2;
					}
				}
			}
			System.out.println("����HTML�ɼ���������������");
		}else if(n==4){
			for(;j>1;j--){
				for(int i=0;i<stu.length-1;i++){
					if(stu[i].getSql()<stu[i+1].getSql()){
						student stu2;
						stu2=stu[i];
						stu[i]=stu[i+1];
						stu[i+1]=stu2;
					}
				}
			}
			System.out.println("����SQL�ɼ���������������");
		}else{
			System.out.println("û�б�Ŀ���Ŷ");
		}
		look(stu);
	}

	//���ܷ�����
	public static void arr(student[] stu) {
		//�ж�������鲻Ϊnull��ֵ�ж��ٸ�
		int j=0;
		for(;j<stu.length;){
			if(stu[j]!=null){
				j++;
			}
		}
		for(;j>1;j--){
			for(int i=0;i<stu.length-1;i++){
				if(stu[i].getSum()<stu[i+1].getSum()){
					student stu2;
					stu2=stu[i];
					stu[i]=stu[i+1];
					stu[i+1]=stu2;
				}
			}
		}
		look(stu);
		System.out.println("�����ܳɼ���������������");
	}
	//����������������ݵ��߼�
	public static void loading(student[] stu) {
		for(int i=0;i<stu.length;i++){
			stu[i] = new student();
			if(stu[i]!=null){
				stu[i].setNum(i+1);
				stu[i].setName(randomname());
				stu[i].setAge(randomage());
				stu[i].setJava(randomscores());
				stu[i].setC(randomscores());
				stu[i].setHtml(randomscores());
				stu[i].setSql(randomscores());
				stu[i].setSum();
				stu[i].setAvg();
			}
		}
		look(stu);
	}
	
	static int randomage(){//�����������
		int n = new Random().nextInt(35)+15;
		return n;
	}
	static int randomscores(){
		int n = new Random().nextInt(150);
		return n;
	}
	static String randomname(){//������е���������ֵ��߼�
		int n = new Random().nextInt(5);
		String name=null;
		if(n==0){
			return rname()+rname()+rname();
		}else if(n==1){
			return rname()+rname()+rname()+rname();
		}else if(n==2){
			return rname()+rname()+rname()+rname()+rname();
		}else if(n==3){
			return rname()+rname()+rname()+rname()+rname()+rname();
		}else if(n==4){
			return rname()+rname()+rname()+rname()+rname()+rname()
			+rname();
		}else if(n==5){
			return rname()+rname()+rname()+rname()+rname()+rname()
			+rname()+rname();
		}
		return rname()+rname()+rname();
	}
	static String rname(){//�������������ֵ��߼�
		int n = new Random().nextInt(25);
		if(n==0){
			return "a";
		}else if(n==1){
			return "b";
		}else if(n==2){
			return "c";
		}
		else if(n==3){
			return "d";
		}
		else if(n==4){
			return "e";
		}
		else if(n==5){
			return "f";
		}
		else if(n==6){
			return "g";
		}
		else if(n==7){
			return "h";
		}
		else if(n==8){
			return "i";
		}
		else if(n==9){
			return "j";
		}
		else if(n==10){
			return "k";
		}
		else if(n==11){
			return "l";
		}
		else if(n==12){
			return "m";
		}
		else if(n==13){
			return "n";
		}
		else if(n==14){
			return "o";
		}
		else if(n==15){
			return "p";
		}else if(n==16){
			return "q";
		}
		else if(n==17){
			return "r";
		}else if(n==18){
			return "s";
		}else if(n==19){
			return "t";
		}else if(n==20){
			return "u";
		}else if(n==21){
			return "v";
		}else if(n==22){
			return "w";
		}else if(n==23){
			return "x";
		}else if(n==24){
			return "y";
		}else if(n==25){
			return "z";
		}
		return "����ʧ��";
	}
}