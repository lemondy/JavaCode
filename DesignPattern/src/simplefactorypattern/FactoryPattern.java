package simplefactorypattern;

//简单共产方法，使用静态的方法生成对象
//工厂类，在工厂中进行批量的生产

//此种工厂，当增加一种新的面包的时候，会修改下面的工厂类，增加新的面包类，修改客户端代码
public class FactoryPattern {
	//生成产生面包的对象，生成面包
	public static BreadMaker makeBread(int breadType){
		BreadMaker bmake = null;
		//选择面包的类型
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
