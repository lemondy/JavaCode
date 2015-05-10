package simplefactorypattern;

//�򵥹���������ʹ�þ�̬�ķ������ɶ���
//�����࣬�ڹ����н�������������

//���ֹ�����������һ���µ������ʱ�򣬻��޸�����Ĺ����࣬�����µ�����࣬�޸Ŀͻ��˴���
public class FactoryPattern {
	//���ɲ�������Ķ����������
	public static BreadMaker makeBread(int breadType){
		BreadMaker bmake = null;
		//ѡ�����������
		switch(breadType){
		case 1:
			bmake = new BlackBread();
			break;
		case 2:
			bmake = new HoneyBread();
			break;
		case 3:
			bmake = new WhiteBread();
			break;
			default:
				break;
		}
		return bmake;
	}
}
