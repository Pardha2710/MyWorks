package assignment10.com.account;

public class Account {

	int acctId;
	String acctType;
	int acctBalance;
	
	public Account(int acctId, String acctType, int acctBalance) {
		this.acctId = acctId;
		this.acctType = acctType;
		this.acctBalance = acctBalance;
	}
	
	public void deposit(int amount)
	{
		if(amount>0)
		{
			acctBalance=acctBalance+amount;
			System.out.println("Account Balance after deposit is: $"+acctBalance);
		}
		else
		{
			System.out.println("Please Enter valid amount!");
		}
	}
	public void witdraw(int amount)
	{
		if(acctBalance>amount)
		{
			acctBalance=acctBalance-amount;
			System.out.println("Account Balance after withdraw is: $"+acctBalance);
		}
		else
		{
			System.out.println("Account Balance is less!");
		}
	}
	public int getBalance()
	{
		return acctBalance;
	}
	public void display()
	{
		System.out.println("AccountId: "+acctId+"\nAccount Type: "+acctType+"\nAccount Balance :$"+acctBalance);
	}
}

