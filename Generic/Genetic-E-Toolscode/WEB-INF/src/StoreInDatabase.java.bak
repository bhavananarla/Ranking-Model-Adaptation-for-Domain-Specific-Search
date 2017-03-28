package inet.nit.Form;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

	public class StoreInDatabase extends HttpServlet
	{
		Connection con=null;
		PreparedStatement stmt=null;
		String str1;
		int count=0;
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			res.setContentType("text/html");
			/*java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);
			*/
		
		PrintWriter out=res.getWriter();
		out.println("<html><head><body bgcolor=227050>");
		out.println("<center><img src=\"generic.bmp\"></center>");
		HttpSession session =req.getSession(true);
			
		StringBuffer buffer=new StringBuffer();
		int val=  Integer.parseInt((String)session.getAttribute("value"));
		for(int i=0;i<val;i++){
		
		str1=req.getParameter("Fname"+i);
		str1=str1+":";
			
			buffer.append(str1);
				
		}
		String laststr=buffer.toString();
			int msgId=count++;
			int status=0;
			String Listname=req.getParameter("abcd");
			System.out.println("#################"+Listname);
		try{
		Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
		stmt=con.prepareStatement("insert into message values(?,?,?,?)");
		stmt.setInt(1,msgId);
		stmt.setString(2,laststr);
		stmt.setInt(3,status);
		stmt.setString(4,Listname);
		stmt.executeUpdate();
		session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
		System.out.println("exception..."+e);
		}
		out.println("<center><img src=\"end.gif\"></center>");
	out.println("<a href=\"FormPage.html\"><center>Home</center></a>");
		out.println("</body></html>");
				
		}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
		doPost(req,res);
		}
}
		