package assignment5;

import java.util.Scanner;

public class DiagonalSum {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n1[][]=new int[3][3];
		int sum=0;
		System.out.println("Enter 9 elements of the array:");
		for(int i=0;i<n1.length;i++)
		{
			for(int j=0;j<n1[i].length;j++)
			{
				n1[i][j]=s.nextInt();
			}
		}
		for(int i=0;i<n1.length;i++)
		{
			for(int j=0;j<n1[i].length;j++)
			{
				if(i==j)
				{
					sum=sum+n1[i][j];
				}
			}
		}
		System.out.println("Sum of Principal Diagonal Elements:"+sum);
	}

}
