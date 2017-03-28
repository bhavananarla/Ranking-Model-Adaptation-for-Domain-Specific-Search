package inet.nit.List;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
 
public class CreateList extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
			java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);

		PrintWriter out = res.getWriter();
		out.println("<html><head><title>");
out.println("detailspage</title></head>");
out.println("<body bgcolor=227050><center><img src=\"generic.bmp\"></center><form action=\"CreateListServlet\">");
out.println("<h3><center>LISTDETAILS</center></h3>");
out.println("<table align=center border =4 bgcolor=909090>");
out.println("<tr><td>enter listId</TD>");
out.println("<td><input type=\"text\" name=\"listid\"></td></tr>");
out.println("<tr><td>enter listName</TD>");
out.println("<td><input type=\"text\" name=\"listname\"></td></tr>");
out.println("<tr><td>enter NO Of Customers</TD>");
out.println("<td><input type=\"text\" name=\"num_of_emp\"></td></tr>");
out.println("<input type=hidden name=enter value=true>");
out.println("<tr><td><input type=\"submit\"name=\"submit\" value=\"submit\"><td></tr>");
out.println("</table></form></body></html>");

	}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{doPost(req,res);}

}