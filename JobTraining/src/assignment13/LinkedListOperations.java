package assignment13;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListOperations
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		LinkedList<Integer> al=new LinkedList<Integer>(); 
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		int ch;
		do
		{
			System.out.println("Perform the LinkedList Operations:");
			System.out.println("1. Add element at last");
			System.out.println("2. Add element at first");
			System.out.println("3. Add element at given position");
			System.out.println("4. Update element at given position");
			System.out.println("5. Delete the first element");
			System.out.println("6. Delete the last element");
			System.out.println("7. Delete the given element");
			System.out.println("8. Delete the element at given index");
			System.out.println("9. Display elements");
			System.out.println("10.Exit");
			System.out.println("Enter Your Choice:");
			ch=s.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("Enter an Integer element to add at the last:");
					try
					{
						al.addLast(s.nextInt());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					System.out.println("After AddLast operation Elements in the List are :"+al);
					break;
				case 2:
					System.out.println("Enter an Integer element to add at the first:");
					try
					{
						al.addFirst(s.nextInt());
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("After AddFirst operation Elements in the List are: "+al);
					break;

				case 3:
					System.out.println("Enter the index followed by element at that provided index:");
					try
					{
						al.add(s.nextInt(), s.nextInt());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					System.out.println("After Add at index operation Elements in the List are: "+al);
					break;
				case 4:
					System.out.println("Enter the index followed by element at that provided index:");
					try
					{
						al.set(s.nextInt(), s.nextInt());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					System.out.println("After UpdateElement operation Elements in the List are: "+al);
					break;

				case 5:
					al.pollFirst();
					System.out.println("After deleting first element operation Elements in the List are: "+al);
					break;
				case 6:
					al.pollLast();
					System.out.println("After deleting last element operation Elements in the List are:"+al);
					break;
				case 7:
					System.out.println("Enter an integer that you want to delete from the list:");
					try
					{
						al.remove(s.nextInt());
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					System.out.println("Elements in the List :"+al);
					break;
				case 8:
					System.out.println("Enter an index value to delete an element from the list:");
					try
					{
						al.remove(s.nextInt());
					}
					catch (Exception e) {
						e.getMessage();
					}
					System.out.println("Elements in the List :"+al);
					break;
				case 9:	
					System.out.println("Elements in the List :"+al);
					break;
				case 10:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					
			}
		
		}while(ch!=10);
		
	}
}