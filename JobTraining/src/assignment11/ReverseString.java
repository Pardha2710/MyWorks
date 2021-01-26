package assignment11;

public class ReverseString {

	public static void main(String[] args) {
		//Scanner s=new Scanner(System.in);
		//System.out.println("Please Enter a sentence to reverse:");
		//String input=s.nextLine();
		String input="java is simple";
		String[] middle=input.split("\\s");
		for(String str:middle)
		{
			String reverse="";
			for(int i=str.length()-1;i>=0;i--)
			{
				reverse=reverse+str.charAt(i);
			}
			System.out.print(reverse+" ");
		}
	}
}
