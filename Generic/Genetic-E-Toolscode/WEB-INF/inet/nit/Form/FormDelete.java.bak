package inet.nit.Form;
 import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
		
		public class FormDelete extends HttpServlet
		{
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{	try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			int number=Integer.parseInt(req.getParameter("del"));
			FormManager manager =new FormManager();
			manager.DeleteData(number);
			out.println("<html><body bgcolor=#ffddcc>");
			out.println("<h3>Successfully Deleted</h3>");
			out.println("<a href=\"FormPage.html\"><center>Home</center></a>");
			out.println("</body></html>");
			}catch(Exception e){}
		}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
		}
	}


