package assignment8;
class Book
{
	int bno;
	String bname;
	double price;
	Book(int bno,String bname,double price)
	{	
		this.bno=bno;
		this.bname=bname;
		this.price=price;
	}
	void display()
	{
		System.out.println("Book No: "+bno+"\nBook Name: "+bname+"\nPrice: "+price);
	} 
		
}
class SpecialEditionBook extends Book
{
	double discount;
	SpecialEditionBook(int bno,String bname,double price,double discount)
	{	
		super(bno,bname,price);
		this.discount=discount;
	}
	void display()
	{
		super.display();
		System.out.println("Discount: "+discount);
	}

	
}

class BookTest
{

	public static void main(String args[])
	{
		SpecialEditionBook special=new SpecialEditionBook(100,"THE SECRET",250.0,20);
		special.display();
				
	}
}
