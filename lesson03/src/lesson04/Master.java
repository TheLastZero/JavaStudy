package lesson04;
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
public class Master {//������
	void feedCat(int n1){
		Cat c=new Cat();
		if(n1==1){//1����ι��ͷ
			c.eat(giveBone());
		}else if(n1==2){//2����ι��
			c.eat(giveFish());
		}else{
			c.eat("����");
		}
	}
	void feedDog(int n2){
		Dog d=new Dog();
		if(n2==1){//1����ι��ͷ
			d.eat(giveBone());
		}else if(n2==2){//2����ι��
			d.eat(giveFish());
		}else{
			d.eat("����");
		}
	}
	
	String giveBone(){
		Bone b=new Bone();
		return b.name;
	}
	String giveFish(){
		Fish f=new Fish();
		return f.name;
	}
}
