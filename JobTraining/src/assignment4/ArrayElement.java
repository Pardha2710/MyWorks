package assignment4;

public class ArrayElement {

	public static void main(String[] args) {
		int[] n={5,8,6,4,7};
		int temp;
		for (int i = 1; i < n.length; i++) 
		{
		    for (int j = i; j > 0; j--) 
		    {
		    	if (n[j] < n [j - 1])
		    	{
		    		temp = n[j];
		    		n[j] = n[j - 1];
		    		n[j - 1] = temp;
		    	}
		    }
		}
		
	}

}
