package pack;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeHandler extends TagSupport {
	private int to,from;
	public void setTo(int to) {
		this.to = to;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int doStartTag()
	{
		return SKIP_BODY;
	}
	public int doEndTag()
	{
		try
		{
			JspWriter out=pageContext.getOut();
			int i =0;
		       int num =0;
		       String  primeNumbers = "";
		       for (i = from; i <= to; i++)         
		       { 		  	  
		          int counter=0; 	  
		          for(num =i; num>=1; num--)
		          {
		             if(i%num==0)
		             {
		            	 counter = counter + 1;
		             }
		          }
		          if(counter ==2)
		          {
		        	  primeNumbers = primeNumbers + i + " ";
		          }	
		       }	
		       out.println(primeNumbers);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
