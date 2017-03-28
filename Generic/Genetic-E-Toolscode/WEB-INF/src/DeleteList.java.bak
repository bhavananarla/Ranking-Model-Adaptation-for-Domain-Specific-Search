package inet.nit.List;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

		public class DeleteList extends HttpServlet
		{
			Connection con=null;
			Statement st=null;
			PrintWriter out=null;
			
			
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
			try{
			
			res.setContentType("text/html");
			out=res.getWriter();
			
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select Listno from listmaster");
			out.println("<html><head><title>");
			out.println("DeleteLists</title></head>");
			out.println("<body bgcolor=227050><center><img src=\"generic.bmp\"></center><form action=\"ListDelete\">");
			out.println("<table border=1 bgcolor=#909090 align=center>");
			out.println("<tr><td>");
			out.println("SelectListId");
			out.println("</td><td>");
			out.println("<select name=lis>");
			while(rs.next()){
			out.println("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");	
			}//end of while.......
			out.println("</select></td></tr>");
			out.println("<tr><td>");
			out.println("<input type=submit value=Delete name=del>");
			out.println("</td></tr>");
			out.println("</table>");
			//out.println("<a href=\"/WebForm/Deletedetail\"><center>DeleteListDeatails</center></a>");
			
			out.println("</form></body></html>");
			
			}//EOF try
			catch(Exception e){
				e.printStackTrace();
				out.println(e);
				
				}
			finally{
				try{
				st.close();
				con.close();
				}catch(Exception e){e.printStackTrace();}
				}//eof finally;
	}
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}
}



			

