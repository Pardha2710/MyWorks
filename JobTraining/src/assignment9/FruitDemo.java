package assignment9;

abstract class Fruit
{
	abstract void cost();
}

class Apple extends Fruit
{
	int cost=5;
	String color;

	@Override
	void cost() {
		
		color="Red";
		System.out.println("Cost of Apple is :$"+cost);
		System.out.println("Color of Apple is: "+color);
		
	}
	
	
}

class Mango extends Fruit
{
	int cost=4;
	String color;
	@Override
	void cost() {
		color="Yellow";
		System.out.println("Cost of Mango is :$"+cost);
		System.out.println("Color of Mango is: "+color);
		
	}
	
}

public class FruitDemo {

	public static void main(String[] args) {
		Fruit apple=new Apple();
		Fruit mango=new Mango();	
		apple.cost();
		mango.cost();
		
		

	}

}
