package assignment7;

public class Instances
{

	static int count=0;
 	Instances()
	{
		count++;
	}
	public static void main(String args[])
	{
		Instances in1=new Instances();
		Instances in2=new Instances();
		System.out.println("Number of Instances Created:"+count);
	}

}