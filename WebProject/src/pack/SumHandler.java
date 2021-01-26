package pack;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class SumHandler extends TagSupport{
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
			int sum=0; 
			for(int i=from;i<=to;i++)
			{
				sum=sum+i;
			}
			out.print(sum);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
