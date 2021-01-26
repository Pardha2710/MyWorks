package assignment3;

import java.util.Scanner;

public class Smallest {

	//Find smallest of given 10 numbers
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=1;
		int temp=0,value=0;
		do {
			System.out.println("Enter Number "+i+":");
			value=s.nextInt();
			if(temp>value)
			{
				temp=value;
			}
			System.out.println(temp+" "+value);
			i++;
		}while(i<=10);
		
		System.out.println("The smallest number among given 10 numbers is:"+temp);
	}

}
