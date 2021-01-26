package assignment5;

import java.util.Scanner;

public class MatricesSum {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n1[][]=new int[3][3];
		int n2[][]=new int[3][3];
		int reuslt[][]=new int[3][3];
		System.out.println("Enter 9 elements of the 1st array:");
		for(int i=0;i<n1.length;i++)
		{
			for(int j=0;j<n1[i].length;j++)
			{
				n1[i][j]=s.nextInt();
			}
		}
		
		System.out.println("Enter 9 elements of the 2nd array:");
		for(int i=0;i<n2.length;i++)
		{
			for(int j=0;j<n2[i].length;j++)
			{
				n2[i][j]=s.nextInt();
			}
		}
		System.out.println("Sum of two 3X3 matrices:");
		for(int i=0;i<reuslt.length;i++)
		{
			for(int j=0;j<reuslt[i].length;j++)
			{
				reuslt[i][j]=n1[i][j]+n2[i][j];
				System.out.print(reuslt[i][j]+" ");
			}
			System.out.println();
		}
	}

}
