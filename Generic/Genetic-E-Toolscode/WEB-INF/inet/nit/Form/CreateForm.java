package inet.nit.Form;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
 
public class CreateForm extends HttpServlet
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
out.println("<body bgcolor=227050><center><img src=\"generic.bmp\"></center><form action=\"CreateFormServlet\">");
out.println("<h3><center>CREATION OF FORMS</center></h3>");
	
out.println("<table align=center border =4 bgcolor=909090>");
out.println("<tr><td>ENTER FORMID::</TD>");
out.println("<td><input type=\"text\" name=\"formid\"></td></tr>");
out.println("<tr><td>ENTER FORMNAME</TD>");
out.println("<td><input type=\"text\" name=\"formname\"></td></tr>");
out.println("<tr><td>ENTER NO.OF FIELDS</TD>");
out.println("<td><input type=\"text\" name=\"num_of_fields\"></td></tr>");
out.println("<input type=hidden name=enter value=true>");
out.println("<tr><td><input type=\"submit\"name=\"submit\" value=\"submit\"><td></tr>");
out.println("</table></form>");
out.println("</body></html>");

	}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{doPost(req,res);}

}