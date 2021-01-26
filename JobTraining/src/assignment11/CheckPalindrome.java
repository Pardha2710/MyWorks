package assignment11;

import java.util.Scanner;

public class CheckPalindrome {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter a name to check for the Palindrome:");
		String input=s.next();
		String reverse = "";
		for(int i=input.length()-1;i>=0;i--)
		{
			reverse=reverse+input.charAt(i);
		}
		System.out.println(reverse);
		
		if(input.equalsIgnoreCase(reverse))
		{
			System.out.println("The Given String is a Palindrome!");
		}
		else
		{
			System.out.println("The Given String is not a Palindrome!");
		}
	}

}
