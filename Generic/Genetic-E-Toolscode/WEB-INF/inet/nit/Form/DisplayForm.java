package inet.nit.Form;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

 public class DisplayForm extends HttpServlet
{
 Connection con=null;
 Statement stmt=null;
 String sel_sta="select formid,formname from form";
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
 try{
		res.setContentType("text/html");
			java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);

 res.setContentType("text/html");
 PrintWriter out= res.getWriter();
 
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","root","root");
 stmt=con.createStatement();
 ResultSet rs= stmt.executeQuery(sel_sta);
	out.println("<html><head>");
	out.println("<title>AvailableForms</title></head><body bgcolor=\"227050\"><center><img src=\"generic.bmp\"></center>");
	out.println("<h2><center>FormsAvailable</center></h2>");
	out.println("<table border=2 align=center bgcolor=#909090>");
	 while(rs.next()){
	out.println("<tr><td>");
                
 out.println("<a href=\"DisplayAction?formid="+rs.getString("formid")+"\">"+rs.getString("formname")+"</a>");
	out.println("</td></tr>");
// out.println(rs.getString("formid"));

}//end of while
out.println("</table></body></html>");
}//end of try
 catch(Exception e){
 System.out.println("THE ERROR IS"+e);
}//end of catch
 finally{
	try{
	 stmt.close();
 	con.close();
	}catch(Exception e){}
}//end of finally;
}//end of post
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	doPost(req,res);
		}
}//end of class
 