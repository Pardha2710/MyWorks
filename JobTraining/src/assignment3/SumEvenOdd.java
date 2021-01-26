package assignment3;

public class SumEvenOdd {

	//Sum of odd numbers and even number 1-100
	public static void main(String[] args) {
		
		int sumOdd=0,sumEven=0;
		int i=1;
		while(i<=100)
		{
			if(i%2==0)
			{
				sumEven=sumEven+i;
			}
			else
			{
				sumOdd=sumOdd+i;
			}
			i++;
		}
		System.out.println("Sum of 1-100 Even Numbers: "+sumEven);
		System.out.println("Sum of 1-100 Odd Numbers: "+sumOdd);
		
		

	}

}
