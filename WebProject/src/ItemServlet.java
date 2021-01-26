import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ItemServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int itemNumber=Integer.parseInt(request.getParameter("itemNo"));
		String lastName=request.getParameter("lName");
		String price=request.getParameter("price");
		String address=request.getParameter("address");
		String initial=request.getParameter("mName");
		String desc=request.getParameter("desc");
		String firstName=request.getParameter("fName");
		String cardType=request.getParameter("cardType");
		String cardNumber=request.getParameter("cardNumber");
		String recardNumber=request.getParameter("recardNumber");
		out.println("<body bgcolor=\"pink\">");
		out.println("<h3 align=\"center\">Reading All Request Parameters</h3>");
		out.println("<table border>");
		out.println("<tr style=\"background-color:#00FFFF\"><th>Parameter Name</th><th>Parameter Value</th></tr>");
		out.println("<tr><td>itemNum</td><td>"+itemNumber+"</td></tr>");
		out.println("<tr><td>lastName</td><td>"+lastName+"</td></tr>");
		out.println("<tr><td>price</td><td>"+price+"</td></tr>");
		out.println("<tr><td>address</td><td>"+address+"</td></tr>");
		out.println("<tr><td>initial</td><td>"+initial+"</td></tr>");
		out.println("<tr><td>description</td><td>"+desc+"</td></tr>");
		out.println("<tr><td>firstName</td><td>"+firstName+"</td></tr>");
		out.println("<tr><td>cardType</td><td>"+cardType+"</td></tr>");
		out.println("<tr><td>cardNum</td><td><ul><li>"+cardNumber+"</li><li>"+recardNumber+"</li></ul></td></tr>");
		out.println("</table>");
		out.println("</body>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
