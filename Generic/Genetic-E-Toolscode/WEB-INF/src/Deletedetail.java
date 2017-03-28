package inet.nit.List;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
	public class Deletedetail extends HttpServlet
	{
		Connection con=null;
		Statement st=null;
		PrintWriter out;
		
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try{
		
		res.setContentType("text/html");
		System.out.println("1");
		out=res.getWriter();
		System.out.println("1+++");		
		
	Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
				System.out.println("3");
		st=con.createStatement();
		System.out.println("4");
		ResultSet rs=st.executeQuery("select Listno,name,email from listdetails");
		System.out.println("5");
		out.println("<html><body bgcolor=#ffddcc><form action=\"WebForm/Delfromdb\">");
		out.println("<table bgcolor=#bffcd3 align=center><tr><td>");
		out.println("ListId::");
		out.println("</td><td>");
		out.println("+lis+");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("Name::");
		out.println("</td><td>");
		out.println("<select name=liname>");
		while(rs.next()){
		out.println("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
		}
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("Email::");
		out.println("</td><td>");
		out.println("<select name=liemail>");
		out.println("<option value="+rs.getString(2)+">"+rs.getString(2)+"</option>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("<input type=submit value=Delete name=del>");
		out.println("</td></tr>");
		out.println("</table></form>");
		out.println("</body></html>");
		}//try
		catch(Exception e){
			e.printStackTrace();
		out.println(e);
		}
		finally{
			try{
			st.close();
			con.close();
			}catch(Exception e){e.printStackTrace();}
			}//finally

	}
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
				doPost(req,res);
		}
}	
		
		





