package simplefactorypattern;

//�ͻ��ˣ��˿�ȥ����������
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		System.out.println("����꿪��");
		
		System.out.println("�˿�Ҫ�����");
		breadMaker = FactoryPattern.makeBread(1);
		breadMaker.getBread();
		
		System.out.println("�˿���Ҫ�������");
		breadMaker = FactoryPattern.makeBread(2);
		breadMaker.getBread();
		
		System.out.println("�˿���Ҫ�����");
		breadMaker = FactoryPattern.makeBread(3);
		breadMaker.getBread();
	}
}
