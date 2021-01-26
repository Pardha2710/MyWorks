package assignment9;

interface Fruit1
{
	void cost();
	default void type()
	{
		System.out.println("Fruit Family!");
	}
}

class Apple1 implements Fruit1
{

	int cost=5;
	String color;
	@Override
	public void cost() {
		color="Red";
		System.out.println("Cost of Apple is :$"+cost);
		System.out.println("Color of Apple is: "+color);	
	}
	
	void grow()
	{
		System.out.println("Grows in Winter Season!");
	}
	
}

class Mango1 implements Fruit1
{
	int cost=4;
	String color;
	@Override
	public void cost() {
		color="Yellow";
		System.out.println("Cost of Mango is :$"+cost);
		System.out.println("Color of Mango is: "+color);	
	}
	void season()
	{
		System.out.println("Grows in Summer Season!");
	}
}

public class FruitInterface {

	public static void main(String[] args) {
		
		Fruit1 apple1=new Apple1();
		Fruit1 mango1=new Mango1();	
		
		apple1.cost();
		mango1.cost();
		apple1.type();
		
		Apple1 ap=new Apple1();
		Mango1 mn=new Mango1();
		
		ap.grow();
		mn.season();
		
		
	}

}
