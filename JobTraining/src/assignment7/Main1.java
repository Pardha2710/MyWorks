package assignment7;

class Account1
{
	int accountNo;
	String accountType;
	int accountBalance;
	public Account1(int accountNo,String accountType,int accountBalance) {
		this.accountNo=accountNo;
		this.accountType=accountType;
		this.accountBalance=accountBalance;
	}
	void withdraw(int amount)
	{
		if(accountBalance>amount)
		{
			accountBalance=accountBalance-amount;
		}
		else
		{
			System.out.println("Insufficient Balance!");
		}
		System.out.println("Account Balance After Withdraw: $"+accountBalance);
	}
	void deposit(int amount)
	{
		if(amount>0)
		{
			accountBalance=accountBalance+amount;
		}
		else
		{
			System.out.println("Deposit valid amount!");
		}
		
		System.out.println("Account Balance After Deposit: $"+accountBalance);
		
	}
	void dispAccountDetails()
	{
		System.out.println("Account Number: "+accountNo+"\n"+"Account Type: "+accountType+"\n"+"Account Balance: $"+accountBalance);
	}
}

public class Main1 {

	public static void main(String[] args) {
		Account1 a=new Account1(10001, "Savings", 3000);
		a.withdraw(1700);
		a.deposit(500);
		a.dispAccountDetails();

	}

}
