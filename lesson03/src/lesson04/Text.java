package lesson04;

import java.util.Scanner;

/**
 * 4.��Java����������³����� ��һ�����ˣ�Master�ࣩ��
 * ��������ֻ���Pet�ࣩ��
 * һֻ�����ǹ���Dog�ࣩ�����ֽС����ơ���
 * ��һֻ������è��Cat�ࣩ�����ֽС�С������
 * ����������ʳ�Food�ࣩ��
 * �ֱ��ǹ�ͷ��Bone�����㣨Fish����
 * ���˷ֱ����ֻ����ιʳ.
 * @author Administrator
 *
 */
public class Text {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Master m=new Master();
		System.out.println("�����ֻ���ﶼ���ˣ���Ҫιʳè�����ǹ�");
		System.out.println("1��è       2����");
		int n=scan.nextInt();
		if(n==1){//ιè
			System.out.println("1��ι��ͷ       2��ι��    3��ι����");
			int n1=scan.nextInt();
			if(n1==1){
				m.feedCat(1);
			}else if(n1==2){
				m.feedCat(2);
			}else if(n1==3){
				m.feedCat(3);
			}else{
				System.out.println("û�б��ѡ����Ŷ");
			}
			
		}else if(n==2){//ι��
			System.out.println("1��ι��ͷ       2��ι��    3��ι����");
			int n1=scan.nextInt();
			if(n1==1){
				m.feedDog(1);;
			}else if(n1==2){
				m.feedDog(2);
			}else if(n1==3){
				m.feedDog(3);
			}else{
				System.out.println("û�б��ѡ����Ŷ");
			}
		}else{
			System.out.println("�ף���û�б�ĳ�����Ŷ");
		}
	}
}
