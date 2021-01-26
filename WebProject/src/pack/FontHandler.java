package pack;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FontHandler extends TagSupport {
	private String style,color;
	private int size; 
	public void setStyle(String style)
	{
			this.style=style;
	}
	public void setSize(int size)
	{
			this.size=size;
	}
	public void setColor(String color)
	{
			this.color=color;
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
			out.println(style+" "+size+" "+color);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
