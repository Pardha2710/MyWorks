package assignment12;

class WithdrawException extends Exception
{
	WithdrawException(String msg)
	{
		super(msg);
	}
	WithdrawException(){}

}
class Account
{
	private int accountId;
	private String accountType;
	Account(int accountId,String accountType)
	{
		this.accountId=accountId;
		this.accountType=accountType;
	}
	void withdraw(int amount,int balance) throws WithdrawException
	{
		if(amount>balance)
		{
			throw new WithdrawException("Balance is less than amount to withdraw!");
		}
		else
		{
			int result=balance-amount;
			System.out.println("The Account Balance is: $"+result);
		}
	}
}
public class WithdrawTest
{
	public static void main(String[] args) {
		Account a=new Account(10001,"SAVINGS");
		try
		{
			a.withdraw(1000,500);
		}
		catch(WithdrawException e) {
			//System.out.println(e);
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

}

}