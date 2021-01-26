package assignment7;

class Customer
{
	int custId;
	String custName;
	String custAddress;
	Customer(int custId,String custName,String custAddress)
	{
		this.custId=custId;
		this.custName=custName;
		this.custAddress=custAddress;
	}	
	void display()
	{
		System.out.println("Customer Id: "+custId+"\nCustomer Name: "+custName+"\nAddress: "+custAddress);
	}
}
class Account
{
	int acctId;
	String acctType;
	double acctBalance;
	Customer customer;
	Account(int acctId,String acctType,double acctBalance,Customer customer)
	{
		this.acctId=acctId;
		this.acctType=acctType;
		this.acctBalance=acctBalance;
		this.customer=customer;
	}
	void display()
	{
		System.out.println("AccountId: "+acctId+"\nAccount Type: "+acctType+"\nAccount Balance :$"+acctBalance);
	}
}
public class AccountTest
{
	public static void main(String args[])
	{
		Customer c=new Customer(1001,"PARDHA","CANADA");
		Account a=new Account(2001,"SAVINGS",2000,c);
		c.display();
		a.display();
		
	}
	
}

