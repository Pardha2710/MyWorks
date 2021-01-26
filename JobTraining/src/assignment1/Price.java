package assignment1;
import java.util.Scanner;

public class Price {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter Item Number:");
		int itemNumber=scan.nextInt();
		
		System.out.println("Enter Item Name:");
		String itemName = scan.next();
		
		System.out.println("Enter Item rate:");
		float itemRate = scan.nextFloat();
		
		System.out.println("Enter Number of Items :");
		int quantity=scan.nextInt();
		
		System.out.println("Item Number: "+itemNumber);
		
		System.out.println("Item Name: "+itemName);
		
		System.out.println("Price of the Item : "+itemRate*quantity);
		
	}

}
