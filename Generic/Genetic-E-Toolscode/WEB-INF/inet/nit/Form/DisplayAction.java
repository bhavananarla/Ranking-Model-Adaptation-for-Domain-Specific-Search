package inet.nit.Form;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

	public class DisplayAction extends HttpServlet{
	Connection con=null;
	Statement stmt=null;
	Statement st=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	try{
		res.setContentType("text/html");
			java.util.Date d=new java.util.Date();
			long l=d.getTime();
			res.setDateHeader("expires",l);

		res.setContentType("text/html");
		PrintWriter  out= res.getWriter();
		int formId=Integer.parseInt(req.getParameter("formid"));
		System.out.println("this is the value has to be sent to db"+formId);
		String query="select  field from formdetails  where formid="+formId;
		String total="select listname from listmaster";
		Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","root","root");
		stmt=con.createStatement();
		 rs=stmt.executeQuery(query);
		int i=0;
		out.println("<html><head>");
		out.println("<title>AvailableForms</title></head><body bgcolor=\"227050\"><center><img src=\"generic.bmp\"></center><form action=\"StoreInDatabase\">");
		out.println("<table border=1 align=center bgcolor=909090>");
		while(rs.next()){
		String x="Fname"+i;
		String Fieldname=rs.getString("field")	;
		out.println("<tr><td>");
		out.println(Fieldname);
		out.println("</td><td>");
		out.println("<input type=text  name="+x+">");
		out.println("</td></tr>");
		i++;
		}
		stmt.close();
		//con.close();
		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:server","scott","tiger");
		st=con.createStatement();
		rs1=st.executeQuery(total);
		HttpSession session=req.getSession(true);
		session.setAttribute("value", ""+i);
		out.println("<tr><td>");
		out.println("listname");
		out.println("</td><td>");
		out.println("<select name=\"abcd\">");
		while(rs1.next()){
		String str=rs1.getString(1);
		System.out.println("<><><><><>"+str);
	out.println("<option value="+str+">"+str+"</option>");
		}
		out.println("</select>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("<input type=submit value=SEND name=sub>");
		out.println("</td></tr>");
		out.println("</table></form></body></html>");
		st.close();
		con.close();
		}catch(Exception e){}
	}
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			doPost(req,res);
		}
		
}
	
		

		

