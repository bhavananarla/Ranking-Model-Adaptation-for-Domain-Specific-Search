package inet.nit.List;
 
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
		
		public class ListDelete extends HttpServlet
		{
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{	try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			int number=Integer.parseInt(req.getParameter("lis"));
			ListManager manager =new ListManager();
			manager.DeleteData(number);
			out.println("<html><body bgcolor=227050>");
			out.println("<center><img src=\"generic.bmp\"></center>");
			out.println("<h3>Successfully Deleted</h3>");
			out.println("<a href=\"ListPage.html\"><center>Home</center></a>");
			out.println("</body></html>");
			}catch(Exception e){}
		}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
		}
	}


