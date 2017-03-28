package inet.nit.Form;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

		public class DeleteForm extends HttpServlet
		{
			Connection con=null;
			Statement st=null;
			PrintWriter out=null;
			
			
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
			try{
			System.out.println(" In the Delete Form");

			res.setContentType("text/html");
			out=res.getWriter();
			
	Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select formid from form");
			out.println("<html><head><title>");
			out.println("DeleteForms</title></head>");
			out.println("<body bgcolor=227050><center><img src=\"generic.bmp\"></center><form action=\"DeleteForm\">");
			out.println("<table bgcolor=909090 align=center>");
			out.println("<tr><td>");
			out.println("SelectFormId");
			out.println("</td><td>");
			out.println("<select name=del>");
			while(rs.next()){
			out.println("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");	
			}//end of while.......
			out.println("</select></td></tr>");
			out.println("<tr><td>");
			out.println("<input type=submit value=Delete name=del>");
			out.println("</td></tr>");
			out.println("</table></form></body></html>");
		
			}//EOF try
			catch(Exception e){
				e.printStackTrace();
				out.println(e);
				
				}
			finally{
				try{
				st.close();
				//con.close();
				}catch(Exception e){e.printStackTrace();}
				}//eof finally;
	}
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req,res);
	}
}



			

