package assignment3;

import java.util.Scanner;

public class SumofDigits {

	//Sum of all digits in the given number
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number to find the sum of digits:");
		int number=s.nextInt();
		int sum=0;
		while(number>0)
		{
			sum=sum+(number%10);
			number=number/10;
		}
		System.out.println("Sum of digites is:"+sum);
		

	}

}
