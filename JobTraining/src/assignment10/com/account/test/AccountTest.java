package assignment10.com.account.test;

import java.util.Scanner;

import assignment10.com.account.Account;

public class AccountTest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Account account=new Account(100, "SAVINGS", 3500);
		boolean choice=true;
		while(choice)
		{
			System.out.println("1.Deposit\n2.Withdraw\n3.Display Balance\n4.Exit");		
			System.out.println("Please Select from the above options:");
			switch(s.nextInt())
			{
				case 1:
					account.deposit(300);
					break;
				case 2:
					account.witdraw(500);
					break;
				case 3:
					System.out.println("Final Account Balance is: $"+account.getBalance());
					break;
				default :
					System.out.println("Please select valid option");
					choice=false;
					System.exit(0);
					break;
			}	
		}
	}
}

