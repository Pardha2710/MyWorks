package assignment2;

import java.util.Scanner;

public class PriceFinder {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		double discount=0.0;
		System.out.println("Enter the Item Number:");
		int itemNumber=s.nextInt();
		
		System.out.println("Enter the Item Name:");
		String itemName=s.next();
		
		System.out.println("Enter the Price of the Item:");
		double price=s.nextDouble();
		
		System.out.println("Enter the quantity:");
		int quantity=s.nextInt();
		
		if(price >=1000 && price<2000)
		{
			discount=0.10*price;
		}
		else if (price>=2000 && price < 3000) {
			discount=0.15 * price;
		}
		else if (price>=3000 && price < 5000) {
			discount=0.20 * price;
		}
		else if(price>=5000)
		{
			discount =0.25 * price;
		}
		else
		{
			System.out.println("No Discount for this Price");
		}
		
		double netPrice = price - discount;
		
		System.out.println("Item Details:\n--------------");
		System.out.println("Item Number: "+itemNumber);
		System.out.println("Item Name: "+itemName);
		System.out.println("Item Price: Rs "+price);
		System.out.println("Discount for "+itemName+" :Rs "+discount);
		System.out.println("Net Price of Item: Rs"+netPrice);
	}

}
