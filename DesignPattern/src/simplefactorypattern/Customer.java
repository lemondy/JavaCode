package simplefactorypattern;

//客户端，顾客去面包店买面包
public class Customer {
	public static void main(String[] args){
		BreadMaker breadMaker;
		System.out.println("面包店开张");
		
		System.out.println("顾客要黑面包");
		breadMaker = FactoryPattern.makeBread(1);
		breadMaker.getBread();
		
		System.out.println("顾客需要蜂蜜面包");
		breadMaker = FactoryPattern.makeBread(2);
		breadMaker.getBread();
		
		System.out.println("顾客需要白面包");
		breadMaker = FactoryPattern.makeBread(3);
		breadMaker.getBread();
	}
}
